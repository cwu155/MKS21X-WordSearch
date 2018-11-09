import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
    private char[][]data;
     //the random seed used to produce this WordSearch
     private int seed;

     //a random Object to unify your random calls
     private Random randgen;

     //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
     private ArrayList<String>wordsToAdd;

     //all words that were successfully added get moved into wordsAdded.
     private ArrayList<String>wordsAdded;



    public WordSearch(int rows,int cols){
      if ((rows < 0) || (cols < 0)){
        throw new IllegalArgumentException("No negative indices!");
      }

      data = new char[rows][cols];
      clear();

    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for (int i = 0; i < data.length; i++){
        for (int j = 0; j < data[i].length; j++){
          data[i][j] = '_';
        }
      }
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */

    public String toString(){
    String result = "";
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j ++) {
          result += data[i][j] + " ";
          if (j == data[i].length - 1){
            result += "\n";
          }
        }
      }
      return result;
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

}
