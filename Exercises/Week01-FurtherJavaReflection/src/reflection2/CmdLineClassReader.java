package reflection2;

import reflection2.DummyInterfaceImpl;
import reflection2.DummyInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Created by nathanhanak on 2/3/17.
 */
public class CmdLineClassReader {

    private Class cls;
    private String packageName = "package ";
    private String className;
    private String topLine = "public ";
    private String memberFields = "    ";
    private String constructors = "    ";

    public static void main(String[] args) {
        CmdLineClassReader runner = new CmdLineClassReader();
        runner.run(args[0]);
    }

    public void run(String arg){

        try {
            this.cls = Class.forName(arg);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        className = cls.getSimpleName();
        packageName += cls.getPackage().getName();

        constructClassDeclaration();
        constructMemberfields();
        constructConstructors();

        printResults();
    }

    private void printResults() {
        System.out.println(packageName + ";" + "\n");
        System.out.println(topLine + "\n");
        System.out.println(memberFields + "\n");
        System.out.println(constructors);
    }

    private void constructClassDeclaration(){
        if (cls.isInterface()) {
            topLine += "interface ";
        } else {
            topLine += "class ";
        }
        topLine += cls.getSimpleName() + " ";
        topLine += getClassExtensions();
        topLine += getClassImplementations();
        topLine += "{";
    }

    private String getClassExtensions(){
        String result = "";
        Class superClass = cls.getSuperclass();
        if (superClass != null && !superClass.getSimpleName().equals("Object") ) {
            result = "extends " + superClass.getSimpleName() + " ";
        }
        return result;
    }

    private String getClassImplementations() {
        String result = "";
        Class[] interfaces = cls.getInterfaces();
        if (interfaces.length != 0) {
            result = "implements ";
            int counter = interfaces.length;
            for ( Class c : interfaces ) {
                result+= c.getSimpleName();
                if (counter != 1) {
                    result += ", ";
                }
                counter --;
            }
        }
        return result + " ";
    }

    private void constructMemberfields() {
        Field[] fields = cls.getDeclaredFields(); // gets all fields
        for (Field f: fields) {
            f.setAccessible(true);
            memberFields += Modifier.toString(f.getModifiers()) + " ";
            memberFields += f.getType().getSimpleName() + " ";
            memberFields += f.getName();
            memberFields += "; \n    " ;
        }
    }

    private void constructConstructors(){
        Constructor[] clsConstructors = cls.getDeclaredConstructors();
        for (Constructor c: clsConstructors) {
            c.setAccessible(true);
            constructors += Modifier.toString(c.getModifiers()) + " ";
            String constructorName = c.getName();
            constructors += constructorName.substring(constructorName.lastIndexOf(".") + 1) + "(";
            Parameter[] constructorParams = c.getParameters();
            if (constructorParams.length != 0) {
                for (Parameter p : constructorParams ) {
                    constructors += p.getType().getSimpleName() + " ";
                    constructors += p.getName();
                }
            }
            constructors += ") ; \n";
        }
    }



}
