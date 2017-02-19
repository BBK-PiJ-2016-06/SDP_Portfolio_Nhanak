package sml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by nathanhanak on 2/17/17.
 */
public class SMLInstructionFactory {

    /**
     * Method dissects a line from an SML program as a String
     * Interprets what type of Instruction class to build and instantiates using that Instruction's
     * parameters. Then invokes constructor to create and return an Instruction class
     * @param fields a single line from an SML file where each word is placed in to a String[]
     * @return Instruction object reflecting the type of instruction and parameters indicated in SML file
     */
    public Instruction makeInstruction(String[] fields) {
        Instruction result = null;
        try {
            Class instructionClass = Class.forName(generateClassName(fields[1]));
            Constructor[] constructor = instructionClass.getConstructors();
            Object[] args = generateConstructorArgs(fields, constructor[0].getParameterTypes());
            result = (Instruction) constructor[0].newInstance(args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * The "word" at fields[1] is the prefix for the name of the class we are trying to be build
     * This method extracts it and concatenates it with other Strings to build a fully qualified class name
     * @param prefix The String prefix of the type of Instruction we are trying to build
     * @return a fully qualified class name of the instruction we are trying to build
     */
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
            if (cArgs[i].getSimpleName().equals("int")) { // checks to see if parameter is an Int
                result[i] = Integer.parseInt(fields[i]);
            } else { // can otherwise assume the parameter is a String
                result[i] = fields[i];
            }
        }
        return result;
    }
}
