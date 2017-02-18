package sml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by nathanhanak on 2/17/17.
 */
public class SMLInstructionFactory {

    public Instruction makeInstruction(String[] fields) {
        Instruction result = null;
        try {
            Class instructionClass = Class.forName(generateClassName(fields[1]));
            Constructor[] constructor = instructionClass.getConstructors();
            System.out.println("how many constructors? " + constructor.length);
            System.out.println("how many params does that constructor have?" + constructor[0].getParameterCount());
            System.out.println("and they are: ");
            Class[] cParams = constructor[0].getParameterTypes();
            for (Class c : cParams) {
                System.out.println(c.getSimpleName());
            }
            Object[] args = generateConstructorArgs(fields, constructor[0].getParameterTypes());
            result = (Instruction) constructor[0].newInstance(args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String generateClassName(String prefix) {
        return ("sml." + prefix.substring(0, 1).toUpperCase() + prefix.substring(1).toLowerCase() + "Instruction");
    }

    /**
     * Constructs an Object[] to be used for creating an instance of the class in makeInstruction(String[])
     * @param fields a String[] containing a line read from original SML file to convert into parameters
     * @param cArgs the parameters of types derived from the class to be instantiated
     * @return Object[] containing instantiated objects needed to pass through a constructor
     */
    private Object[] generateConstructorArgs(String[] fields, Class[] cArgs) {
        if (fields.length != cArgs.length) {
            throw new IllegalArgumentException("SML argument length and Instruction parameter mismatch");
        }
        Object[] result = new Object[fields.length];
        for (int i = 0; i < fields.length; i++) {
            if (cArgs[i].isInstance(i)) { // checks to see if parameter is an Int
                result[i] = Integer.parseInt(fields[i]);
            } else { // can otherwise assume the parameter is a String
                result[i] = fields[i];
            }
        }
        return result;
    }
}
