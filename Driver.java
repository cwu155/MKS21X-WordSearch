public class Driver {

  public static void main(String[] args) {

    WordSearch WSe = new WordSearch(10,14,"words.txt");

    System.out.println("WordSearch WSe = new WordSearch(10,14,\"words.txt\")");
    System.out.println(WSe);
    /*
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    */

    // System.out.println("WSe.addWord(\"CLOUD\",0,2,0,0)");
    // if(WSe.addWord("CLOUD",0,2,0,0)) {
    //   System.out.println("> addition success.");
    //   System.out.println("> TEST CASE - FAIL");
    // } else {
    //   System.out.println("> addition failure.");
    //   System.out.println("> TEST CASE - PASS");
    // }
    // // > addition failure.
    // // should fail, rowIncrement and colIncrement both equal 0
    //
    // System.out.println(WSe);
    // /*
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    // */
    //
    // System.out.println("WSe.addWord(\"CLOUD\",0,2,0,1)");
    // if(WSe.addWord("CLOUD",0,2,0,1)) {
    //   System.out.println("> addition success.");
    //   System.out.println("> TEST CASE - PASS");
    // } else {
    //   System.out.println("> addition failure.");
    //   System.out.println("> TEST CASE - FAIL");
    // }
    // // > addition success.
    // // should succeed, CLOUD is within bounds, no destructive interference
    //
    // System.out.println(WSe);
    // /*
    //   |_ _ C L O U D _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    //   |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    // */
   }

}
