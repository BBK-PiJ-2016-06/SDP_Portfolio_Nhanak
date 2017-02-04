package reflection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nathanhanak on 2/4/17.
 *
 * Class which satisfies Question number 2 for Further Java Reflection
 *
 * Class reads a class name from the cmd line as the first argument
 * Further arguments read from cmd line are treated as parameters to constructor
 * Class then instantiates an object of the passed class.
 */
public class ClassThenConstructorArgsReader {

    private Class cls;
    private Class[] clsParams;
    private Constructor clsConstructor;

    public static void main(String[] args) {
        ClassThenConstructorArgsReader runner = new ClassThenConstructorArgsReader();
        runner.run(args);
    }

    public void run(String[] args){
        try {
            this.cls = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        buildClsParams(args);

        try {
            clsConstructor = cls.getConstructor(clsParams);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private void buildClsParams(String[] args) {
        clsParams = new Class[args.length-1];
        for(int i = 0; i < args.length; i ++) {
            try {
                clsParams[i] = Class.forName(args[i+1]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }




}
