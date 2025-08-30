package gg.cloudworld.geyser.protocol.api.events;

import gg.cloudworld.geyser.protocol.api.entity.player.BedrockPlayer;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;

public interface BedrockEventBuilder<T extends BedrockEvent<P>, P extends BedrockPacket> {

    P getPacket();

    BedrockEventBuilder<T, P> setPlayer(BedrockPlayer player);

    T build();
}
