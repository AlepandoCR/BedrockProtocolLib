package gg.cloudworld.geyser.protocol.api.test;

import gg.cloudworld.geyser.protocol.api.events.listener.BedrockEventListener;
import gg.cloudworld.geyser.protocol.api.events.listener.annotations.BedrockEventHandler;
import gg.cloudworld.geyser.protocol.api.events.types.entity.AddEntityEvent;
import gg.cloudworld.geyser.protocol.api.logger.BedrockLogger;
import org.geysermc.geyser.entity.type.Entity;

public class TestListener implements BedrockEventListener {
    @BedrockEventHandler
    public void onEntitySpawn(AddEntityEvent entityEvent){
        Class<? extends Entity> entityClass =  entityEvent.getEntity().getRawEntity().getClass();
        String msg = "Entity event received with TestListener entity: "+ entityClass.getSimpleName();
        BedrockLogger.getInstance().severe(msg);
    }
}
