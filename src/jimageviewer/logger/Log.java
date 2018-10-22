/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimageviewer.logger;

import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Log {
    private static Logger logger;
    static {
        Log.logger = Logger.getLogger(Log.class.getName());
    }

    public static void info(String msg) {
        Log.logger.info(msg);
    }

    public static void debug(String msg) {
        Log.logger.fine(msg);
    }

    public static void warning(String msg) {
        Log.logger.warning(msg);
    }

    public static void error(String msg) {
        Log.logger.severe(msg);
    }
}
