package gg.cloudworld.geyser.protocol.core.packet;

import io.netty.channel.ChannelOutboundHandlerAdapter;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public abstract class PacketSniffer extends ChannelOutboundHandlerAdapter {

    protected final GeyserSession session;

    public PacketSniffer(GeyserSession session) {
        this.session = session;
    }
}