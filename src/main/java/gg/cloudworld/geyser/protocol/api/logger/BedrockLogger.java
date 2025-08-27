package gg.cloudworld.geyser.protocol.api.logger;

import gg.cloudworld.geyser.protocol.core.logger.BedrockLoggerImp;

public interface BedrockLogger {
    public void info(String content);

    public void warn(String content);

    public void severe(String content);

    public static BedrockLogger getInstance(){
        return BedrockLoggerImp.getInstance();
    }
}
