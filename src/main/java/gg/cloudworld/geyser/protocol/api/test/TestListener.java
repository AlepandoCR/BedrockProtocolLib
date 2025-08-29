package gg.cloudworld.geyser.protocol.api.test;

import gg.cloudworld.geyser.protocol.api.events.listener.BedrockEventListener;
import gg.cloudworld.geyser.protocol.api.events.listener.annotations.BedrockEventHandler;
import gg.cloudworld.geyser.protocol.api.events.types.world.BedrockWorldEvent;
import gg.cloudworld.geyser.protocol.api.logger.BedrockLogger;

public class TestListener implements BedrockEventListener {

    @BedrockEventHandler
    public void onParticleEvent(BedrockWorldEvent event){
        if(event.getType().toString().equals("WAX")){
            BedrockLogger.getInstance().warn("Wax particle intercepted and edited");
            event.setData(16560387);
        }
    }
}
