package reflection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

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

        //this last part actually not necessary as is. Works because it creates
        //an array of 2 String objects, which is what the method requires
        //only works this way with Strings, otherwise you have to know what the param types are
        //for the method you're trying to instantiate
        Object[] clsParamsAsString = new String[clsParams.length];
        for (int i = 0; i < clsParamsAsString.length; i++) {
             clsParamsAsString[i] = clsParams[i].getSimpleName()+".class";
        }

        try {
            Object o = clsConstructor.newInstance(clsParamsAsString);
            System.out.println("Object I got is: " + o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private void buildClsParams(String[] args) {
        clsParams = new Class[args.length-1];
        for(int i = 0; i < args.length-1; i ++) {
            try {
                clsParams[i] = Class.forName(args[i+1]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }






}
