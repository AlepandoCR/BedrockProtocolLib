package gg.cloudworld.geyser.protocol.api.logger;

import gg.cloudworld.geyser.protocol.core.logger.BedrockLoggerImp;

public interface BedrockLogger {
    void info(String content);

    void warn(String content);

    void severe(String content);

    static BedrockLogger getInstance(){
        return BedrockLoggerImp.getInstance();
    }
}
