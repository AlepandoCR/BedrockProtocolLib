package gg.cloudworld.geyser.protocol.api.logger;

import gg.cloudworld.geyser.protocol.core.logger.BedrockLoggerImp;

/**
 * Represents a logger utility for handling messages within the Bedrock protocol API.
 * <p>
 * Provides methods for logging informational messages, warnings, and severe errors.
 * A singleton instance can be obtained through {@link #getInstance()}.
 */
public interface BedrockLogger {

    /**
     * Logs a standard informational message.
     *
     * @param content the message to log
     */
    void info(String content);

    /**
     * Logs a warning message.
     *
     * @param content the warning message to log
     */
    void warn(String content);

    /**
     * Logs a severe error message.
     *
     * @param content the error message to log
     */
    void severe(String content);

    /**
     * Returns the singleton instance of the {@link BedrockLogger}.
     *
     * @return the logger instance
     */
    static BedrockLogger getInstance() {
        return BedrockLoggerImp.getInstance();
    }
}
