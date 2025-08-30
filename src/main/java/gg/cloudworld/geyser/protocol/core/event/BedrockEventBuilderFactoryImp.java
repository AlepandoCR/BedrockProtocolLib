package gg.cloudworld.geyser.protocol.core.event;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.events.BedrockEventBuilderFactory;
import gg.cloudworld.geyser.protocol.core.packet.PacketEventRegistry;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.jetbrains.annotations.ApiStatus;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

@ApiStatus.Internal
public final class BedrockEventBuilderFactoryImp implements BedrockEventBuilderFactory {
    private final PacketEventRegistry packetEventRegistry;

    public BedrockEventBuilderFactoryImp(PacketEventRegistry packetEventRegistry) {
        this.packetEventRegistry = packetEventRegistry;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends BedrockEvent<P>, P extends BedrockPacket> BedrockEventBuilderImp<T, P> builderFor(Class<T> eventInterfaceClass) {
        Class<? extends T> implementationClass = findImplementation(eventInterfaceClass);
        if (implementationClass == null) {
            throw new IllegalArgumentException("No implementation found for event interface: " + eventInterfaceClass.getName());
        }

        Class<P> packetClass = findPacketClass(eventInterfaceClass);
        if (packetClass == null) {
            throw new IllegalArgumentException("Could not determine packet type for event interface: " + eventInterfaceClass.getName());
        }

        return new BedrockEventBuilderImp<>((Class<T>) implementationClass, packetClass);
    }


    @SuppressWarnings("unchecked")
    private <T extends BedrockEvent<?>> Class<? extends T> findImplementation(Class<T> eventInterface) {
        Map<Class<? extends BedrockPacket>, RegisteredPacketEvent<?, ?>> registeredEvents = this.packetEventRegistry.getRegisteredEvents();
        for (RegisteredPacketEvent<?, ?> registeredEvent : registeredEvents.values()) {
            if (eventInterface.isAssignableFrom(registeredEvent.eventClass())) {
                return (Class<? extends T>) registeredEvent.eventClass();
            }
        }
        return null;
    }


    @SuppressWarnings("unchecked")
    private <P extends BedrockPacket> Class<P> findPacketClass(Class<?> eventInterface) {
        for (Type genericInterface : eventInterface.getGenericInterfaces()) {
            if (genericInterface instanceof ParameterizedType parameterizedType) {
                if (parameterizedType.getRawType().equals(BedrockEvent.class) ||
                        (parameterizedType.getRawType() instanceof Class && BedrockEvent.class.isAssignableFrom((Class<?>) parameterizedType.getRawType()))) {
                    Type[] typeArguments = parameterizedType.getActualTypeArguments();
                    if (typeArguments.length > 0 && typeArguments[0] instanceof Class) {
                        return (Class<P>) typeArguments[0];
                    }
                }
            }
        }
        for (Class<?> superInterface : eventInterface.getInterfaces()) {
            Class<P> packetClass = findPacketClass(superInterface);
            if (packetClass != null) {
                return packetClass;
            }
        }
        return null;
    }

}
