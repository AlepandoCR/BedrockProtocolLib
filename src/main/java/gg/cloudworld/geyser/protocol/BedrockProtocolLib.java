package gg.cloudworld.geyser.protocol;

import gg.cloudworld.geyser.protocol.core.packet.BedrockPacketSnifferManager;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.bedrock.SessionDisconnectEvent;
import org.geysermc.geyser.api.event.bedrock.SessionInitializeEvent;
import org.geysermc.geyser.api.event.bedrock.SessionJoinEvent;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.session.GeyserSession;

public class BedrockProtocolLib implements Extension
{
    @Subscribe
    public void onBedrockLeave(SessionDisconnectEvent e){
        BedrockPacketSnifferManager.getInstance().processLeave((GeyserSession) e.connection());
    }
    @Subscribe
    public void onBedrockJoin(SessionInitializeEvent e){
        BedrockPacketSnifferManager.getInstance().processJoin((GeyserSession) e.connection());
    }
}
