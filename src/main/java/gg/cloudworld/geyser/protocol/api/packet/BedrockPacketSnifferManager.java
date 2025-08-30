package gg.cloudworld.geyser.protocol.api.packet;

import org.geysermc.geyser.session.GeyserSession;

public interface BedrockPacketSnifferManager {

    void processJoin(GeyserSession session);

    void processLeave(GeyserSession session);
}
