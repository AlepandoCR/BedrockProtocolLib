package gg.cloudworld.geyser.protocol.api.entity;

import gg.cloudworld.geyser.protocol.api.entity.data.BedrockEntityMetadata;
import gg.cloudworld.geyser.protocol.api.world.BedrockLocation;
import org.geysermc.geyser.entity.properties.GeyserEntityPropertyManager;
import org.geysermc.geyser.entity.type.Entity;

import javax.annotation.Nullable;

/**
 * Represents a Bedrock entity, providing methods to manage its location, metadata, and properties.
 */
public interface BedrockEntity {

    /**
     * Gets the underlying Geyser entity instance.
     *
     * @return the {@link Entity} instance.
     */
    @Nullable
    Entity getRawEntity();

    /**
     * Sets the location of the entity.
     *
     * @param location the new {@link BedrockLocation} of the entity.
     */
    void setLocation(BedrockLocation location);


    /**
     * Sets the location of the entity and updates its head yaw.
     *
     * @param location the new {@link BedrockLocation} of the entity.
     * @param headYaw the new head yaw angle of the entity.
     */
    void setLocation(BedrockLocation location, float headYaw);

    /**
     * Sets the location of the entity and specifies whether it is on the ground or teleported.
     *
     * @param location the new {@link BedrockLocation} of the entity.
     * @param isOnGround whether the entity is on the ground.
     * @param teleported whether the entity was teleported.
     */
    void setLocation(BedrockLocation location, boolean isOnGround, boolean teleported);

    /**
     * Sets the location of the entity, updates its head yaw, and specifies whether it is on the ground or teleported.
     *
     * @param location the new {@link BedrockLocation} of the entity.
     * @param headYaw the new head yaw angle of the entity.
     * @param isOnGround whether the entity is on the ground.
     * @param teleported whether the entity was teleported.
     */
    void setLocation(BedrockLocation location, float headYaw, boolean isOnGround, boolean teleported);

    /**
     * Gets the current location of the entity.
     *
     * @return the {@link BedrockLocation} of the entity.
     */
    BedrockLocation getLocation();

    /**
     * Gets the metadata associated with the entity.
     *
     * @return the {@link BedrockEntityMetadata} of the entity.
     */
    BedrockEntityMetadata getEntityMetadata();

    /**
     * Gets the property manager for the entity.
     *
     * @return the {@link GeyserEntityPropertyManager} managing the entity's properties.
     */
    GeyserEntityPropertyManager getEntityProperties();
}