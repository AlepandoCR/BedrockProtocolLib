package gg.cloudworld.geyser.protocol.api.events.types.world;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.world.BedrockLocation;
import org.cloudburstmc.protocol.bedrock.data.LevelEventType;
import org.cloudburstmc.protocol.bedrock.packet.LevelEventPacket;

/**
 * Represents a world-related event in the Bedrock protocol.
 * <p>
 * This event type is typically used for level-specific actions,
 * such as particle effects, sound triggers, and environmental updates
 * within the Bedrock edition world.
 * </p>
 *
 * <p>
 * Extends {@link BedrockEvent} with {@link LevelEventPacket}
 * as the underlying packet type.
 * </p>
 */
public interface BedrockWorldEvent extends BedrockEvent<LevelEventPacket> {

    /**
     * Gets the type of this world event.
     *
     * @return the {@link LevelEventType} representing the event type
     */
    LevelEventType getType();

    /**
     * Gets the location where this event occurred.
     *
     * @return the {@link BedrockLocation} of the event
     */
    BedrockLocation getLocation();

    /**
     * Gets the event-specific data value.
     * <p>
     * The meaning of this value depends on the {@link LevelEventType}.
     * For example, it can represent block IDs, effect intensities, or
     * additional metadata.
     * </p>
     *
     * @return the integer data associated with this event
     */
    int getData();

    /**
     * Sets the event-specific data value.
     *
     * @param data the new data value for this event
     */
    void setData(int data);

    /**
     * Sets the type of this world event.
     *
     * @param type the {@link LevelEventType} to assign
     */
    void setType(LevelEventType type);

    /**
     * Sets the location of this world event.
     *
     * @param bedrockLocation the {@link BedrockLocation} to assign
     */
    void setLocation(BedrockLocation bedrockLocation);
}
