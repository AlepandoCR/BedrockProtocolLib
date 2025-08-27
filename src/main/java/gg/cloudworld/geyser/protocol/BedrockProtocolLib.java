package gg.cloudworld.geyser.protocol;

import gg.cloudworld.geyser.protocol.api.events.listener.manager.BedrockEventManager;
import gg.cloudworld.geyser.protocol.api.test.TestListener;
import gg.cloudworld.geyser.protocol.core.event.types.entity.AddEntityEventImp;
import gg.cloudworld.geyser.protocol.core.event.types.ui.BedrockSetScoreEventImp;
import gg.cloudworld.geyser.protocol.core.packet.BedrockPacketSnifferManager;
import gg.cloudworld.geyser.protocol.core.packet.PacketEventRegistry;
import org.cloudburstmc.protocol.bedrock.packet.AddEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetScorePacket;
import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.bedrock.SessionDisconnectEvent;
import org.geysermc.geyser.api.event.bedrock.SessionInitializeEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.session.GeyserSession;

public class BedrockProtocolLib implements Extension
{
    static {
        PacketEventRegistry.getInstance().register(AddEntityPacket.class, AddEntityEventImp.class);
        PacketEventRegistry.getInstance().register(SetScorePacket.class, BedrockSetScoreEventImp.class);
    }

    @Subscribe
    public void onEnable(GeyserPostInitializeEvent event){
        BedrockEventManager.registerListener(new TestListener());
    }

    @Subscribe
    public void onBedrockLeave(SessionDisconnectEvent e){
        BedrockPacketSnifferManager.getInstance().processLeave((GeyserSession) e.connection());
    }
    @Subscribe
    public void onBedrockJoin(SessionInitializeEvent e){
        BedrockPacketSnifferManager.getInstance().processJoin((GeyserSession) e.connection());
    }
}
