package gg.cloudworld.geyser.protocol.core.logger;

import gg.cloudworld.geyser.protocol.api.logger.BedrockLogger;
import org.geysermc.geyser.GeyserImpl;
import org.geysermc.geyser.GeyserLogger;

public class BedrockLoggerImp implements BedrockLogger {

    private static final BedrockLoggerImp instance = new BedrockLoggerImp();

    private BedrockLoggerImp(){

    }

    private final GeyserLogger logger = GeyserImpl.getInstance().getLogger();

    @Override
    public void info(String content) {
        logger.info(content);
    }

    @Override
    public void warn(String content) {
        logger.warning(content);
    }

    @Override
    public void severe(String content) {
        logger.severe(content);
    }

    public static BedrockLoggerImp getInstance(){
        return instance;
    }
}
