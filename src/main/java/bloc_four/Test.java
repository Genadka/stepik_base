package bloc_four;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        // stackTraceElements[0] - это сам метод getStackTrace (или Throwable constructor)
        // stackTraceElements[1] - это метод getCallerClassAndMethodName
        // stackTraceElements[2] - это метод, который вызвал getCallerClassAndMethodName
        if (stackTraceElements.length > 2) {
            StackTraceElement caller = stackTraceElements[2];
            return caller.getClassName() + "#" + caller.getMethodName();
        } else {
            return null;
        }
    }
}
