package gg.cloudworld.geyser.protocol.api.world;

import org.cloudburstmc.math.vector.Vector3d;
import org.cloudburstmc.math.vector.Vector3f;

/**
 * Represents a location in the Bedrock world.
 * Provides methods to get and set the coordinates, orientation, and vector representation of the location.
 */
public interface BedrockLocation {

    /**
     * Gets the X coordinate of the location.
     *
     * @return the X coordinate as a float.
     */
    public float getX();

    /**
     * Gets the Y coordinate of the location.
     *
     * @return the Y coordinate as a float.
     */
    public float getY();

    /**
     * Gets the Z coordinate of the location.
     *
     * @return the Z coordinate as a float.
     */
    public float getZ();

    /**
     * Gets the yaw (horizontal rotation) of the location.
     *
     * @return the yaw as a float.
     */
    public float getYaw();

    /**
     * Gets the pitch (vertical rotation) of the location.
     *
     * @return the pitch as a float.
     */
    public float getPitch();

    /**
     * Converts the location to a Vector3f representation.
     *
     * @return the location as a {@link Vector3f}.
     */
    public Vector3f toVector3f();

    /**
     * Sets the yaw (horizontal rotation) of the location.
     *
     * @param yaw the new yaw value as a float.
     */
    public void setYaw(float yaw);

    /**
     * Sets the pitch (vertical rotation) of the location.
     *
     * @param pitch the new pitch value as a float.
     */
    public void setPitch(float pitch);

    /**
     * Sets the X coordinate of the location.
     *
     * @param x the new X coordinate as a float.
     */
    public void setX(float x);

    /**
     * Sets the Y coordinate of the location.
     *
     * @param y the new Y coordinate as a float.
     */
    public void setY(float y);

    /**
     * Sets the Z coordinate of the location.
     *
     * @param z the new Z coordinate as a float.
     */
    public void setZ(float z);
}