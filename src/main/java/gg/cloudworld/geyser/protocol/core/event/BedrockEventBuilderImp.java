package gg.cloudworld.geyser.protocol.core.event;

import gg.cloudworld.geyser.protocol.api.entity.player.BedrockPlayer;
import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.events.BedrockEventBuilder;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.geyser.session.GeyserSession;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BedrockEventBuilderImp<T extends BedrockEvent<P>, P extends BedrockPacket> implements BedrockEventBuilder<T,P> {
    private final Class<T> implementationClass;
    private P packet;
    private GeyserSession session;

    public BedrockEventBuilderImp(Class<T> implementationClass, Class<P> packetClass) {
        this.implementationClass = implementationClass;
        try {
            this.packet = packetClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Failed to instantiate packet: " + packetClass.getName(), e);
        }
    }

    @Override
    public P getPacket() {
        return packet;
    }

    @Override
    public BedrockEventBuilder<T, P> setPlayer(BedrockPlayer player) {
        this.session = player.session();
        return this;
    }

    @Override
    public T build() {
        try {
            Constructor<?>[] constructors = implementationClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == 2 &&
                        constructor.getParameterTypes()[0].isAssignableFrom(GeyserSession.class) &&
                        constructor.getParameterTypes()[1].isAssignableFrom(packet.getClass())) {
                    @SuppressWarnings("unchecked")
                    Constructor<T> typedConstructor = (Constructor<T>) constructor;
                    return typedConstructor.newInstance(session, packet);
                }
            }
            throw new NoSuchMethodException("No suitable constructor found for " + implementationClass.getName());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to build event: " + implementationClass.getName(), e);
        }
    }
}
