package gg.cloudworld.geyser.protocol.core.event.types.entity;

import gg.cloudworld.geyser.protocol.api.entity.BedrockEntity;
import gg.cloudworld.geyser.protocol.api.world.BedrockLocation;
import gg.cloudworld.geyser.protocol.api.events.types.entity.BedrockEntityEvent;
import gg.cloudworld.geyser.protocol.core.entity.BedrockEntityImp;
import gg.cloudworld.geyser.protocol.core.event.BedrockEventImp;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.geyser.entity.type.Entity;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public abstract class BedrockEntityEventImp<T  extends BedrockPacket> extends BedrockEventImp<T> implements BedrockEntityEvent<T> {

    private BedrockEntity entity;

    public BedrockEntityEventImp(GeyserSession session, Entity entity, T packet) {
        super(session, packet);
        this.entity = new BedrockEntityImp(entity);
    }

    @Override
    public BedrockLocation getBedrockLocation() {
        return entity.getLocation();
    }

    @Override
    public void setBedrockLocation(BedrockLocation location) {
        entity.setLocation(location);
    }

    @Override
    public void setBedrockLocation(BedrockLocation location, float headYaw, boolean onGround, boolean teleport) {
        entity.setLocation(location, headYaw, onGround, teleport);
    }

    @Override
    public float getHeadRotation() {
        return entity.getRawEntity().getHeadYaw();
    }

    @Override
    public void setHeadRotation(float headRotation) {
        entity.getRawEntity().setHeadYaw(headRotation);
    }

    @Override
    public float getBodyRotation() {
        return entity.getLocation().getYaw();
    }

    @Override
    public void setBodyRotation(float bodyRotation) {
        entity.getLocation().setYaw(bodyRotation);
    }

    @Override
    public void setEntity(Entity entity) {
        this.entity = new BedrockEntityImp(entity);
    }

    @Override
    public BedrockEntity getEntity() {
        return entity;
    }
}
