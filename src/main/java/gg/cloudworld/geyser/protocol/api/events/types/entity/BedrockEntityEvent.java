package gg.cloudworld.geyser.protocol.api.events.types.entity;

import gg.cloudworld.geyser.protocol.api.entity.BedrockEntity;
import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.world.BedrockLocation;
import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.geyser.entity.type.Entity;

/**
 * Represents a Bedrock Entity Event, which provides methods to manage and interact with
 * entity-related data in the Bedrock protocol.
 */
public interface BedrockEntityEvent<T extends BedrockPacket> extends BedrockEvent<T> {

    /**
     * Gets the unique entity ID.
     *
     * @return the unique entity ID.
     */
    long getUniqueEntityId();

    /**
     * Sets the unique entity ID.
     *
     * @param uniqueEntityId the unique entity ID to set.
     */
    void setUniqueEntityId(long uniqueEntityId);

    /**
     * Gets the runtime entity ID.
     *
     * @return the runtime entity ID.
     */
    long getRuntimeEntityId();

    /**
     * Sets the runtime entity ID.
     *
     * @param runtimeEntityId the runtime entity ID to set.
     */
    void setRuntimeEntityId(long runtimeEntityId);

    /**
     * Gets the identifier of the entity.
     *
     * @return the identifier of the entity.
     */
    String getIdentifier();

    /**
     * Sets the identifier of the entity.
     *
     * @param identifier the identifier to set.
     */
    void setIdentifier(String identifier);

    /**
     * Gets the entity type.
     *
     * @return the entity type as an integer.
     */
    int getEntityType();

    /**
     * Sets the entity type.
     *
     * @param entityType the entity type to set.
     */
    void setEntityType(int entityType);

    /**
     * Gets the location of the entity in the Bedrock world.
     *
     * @return the {@link BedrockLocation} of the entity.
     */
    BedrockLocation getBedrockLocation();

    /**
     * Sets the location of the entity in the Bedrock world.
     *
     * @param location the {@link BedrockLocation} to set.
     */
    void setBedrockLocation(BedrockLocation location);

    /**
     * Sets the location of the entity in the Bedrock world, including additional parameters
     * for head yaw, whether the entity is on the ground, and whether it was teleported.
     *
     * @param location the {@link BedrockLocation} to set.
     * @param headYaw the head yaw angle of the entity.
     * @param onGround whether the entity is on the ground.
     * @param teleport whether the entity was teleported.
     */
    void setBedrockLocation(BedrockLocation location, float headYaw, boolean onGround, boolean teleport);

    /**
     * Gets the motion vector of the entity.
     *
     * @return the motion as a {@link Vector3f}.
     */
    Vector3f getMotion();

    /**
     * Sets the motion vector of the entity.
     *
     * @param motion the motion as a {@link Vector3f}.
     */
    void setMotion(Vector3f motion);

    /**
     * Gets the rotation vector of the entity.
     *
     * @return the rotation as a {@link Vector2f}.
     */
    Vector2f getRotation();

    /**
     * Sets the rotation vector of the entity.
     *
     * @param rotation the rotation as a {@link Vector2f}.
     */
    void setRotation(Vector2f rotation);

    /**
     * Gets the head rotation angle of the entity.
     *
     * @return the head rotation angle.
     */
    float getHeadRotation();

    /**
     * Sets the head rotation angle of the entity.
     *
     * @param headRotation the head rotation angle to set.
     */
    void setHeadRotation(float headRotation);

    /**
     * Gets the body rotation angle of the entity.
     *
     * @return the body rotation angle.
     */
    float getBodyRotation();

    /**
     * Sets the body rotation angle of the entity.
     *
     * @param bodyRotation the body rotation angle to set.
     */
    void setBodyRotation(float bodyRotation);

    /**
     * Sets the entity instance associated with this event.
     *
     * @param entity the {@link Entity} to set.
     */
    void setEntity(Entity entity);

    /**
     * Gets the entity instance associated with this event.
     *
     * @return the {@link Entity}.
     */
    BedrockEntity getEntity();
}