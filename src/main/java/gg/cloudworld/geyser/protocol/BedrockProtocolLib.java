package gg.cloudworld.geyser.protocol;

import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.bedrock.SessionDisconnectEvent;
import org.geysermc.geyser.api.event.bedrock.SessionJoinEvent;
import org.geysermc.geyser.api.extension.Extension;

public class BedrockProtocolLib implements Extension
{
    @Subscribe
    public void onBedrockLeave(SessionDisconnectEvent e){

    }
    @Subscribe
    public void onBedrockJoin(SessionJoinEvent e){

    }
}
