package gg.cloudworld.geyser.protocol.core.packet;

import io.netty.channel.Channel;
import org.cloudburstmc.protocol.bedrock.netty.codec.packet.BedrockPacketCodec;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@ApiStatus.Internal
public class BedrockPacketSnifferManager {

    private final ConcurrentHashMap<GeyserSession,BedrockPacketSniffer> packetSniffers = new ConcurrentHashMap<>();

    private static final BedrockPacketSnifferManager instance = new BedrockPacketSnifferManager();

    public static BedrockPacketSnifferManager getInstance() {
        return instance;
    }

    private BedrockPacketSnifferManager(){
    }

    public void processJoin(GeyserSession session) {
        BedrockPacketSniffer sniffer = new BedrockPacketSniffer(session);
        addSniffer(sniffer);
        connect(session,sniffer);
    }

    public void processLeave(GeyserSession session) {
        BedrockPacketSniffer sniffer = getSniffer(session);
        if(sniffer == null) return;
        removeSniffer(sniffer);
        disconnect(session);
    }

    private void connect(GeyserSession session, BedrockPacketSniffer sniffer) {
        Channel channel = getChannel(session);
        String chanelName = getChannelName(session);
        channel.pipeline().addAfter(BedrockPacketCodec.NAME, chanelName, sniffer);
    }

    private void disconnect(GeyserSession session){
        Channel channel = getChannel(session);
        if(channel != null && channel.isActive()) {
            String chanelName = getChannelName(session);
            if (channel.pipeline().get(chanelName) != null){
                channel.pipeline().remove(chanelName);
            }
        }
    }

    private Channel getChannel(GeyserSession session){
        return session.getUpstream().getSession().getPeer().getChannel();
    }

    private String getChannelName(GeyserSession session){
        return "BedrockProtocolSniffer_" + session.name();
    }

    private void addSniffer(BedrockPacketSniffer sniffer){
        packetSniffers.putIfAbsent(sniffer.getSession(),sniffer);
    }

    private void removeSniffer(BedrockPacketSniffer sniffer){
        packetSniffers.remove(sniffer.getSession());
    }

    @Nullable
    public BedrockPacketSniffer getSniffer(GeyserSession session){
        return packetSniffers.get(session);
    }
}
