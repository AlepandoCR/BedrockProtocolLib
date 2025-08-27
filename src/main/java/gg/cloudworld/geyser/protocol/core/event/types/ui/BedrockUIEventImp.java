package gg.cloudworld.geyser.protocol.core.event.types.ui;

import gg.cloudworld.geyser.protocol.api.events.types.ui.BedrockUIEvent;
import gg.cloudworld.geyser.protocol.core.event.BedrockEventImp;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.geyser.session.GeyserSession;

public abstract class BedrockUIEventImp<T extends BedrockPacket> extends BedrockEventImp<T> implements BedrockUIEvent<T>{
    public BedrockUIEventImp(GeyserSession session, T packet) {
        super(session, packet);
    }
}
