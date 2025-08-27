package gg.cloudworld.geyser.protocol.api.events;

import gg.cloudworld.geyser.protocol.api.entity.player.BedrockPlayer;
import gg.cloudworld.geyser.protocol.api.events.listener.manager.BedrockEventManager;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;

/**
 * Represents a Bedrock event in the protocol.
 * This interface defines the structure for events associated with Bedrock packets.
 *
 * @param <T> the type of the Bedrock packet associated with the event.
 */
public interface BedrockEvent<T extends BedrockPacket> {

    /**
     * Retrieves the player to whom the packet is being sent.
     *
     * @return the {@link BedrockPlayer} associated with the event.
     */
    public BedrockPlayer getBedrockPlayer();

    /**
     * Calls the event, triggering all registered listeners for this event.
     * This method uses the {@link BedrockEventManager} to fire the event.
     */
    public default void call() {
        BedrockEventManager.fireEvent(this);
    }

    /**
     * Retrieves the Bedrock packet associated with this event.
     *
     * @return the packet of type {@link T}.
     */
    public T getPacket();
}