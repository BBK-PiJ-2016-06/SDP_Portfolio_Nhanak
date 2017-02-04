package reflection2;

import org.junit.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nathanhanak on 2/4/17.
 *
 * Test class to satisfy answer for Question 3 of Further Java reflection.
 *
 * Fails if: 
 * more than four fields
 * any non-private fields
 * any fields of type ArrayList
 * fewer than two private helper methods
 * any method that has a throws clause
 * any method returns an int
 * missing a zero-argument constructor
 */

public class Question3Test {

    Class cls;
    Field[] fields;
    Method[] methods;

    @Before
    //Change the content of Class.forName() accordingly to test desired class
    public void setUp() throws Exception {
        cls = Class.forName("reflection2.Question3PassesAllTests");
        fields = cls.getDeclaredFields();
        methods = cls.getDeclaredMethods();
    }

    @After
    public void cleanUp() {
        cls = null;
        fields = null;
        methods = null;
    }

    @Test
    public void AssertThereAreLessThan5Fields() {
        assertTrue(fields.length < 5);
    }

    @Test
    public void AssertAllFieldsArePrivate() {
        Boolean allFieldsPrivate = true;
        for (Field f: fields) {
            if (!Modifier.isPrivate(f.getModifiers())){
                allFieldsPrivate = false;
            }
        }
        assertTrue(allFieldsPrivate);
    }

    @Test
    public void AssertNoFieldsAreOfTypeArrayList() {
        Boolean foundArrayList = false;
        for (Field f: fields) {
            f.setAccessible(true); // must do this otherwise getType just returns "Field"
            if (f.getType().getSimpleName().equals("ArrayList")) {
                foundArrayList = true;
            }
        }
        assertFalse(foundArrayList);
    }

    @Test
    public void AssertThereAreNoMoreThanTwoPrivateHelperMethods() {
        int counter = 0;
        for (Method m : methods) {
            if (Modifier.isPrivate(m.getModifiers())) {
                counter ++;
            }
        }
        assertTrue(counter < 3 );
    }

    @Test
    public void AssertAllMethodsHaveNoThrowsClause() {
        Boolean foundThrowsClause = false;
        for (Method m: methods) {
            Class[] c = m.getExceptionTypes();
            if (c.length != 0) {
                foundThrowsClause = true;
            }
        }
        assertFalse(foundThrowsClause);
    }

    @Test
    public void AssertNoMethodsReturnInt() {
        Boolean foundMethodReturningInt = false;
        for (Method m : methods) {
            if (m.getReturnType().getSimpleName().equals("int")) {
                foundMethodReturningInt = true;
            }
        }
        assertFalse(foundMethodReturningInt);
    }

    @Test
    public void AssertClassContainsParamterlessConstructor() {
        Boolean methodNotFound = false;
        try {
            Constructor constructor = cls.getDeclaredConstructor();
        } catch (NoSuchMethodException ex) {
            methodNotFound = true;
        }
        assertFalse(methodNotFound);
    }

}