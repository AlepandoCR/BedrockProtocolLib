package gg.cloudworld.geyser.protocol.core.event;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.events.listener.annotations.BedrockEventHandler;
import gg.cloudworld.geyser.protocol.api.events.listener.BedrockEventListener;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.jetbrains.annotations.ApiStatus;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@ApiStatus.Internal
public class BedrockEventManagerImp {

    private static final BedrockEventManagerImp instance = new BedrockEventManagerImp();

    private BedrockEventManagerImp() {}

    public static BedrockEventManagerImp getInstance() {
        return instance;
    }

    private final Map<Class<? extends BedrockEvent<? extends BedrockPacket>>, List<RegisteredListener>> listenerMap = new ConcurrentHashMap<>();
    private final Map<Class<? extends BedrockEvent<? extends BedrockPacket>>, List<RegisteredListener>> listenerCache = new ConcurrentHashMap<>();

    public void registerListener(BedrockEventListener listener) {
        for (Method method : listener.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(BedrockEventHandler.class) && method.getParameterCount() == 1) {
                Class<?> paramType = method.getParameterTypes()[0];
                if (BedrockEvent.class.isAssignableFrom(paramType)) {
                    Class<? extends BedrockEvent<? extends BedrockPacket>> eventType = (Class<? extends BedrockEvent<? extends BedrockPacket>>) paramType;

                    listenerMap.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>());
                    listenerMap.get(eventType).add(new RegisteredListener(listener, method));
                    listenerCache.clear();
                }
            }
        }
    }

    public void fireEvent(BedrockEvent<? extends BedrockPacket> event) {
        @SuppressWarnings("unchecked")
        Class<? extends BedrockEvent<? extends BedrockPacket>> eventType = (Class<? extends BedrockEvent<? extends BedrockPacket>>) event.getClass();
        List<RegisteredListener> listeners = listenerCache.computeIfAbsent(eventType, eventClass -> {
            Map<Method, RegisteredListener> listenersToInvoke = new HashMap<>();
            for (Map.Entry<Class<? extends BedrockEvent<? extends BedrockPacket>>, List<RegisteredListener>> entry : listenerMap.entrySet()) {
                if (entry.getKey().isAssignableFrom(eventClass)) {
                    for (RegisteredListener listener : entry.getValue()) {
                        listenersToInvoke.putIfAbsent(listener.method(), listener);
                    }
                }
            }
            return List.copyOf(listenersToInvoke.values());
        });

        for (RegisteredListener registeredListener : listeners) {
            try {
                registeredListener.method().invoke(registeredListener.listener(), event);
            } catch (Exception e) {
                System.err.println("Error on listener" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void unregisterListener(BedrockEventListener listener) {
        listenerMap.values().forEach(listeners ->
                listeners.removeIf(registered -> registered.listener().equals(listener))
        );
        listenerMap.entrySet().removeIf(entry -> entry.getValue().isEmpty());
        listenerCache.clear();
    }


    private record RegisteredListener(BedrockEventListener listener, Method method){}
}