package reflection2;

import java.util.ArrayList;

/**
 * Created by nathanhanak on 2/4/17.
 *
 * Class specifically designed to fail all parts of question 3:
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
public class Question3FailAllTests {

    public int i = 3;
    private String s = "fail";
    private ArrayList ar = new ArrayList();
    private Double d = 4.3;
    private String s2;


    public Question3FailAllTests(String word) {
        s2 = word;
    }

    public int returnsAnInt() {
        helperMethod();
        return i;
    }

    public void doSomething(String s) throws IllegalArgumentException {
        this.s += s;
    }

    private void helperMethod() {
        i += 3;
    }

}
