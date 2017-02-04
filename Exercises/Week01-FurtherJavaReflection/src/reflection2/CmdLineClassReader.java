package reflection2;

import java.lang.reflect.*;

/**
 * Created by nathanhanak on 2/3/17.
 *
 * Class which satisfies Question number 1 for Further Java Reflection
 */
public class CmdLineClassReader {

    private Class cls;
    private String packageName = "package ";
    private String className;
    private String topLine = "public ";
    private String memberFields = "    ";
    private String constructors = "    ";
    private String methods =  "    ";

    public static void main(String[] args) {
        CmdLineClassReader runner = new CmdLineClassReader();
        runner.run(args[0]);
    }

    private void run(String arg){

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
        constructMethods();

        printResults();
    }

    private void printResults() {
        System.out.println(packageName + ";" + "\n");
        System.out.println(topLine + "\n");
        System.out.println(memberFields + "\n");
        System.out.println(constructors);
        System.out.println(methods);
        System.out.println("}");
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
            constructors += returnMethodParameters(constructorParams);
            constructors += ") ; \n    ";
        }
    }

    private void constructMethods(){
        Method[] clsMethods = cls.getDeclaredMethods();
        for (Method m : clsMethods) {
            m.setAccessible(true);
            methods += Modifier.toString(m.getModifiers()) + " ";
            methods += m.getReturnType().getSimpleName() + " ";
            methods += m.getName() + "(";
            Parameter[] methodParams = m.getParameters();
            methods += returnMethodParameters(methodParams);
            methods += "); \n    ";
        }
    }

    private String returnMethodParameters(Parameter[] params) {
        String result = "";
        int counter = params.length;
        if (params.length != 0) {
            for (Parameter p : params) {
                    result += p.getType().getSimpleName() + " ";
                    result += p.getName();
                    if (counter != 1) {
                        result += ", ";
                    }
                    counter--;
                }
            }
        return result;
    }



}
