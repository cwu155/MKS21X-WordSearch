public class Driver {

  public static void main(String[] args) {

    WordSearch WSe2 = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),"words.txt");
    System.out.println("WordSearch WSe2 = new WordSearch(args[0],args[1],\"words.txt\")");
    /*
      example:
      java Driver_Test 10 12
      |_ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _|

      example:
      java Driver_Test 3 5
      |_ _ _ _ _|
      |_ _ _ _ _|
      |_ _ _ _ _|

      example:
      java Driver_Test 6 6
      |_ _ _ _ _ _|
      |_ _ _ _ _ _|
      |_ _ _ _ _ _|
      |_ _ _ _ _ _|
      |_ _ _ _ _ _|
      |_ _ _ _ _ _|
    */

    WSe2.addAllWords();
    System.out.println(WSe2);
    // hopefully filled WordSearch
   }

}
