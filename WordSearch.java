import java.util.*;
import java.io.*;

public class WordSearch{
    private char[][]data;
    private int seed;
    private Random randgen;
    private ArrayList<String>wordsToAdd = new ArrayList<String>();
    private ArrayList<String>wordsAdded = new ArrayList<String>();


    public WordSearch(int rows,int cols, String fileName){
    //Choose a randSeed using the clock Random.
      randgen = new Random();
      seed = Math.abs(randgen.nextInt(10000));
      readFile(fileName);
      constructSearch(rows, cols, fileName);
    }

    public WordSearch(int rows, int cols, String fileName, int randSeed){
    //Use the random seed specified.
      seed = randSeed;
      randgen = new Random(seed);
      readFile(fileName);
      constructSearch(rows, cols, fileName);
    }

    public void constructSearch(int rows, int cols, String fileName){
      //Helper method!
      data = new char[rows][cols];
      for (int i = 0; i < data.length; i++){
        for (int j = 0; j < data[i].length; j++){
          data[i][j] = '_';
        }
      }
    }

    public void readFile(String fileName){
      //Checks to see if file exists and adds words to wordsToAdd.

      try {
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while(in.hasNext()){
        try {
        String line = in.nextLine();
        wordsToAdd.add(line);
        }
        catch (NullPointerException n){
          System.out.println("Your!! Code!! Doesn't!! Work!!");
        }
      }

      } catch(FileNotFoundException e){
        System.out.println("File not found: " + fileName);
        //e.printStackTrace();
        System.exit(1);
        }
      }

    private void clear(){
      // Sets all values to underscores.
      for (int i = 0; i < data.length; i++){
        for (int j = 0; j < data[i].length; j++){
          data[i][j] = '_';
        }
      }
    }


    public String toString(){

     String words = "";
     for (int a = 0; a < wordsAdded.size(); a++){
       if (a == wordsAdded.size()-1){
         words += wordsAdded.get(a);
       } else {
         words += wordsAdded.get(a) + ", ";
       }
     }


    String result = "";
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
          if (j == 0){
          result += "|" + data[i][j] + " ";
          } else if (j == data[i].length - 1){
            result += data[i][j] + "|" + "\n";
          } else {
            result += data[i][j] + " ";
          }
        }
      }
      return result + "Words: " + words + " (seed: " + seed + ')';
    }


  /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added in the direction rowIncrement,colIncrement
     *Words must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical location of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@param rowIncrement is -1,0, or 1 and represents the displacement of each letter in the row direction
     *@param colIncrement is -1,0, or 1 and represents the displacement of each letter in the col direction
     *@return true when: the word is added successfully.
     *        false when: the word doesn't fit, OR  rowchange and colchange are both 0,
     *        OR there are overlapping letters that do not match
     */
    public boolean addWord(String word,int r, int c, int rowIncrement, int colIncrement){

    /*[rowIncrement,colIncrement] examples:
     *[-1,1] would add up and the right because (row -1 each time, col + 1 each time)
     *[ 1,0] would add downwards because (row+1), with no col change
     *[ 0,-1] would add towards the left because (col - 1), with no row change
     */

     //Checks if rowchange or colchange are both 0.
     if (rowIncrement == 0 && colIncrement == 0){
       return false;
     }

     //Checks for out of bounds
     if ((word.length() * rowIncrement > data.length - r) || (word.length() * colIncrement> data[0].length - c)){
       return false;
     }

    //Checks for overlapping letters.
      try {
        for (int i = 0; i < word.length(); i++){
          int row = r + (rowIncrement * i);
          int col = c + (colIncrement * i);
          if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
            return false;
          }
        }
      } catch (ArrayIndexOutOfBoundsException e){
        return false;
      }


    //Runs if word meets all requirements.
      for (int j = 0; j < word.length(); j++){
        data[r][c] = word.charAt(j);
        r += rowIncrement;
        c += colIncrement;
      }

      wordsToAdd.remove(word);
      wordsAdded.add(word);
      return true;
    }

    public void addAllWords(){
      int count = 0;

      for (int i = 0; 0 < wordsToAdd.size() && count < 10000; i++){
        String word = wordsToAdd.get(Math.abs(randgen.nextInt(wordsToAdd.size())));
        int rowIncrement = randgen.nextInt() % 2;
        int colIncrement = randgen.nextInt() % 2;
        int r = randgen.nextInt(data.length);
        int c = randgen.nextInt(data[0].length);

        if (!(addWord(word, r, c, rowIncrement, colIncrement))){
          count += 1;

        } else {
          addWord(word, r, c, rowIncrement, colIncrement);
          wordsAdded.remove(word); //No idea why this works. Without this line, wordsAdded would print each word twice.
        }
      }
    }


    public void fillGrid(){
      for (int i = 0; i < data.length; i++){
        for (int j = 0; j < data[0].length; j++){
          if (data[i][j] == '_'){
            data[i][j] = (char)(randgen.nextInt(26) + 'A');

          }
        }
      }
    }

    public static void main(String[] args) {
      String directions = "Your first command line argument is the number of rows of your WordSearch, the second the numbers of columns, and the third the name of the file containing all the words for your WordSearch.\nA seed integer from 0 to 10000 is optional for the 4th parameter. If you want access to the Answer Key, type 'key' into the 5th parameter.";

      boolean key = false;

      try {
      if (args.length < 3 || args.length > 5){
        System.out.println(directions);
      }

      if (args.length == 3){
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        String fileName = args[2];
        key = false;
        WordSearch wSearch = new WordSearch (rows, cols, fileName);
        wSearch.addAllWords();
        wSearch.fillGrid();
        System.out.println(wSearch);
      }

      if (args.length == 4){
        int seed = Integer.parseInt(args[3]);
        if (seed < 0 || seed > 10000) {
          System.out.println(directions);
        } else {
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        String fileName = args[2];
        WordSearch wSearch = new WordSearch (rows, cols, fileName, seed);
        wSearch.addAllWords();
        wSearch.fillGrid();
        System.out.println(wSearch);
        }
      }
      if (args.length == 5){
        key = true;
        int seed = Integer.parseInt(args[3]);
        if (seed < 0 || seed > 10000) {
          System.out.println(directions);
        } else {
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        String fileName = args[2];
        WordSearch wSearch = new WordSearch (rows, cols, fileName, seed);
        wSearch.addAllWords();
        System.out.println(wSearch);
      }
    }

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(directions);
    }
  }
}
