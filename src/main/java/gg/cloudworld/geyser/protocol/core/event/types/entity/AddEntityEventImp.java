package gg.cloudworld.geyser.protocol.core.event.types.entity;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.events.types.entity.AddEntityEvent;
import gg.cloudworld.geyser.protocol.core.entity.util.EntityUtils;
import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.packet.AddEntityPacket;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class AddEntityEventImp extends BedrockEntityEventImp<AddEntityPacket> implements AddEntityEvent{
    public AddEntityEventImp(GeyserSession session, AddEntityPacket packet) {
        super(session, EntityUtils.getEntity(session,packet.getRuntimeEntityId()), packet);
    }

    @Override
    public long getUniqueEntityId() {
        return packet.getUniqueEntityId();
    }

    @Override
    public void setUniqueEntityId(long uniqueEntityId) {
        packet.setUniqueEntityId(uniqueEntityId);
    }

    @Override
    public long getRuntimeEntityId() {
        return packet.getRuntimeEntityId();
    }

    @Override
    public void setRuntimeEntityId(long runtimeEntityId) {
        packet.setRuntimeEntityId(runtimeEntityId);
    }

    @Override
    public String getIdentifier() {
        return packet.getIdentifier();
    }

    @Override
    public void setIdentifier(String identifier) {
        packet.setIdentifier(identifier);
    }

    @Override
    public int getEntityType() {
        return packet.getEntityType();
    }

    @Override
    public void setEntityType(int entityType) {
        packet.setEntityType(entityType);
    }

    @Override
    public Vector3f getMotion() {
        return packet.getMotion();
    }

    @Override
    public void setMotion(Vector3f motion) {
        packet.setMotion(motion);
    }

    @Override
    public Vector2f getRotation() {
        return packet.getRotation();
    }

    @Override
    public void setRotation(Vector2f rotation) {
        packet.setRotation(rotation);
    }
}
