package gg.cloudworld.geyser.protocol.core.packet;

import io.netty.channel.ChannelDuplexHandler;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public abstract class PacketSniffer extends ChannelDuplexHandler {

    protected final GeyserSession session;

    public PacketSniffer(GeyserSession session) {
        this.session = session;
    }

    public GeyserSession getSession() {
        return session;
    }
}