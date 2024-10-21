package bloc_four;

import java.util.logging.*;

public class LoggingExample {
    public static void configureLogging() {
        Logger classALogger = Logger.getLogger("org.stepic.java.logging.ClassA");
        classALogger.setLevel(Level.ALL);

        Logger classBLogger = Logger.getLogger("org.stepic.java.logging.ClassB");
        classBLogger.setLevel(Level.WARNING);

        Logger javaLogger = Logger.getLogger("org.stepic.java");
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new XMLFormatter());
        consoleHandler.setLevel(Level.ALL);
        javaLogger.addHandler(consoleHandler);
        javaLogger.setUseParentHandlers(false);
        javaLogger.setLevel(Level.ALL);
    }

    public static void main(String[] args) {
        configureLogging();

        Logger classALogger = Logger.getLogger("org.stepic.java.logging.ClassA");
        classALogger.fine("Fine log from ClassA");
        classALogger.info("Info log from ClassA");
        classALogger.warning("Warning log from ClassA");

        Logger classBLogger = Logger.getLogger("org.stepic.java.logging.ClassB");
        classBLogger.fine("Fine log from ClassB (should not appear)");
        classBLogger.info("Info log from ClassB (should not appear)");
        classBLogger.warning("Warning log from ClassB");

        Logger javaLogger = Logger.getLogger("org.stepic.java");
        javaLogger.info("Info log from org.stepic.java");
        javaLogger.severe("Severe log from org.stepic.java");
    }
}