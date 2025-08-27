package gg.cloudworld.geyser.protocol.core.event;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;

public record RegisteredPacketEvent<P extends BedrockPacket, E extends BedrockEvent<P>>(
        Class<P> packetClass,
        Class<E> eventClass
) { }
