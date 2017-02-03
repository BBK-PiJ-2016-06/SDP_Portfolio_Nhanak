package reflection2;

import reflection2.DummyInterfaceImpl;
import reflection2.DummyInterface;

/**
 * Created by nathanhanak on 2/3/17.
 */
public class CmdLineClassReader {

    private Class cls;
    private String topLine = "public ";
    private String packageName = "package ";
    private String className;

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

        printResults();
    }

    private void printResults() {
        System.out.println(packageName + ";" + "\n");
        System.out.println(topLine);
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


}
