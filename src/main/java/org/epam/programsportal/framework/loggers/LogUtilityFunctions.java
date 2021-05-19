package org.epam.programsportal.framework.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtilityFunctions {

    static Logger log = LogManager.getLogger();

//    public static void main(String[] args) {
//        logInfoMessage("In Loggers Utility Function");
//    }

    public static void logInfoMessage(String info) {
        log.info(info);
    }

    public static void errorMessage(String message) {
        log.error(message);
    }


}
