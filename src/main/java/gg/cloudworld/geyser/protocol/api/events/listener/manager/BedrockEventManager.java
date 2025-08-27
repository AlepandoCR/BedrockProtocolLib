package gg.cloudworld.geyser.protocol.api.events.listener.manager;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.events.listener.BedrockEventListener;
import gg.cloudworld.geyser.protocol.core.event.EventManager;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;

/**
 * Manages the registration, unregistration, and firing of Bedrock events.
 * Provides static methods to interact with the underlying event manager.
 */
public class BedrockEventManager {

    // Singleton instance of the EventManager.
    private static final EventManager eventManager = EventManager.getInstance();

    private BedrockEventManager(){}

    /**
     * Registers a Bedrock event listener with the event manager.
     *
     * @param listener the {@link BedrockEventListener} to register.
     */
    public static void registerListener(BedrockEventListener listener){
        eventManager.registerListener(listener);
    }

    /**
     * Unregisters a Bedrock event listener from the event manager.
     *
     * @param listener the {@link BedrockEventListener} to unregister.
     */
    public static void unregisterListener(BedrockEventListener listener){
        eventManager.unregisterListener(listener);
    }

    /**
     * Fires a Bedrock event, notifying all registered listeners.
     *
     * @param event the {@link BedrockEvent} to fire.
     * @param <T> the type of the Bedrock packet associated with the event.
     */
    public static<T extends BedrockPacket> void fireEvent(BedrockEvent<T> event){
        eventManager.fireEvent(event);
    }

}