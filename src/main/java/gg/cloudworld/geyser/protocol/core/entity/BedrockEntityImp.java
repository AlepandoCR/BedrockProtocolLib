package gg.cloudworld.geyser.protocol.core.entity;

import gg.cloudworld.geyser.protocol.api.entity.BedrockEntity;
import gg.cloudworld.geyser.protocol.api.entity.data.BedrockEntityMetadata;
import gg.cloudworld.geyser.protocol.api.world.BedrockLocation;
import gg.cloudworld.geyser.protocol.core.entity.data.BedrockEntityMetadataImp;
import gg.cloudworld.geyser.protocol.core.world.BedrockLocationImp;
import org.geysermc.geyser.entity.properties.GeyserEntityPropertyManager;
import org.geysermc.geyser.entity.type.Entity;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class BedrockEntityImp implements BedrockEntity {

    private final Entity entity;

    public BedrockEntityImp(Entity entity){
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public void setLocation(BedrockLocation location) {
        entity.moveAbsolute(location.toVector3f(),location.getYaw(),location.getPitch(), entity.getHeadYaw(),false,false);
    }

    @Override
    public void setLocation(BedrockLocation location, float headYaw) {
        entity.moveAbsolute(location.toVector3f(),location.getYaw(),location.getPitch(), headYaw,false,false);
    }

    @Override
    public void setLocation(BedrockLocation location, boolean isOnGround, boolean teleported) {
        entity.moveAbsolute(location.toVector3f(),location.getYaw(),location.getPitch(), entity.getHeadYaw(), isOnGround, teleported);
    }

    @Override
    public void setLocation(BedrockLocation location, float headYaw, boolean isOnGround, boolean teleported) {
        entity.moveAbsolute(location.toVector3f(),location.getYaw(),location.getPitch(), headYaw, isOnGround, teleported);
    }

    @Override
    public BedrockLocation getLocation() {
        return new BedrockLocationImp(entity.getPosition());
    }

    @Override
    public BedrockEntityMetadata getEntityMetadata() {
        return new BedrockEntityMetadataImp(entity.getDirtyMetadata());
    }

    @Override
    public GeyserEntityPropertyManager getEntityProperties() {
        return entity.getPropertyManager();
    }
}
