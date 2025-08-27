package gg.cloudworld.geyser.protocol.core.event;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.jetbrains.annotations.ApiStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@ApiStatus.Internal
public class PacketEventRegistry {

    private static final PacketEventRegistry instance = new PacketEventRegistry();

    private PacketEventRegistry() {}

    public static PacketEventRegistry getInstance() {
        return instance;
    }

    private final Map<Class<? extends BedrockPacket>, Function<BedrockPacket, ? extends BedrockEvent<? extends BedrockPacket>>> eventFactories = new HashMap<>();

    public <P extends BedrockPacket> void register(Class<P> packetClass, Function<P, ? extends BedrockEvent<? extends BedrockPacket>> eventFactory) {
        eventFactories.put(packetClass, (Function<BedrockPacket, ? extends BedrockEvent<? extends BedrockPacket>>) eventFactory);
    }

    public BedrockEvent<? extends BedrockPacket> createEvent(BedrockPacket packet) {
        Function<BedrockPacket, ? extends BedrockEvent<? extends BedrockPacket>> factory = eventFactories.get(packet.getClass());
        if (factory != null) {
            return factory.apply(packet);
        }
        return null;
    }
}
