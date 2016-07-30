import org.stepic.java.logging.classA;
import org.stepic.java.logging.classB;

import java.util.logging.*;

public class main {

    private static void configureLogging() {
        Logger LOGGERA = Logger.getLogger(classA.class.getName());
        Logger LOGGERB = Logger.getLogger(classB.class.getName());
        LOGGERA.setLevel(Level.ALL);
        LOGGERB.setLevel(Level.WARNING);
        Logger LOGGERM = Logger.getLogger("org.stepic.java");

        XMLFormatter f = new XMLFormatter();
        ConsoleHandler h  = new ConsoleHandler();
        h.setFormatter(f);
        h.setLevel(Level.ALL);
        LOGGERM.addHandler(h);
        LOGGERM.setLevel(Level.WARNING);

        LOGGERM.setUseParentHandlers(false);
    }

    public static void main(String[] args) {
        configureLogging();
    }
}
