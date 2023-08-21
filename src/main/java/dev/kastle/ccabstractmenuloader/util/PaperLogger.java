package dev.kastle.ccabstractmenuloader.util;

import lombok.AllArgsConstructor;

import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
public class PaperLogger {
    private final Logger logger;

    public void severe(String message) {
        logger.severe(message);
    }

    public void severe(String message, Throwable error) {
        logger.log(Level.SEVERE, message, error);
    }

    public void error(String message) {
        logger.warning(message);
    }

    public void error(String message, Throwable error) {
        logger.log(Level.WARNING, message, error);
    }

    public void warn(String message) {
        error(message);
    }

    public void warn(String message, Throwable error) {
        error(message, error);
    }

    public void info(String message) {
        logger.info(message);
    }
}
