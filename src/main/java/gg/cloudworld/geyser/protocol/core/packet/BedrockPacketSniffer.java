package gg.cloudworld.geyser.protocol.core.packet;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import org.cloudburstmc.protocol.bedrock.netty.BedrockPacketWrapper;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class BedrockPacketSniffer extends PacketSniffer {
    private final PacketEventRegistry eventRegistry;

    public BedrockPacketSniffer(GeyserSession session, PacketEventRegistry eventRegistry) {
        super(session);
        this.eventRegistry = eventRegistry;
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (readPacket(msg)) return;
        super.write(ctx, msg, promise);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (readPacket(msg)) return;
        super.channelRead(ctx, msg);
    }

    private boolean readPacket(Object msg) {
        if (msg instanceof BedrockPacketWrapper wrapper) {
            BedrockPacket packet = wrapper.getPacket();
            if (packet == null) return true;

            this.eventRegistry.handle(session, packet);
        }
        return false;
    }
}