package bloc_four;

public class Test_02 {
    public static String getCallerClassAndMethodName() {
        Exception e = new Exception();
        StackTraceElement[] elements = e.getStackTrace();
        if (elements.length > 2) {
            StackTraceElement caller = elements[2];
            return caller.getClassName() + "#" + caller.getMethodName();
        }
        return null;
    }

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        System.out.println(getCallerClassAndMethodName());
    }
}
