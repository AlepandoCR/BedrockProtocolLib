package gg.cloudworld.geyser.protocol.core.packet;

import io.netty.channel.Channel;
import org.cloudburstmc.protocol.bedrock.netty.codec.packet.BedrockPacketCodec;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

@ApiStatus.Internal
public class BedrockPacketSnifferManager {

    private final List<BedrockPacketSniffer> packetSniffers = new ArrayList<>();

    private static BedrockPacketSnifferManager instance = new BedrockPacketSnifferManager();

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
        removeSniffer(getSniffer(session));
        disconnect(session);
    }

    private void connect(GeyserSession session, BedrockPacketSniffer sniffer) {
        Channel channel = getChannel(session);
        String chanelName = getChannelName(session);
        channel.pipeline().addAfter(BedrockPacketCodec.NAME, chanelName, sniffer);
    }

    private void disconnect(GeyserSession session){
        Channel channel = getChannel(session);
        String chanelName = getChannelName(session);
        channel.pipeline().remove(chanelName);
    }

    private Channel getChannel(GeyserSession session){
        return session.getUpstream().getSession().getPeer().getChannel();
    }

    private String getChannelName(GeyserSession session){
        return "BedrockProtocolSniffer_" + session.name();
    }

    private void addSniffer(BedrockPacketSniffer sniffer){
        packetSniffers.add(sniffer);
    }

    private void removeSniffer(BedrockPacketSniffer sniffer){
        packetSniffers.remove(sniffer);
    }

    public BedrockPacketSniffer getSniffer(GeyserSession session){
        return packetSniffers.stream().filter(packetSniffer -> packetSniffer.getSession().equals(session)).findFirst().orElse(null);
    }
}
