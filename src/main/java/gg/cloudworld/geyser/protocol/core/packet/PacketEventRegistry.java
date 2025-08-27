package gg.cloudworld.geyser.protocol.core.packet;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.core.event.RegisteredPacketEvent;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@ApiStatus.Internal
public class PacketEventRegistry {

    private static final PacketEventRegistry instance = new PacketEventRegistry();

    private PacketEventRegistry() {}

    public static PacketEventRegistry getInstance() {
        return instance;
    }

    private final Map<Class<? extends BedrockPacket>, RegisteredPacketEvent<?, ?>> eventMap = new HashMap<>();

    public <P extends BedrockPacket, E extends BedrockEvent<P>> void register(Class<P> packetClass, Class<E> eventClass) {
        this.eventMap.put(packetClass, new RegisteredPacketEvent<>(packetClass, eventClass));
    }

    @SuppressWarnings("unchecked")
    public <P extends BedrockPacket> void handle(GeyserSession session, P packet) {
        RegisteredPacketEvent<?, ?> registered = eventMap.get(packet.getClass());
        if (registered == null) {
            return;
        }

        try {
            BedrockEvent<P> event = (BedrockEvent<P>) registered.eventClass()
                    .getConstructor(GeyserSession.class, registered.packetClass())
                    .newInstance(session, packet);
            event.call();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
