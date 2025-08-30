package gg.cloudworld.geyser.protocol.api.test;

import gg.cloudworld.geyser.protocol.api.events.listener.BedrockEventListener;
import gg.cloudworld.geyser.protocol.api.events.listener.annotations.BedrockEventHandler;
import gg.cloudworld.geyser.protocol.api.events.types.world.BedrockWorldEvent;


public class TestListener implements BedrockEventListener {

    @BedrockEventHandler
    public void onParticleEvent(BedrockWorldEvent event) {
        if (event.getType().toString().equals("WAX")) {
            event.setData(16560387);
        }
    }
}
