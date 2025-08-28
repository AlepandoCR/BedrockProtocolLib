package gg.cloudworld.geyser.protocol.core.event;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.jetbrains.annotations.ApiStatus;

import java.lang.reflect.Constructor;

@ApiStatus.Internal
public record RegisteredPacketEvent<P extends BedrockPacket, E extends BedrockEvent<P>>(
        Class<P> packetClass,
        Class<E> eventClass,
        Constructor<E> constructor
) { }
