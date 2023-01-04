package net.marscraft.skyrpgstructure.shared.logging.logger;

import net.marscraft.skyrpgstructure.shared.logging.LogLevel;

import java.util.List;
import java.util.Optional;

public interface ILogger {


    /**
     * Writes a Log
     * @param logLevel The Log Level
     * @param message A Custom Message that gets displayed
     * @param ex An Exception if one Occurred. The Stacktrace gets Displayed as String
     * */
    void log(LogLevel logLevel, Optional<List<LoggerField>> message, Optional<Exception> ex);
    void log(LogLevel logLevel, LoggerField message, Optional<Exception> ex);

    /**
     * Returns the name of the Logger
     * @return Logger name
     * */
    String getName();

}
