package reflection2;

/**
 * Created by nathanhanak on 2/4/17.
 *
 *  * Class specifically designed to pass all parts of question 3:
 *
 * Fails if: 
 * more than four fields
 * any non-private fields
 * any fields of type ArrayList
 * fewer than two private helper methods
 * any method that has a throws clause
 * any method that returns an int
 * missing a zero-argument constructor
 */
public class Question3PassesAllTests {

   private int i = 2;
   private String s;

   public Question3PassesAllTests() {
       s = "Cool";
   }

   public void setS(String s) {
       this.s = s;
   }

   public void addToSandPrint(String b) {
       addAWord();
       printS();
   }

   private void addAWord() {
       s += ", neat";
   }

   private void printS(){
       System.out.println(s);
   }

}
