package gg.cloudworld.geyser.protocol.core.world;

import gg.cloudworld.geyser.protocol.api.world.BedrockLocation;
import org.cloudburstmc.math.vector.Vector3f;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class BedrockLocationImp implements BedrockLocation {

    private float x;
    private float y;
    private float z;
    private float yaw = 0;
    private float pitch = 0;

    public BedrockLocationImp(float x, float y, float z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public BedrockLocationImp(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public BedrockLocationImp(Vector3f vector3f) {
        this.x = vector3f.getX();
        this.y = vector3f.getX();
        this.z = vector3f.getX();
    }

    public BedrockLocationImp(Vector3f vector3f, float yaw, float pitch) {
        this.x = vector3f.getX();
        this.y = vector3f.getX();
        this.z = vector3f.getX();
        this.yaw = yaw;
        this.pitch = pitch;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }

    @Override
    public float getYaw() {
        return yaw;
    }

    @Override
    public float getPitch() {
        return pitch;
    }

    @Override
    public Vector3f toVector3f() {
        return Vector3f.ZERO.add(getX(),getY(),getZ());
    }

    @Override
    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    @Override
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void setZ(float z) {
        this.z = z;
    }
}
