import java.util.*;
import java.io.*;

public class WordSearch{
    private char[][]data;
    private int seed;
    private Random randgen;
    private ArrayList<String>wordsToAdd;
    private ArrayList<String>wordsAdded;


    public WordSearch(int rows,int cols, String fileName){
    // Choose a randSeed using the clock Random.
      randgen = new Random(seed);
      readFile(fileName);
      constructSearch(rows, cols, fileName);
    }

    public WordSearch(int rows, int cols, String fileName, int randSeed){
    // Use the random seed specified.
      randSeed = this.seed;
      randgen = new Random(randSeed);
      readFile(fileName);
      constructSearch(rows, cols, fileName);
    }

    public void constructSearch(int rows, int cols, String fileName){
      // Helper method!
      data = new char[rows][cols];
      for (int i = 0; i < data.length; i++){
        for (int j = 0; j < data[i].length; j++){
          data[i][j] = '_';
        }
      }
    }

    public void readFile(String fileName){
      // Checks to see if file exists and adds words to wordsToAdd.
      try {
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while(in.hasNext()){
        try {
        String line = in.nextLine();
        wordsToAdd.add(line);
        }
        catch (NullPointerException n) {}
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
    // You need to add words and seed!

    String result = "";
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
          if (j == 0){
          result += "|" + data[i][j] + " ";
          } else if (j == data[i].length - 2){
          result += data[i][j];
          } else if (j == data[i].length - 1){
            result += "|" + "\n";
          } else {
            result += data[i][j] + " ";
          }
        }
      }
      return result + "Words:";
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){

        if (data[row].length - col >= word.length()){
          for (int i = 0; i < word.length(); i++){
            if (data[row][col + i] == word.charAt(i)){
            data[row][col + i] = word.charAt(i);
            }
          }
          return true;
        } else {
      return false;
        }
      }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){

      if(data.length - row >= word.length()) {
        for(int i = 0; i < word.length(); i++) {
            if (data[row + i][col] == word.charAt(i)){
            data[row + i][col] = word.charAt(i);
          }
        }
          return true;
        } else {
          return false;
        }
      }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical location of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word,int row, int col){
      if ((data[row].length - col >= word.length()) && (data.length - row >= word.length())){
      for (int i = 0; i < word.length(); i++){
        if (data[row + i][col + i] == word.charAt(i)){
        data[row + i][col + i] = word.charAt(i);
      }
    }
      return true;
    } else {
      return false;
    }
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

     // Checks if rowchange or colchange are both 0.
     if (rowIncrement == 0 && colIncrement == 0){
       return false;
     }

     try {
       // Checks for overlapping letters.
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


    // Runs if word meets all requirements.
      for (int j = 0; j < word.length(); j++){
        data[r][c] = word.charAt(j);
        r += rowIncrement;
        c += colIncrement;
      }
      return true;
    }

}
