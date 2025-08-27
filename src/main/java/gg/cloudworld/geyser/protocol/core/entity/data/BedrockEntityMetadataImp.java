package gg.cloudworld.geyser.protocol.core.entity.data;

import gg.cloudworld.geyser.protocol.api.entity.data.BedrockEntityData;
import gg.cloudworld.geyser.protocol.api.entity.data.BedrockEntityMetadata;
import org.geysermc.geyser.entity.GeyserDirtyMetadata;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class BedrockEntityMetadataImp implements BedrockEntityMetadata {

    private GeyserDirtyMetadata metadata;

    public BedrockEntityMetadataImp(GeyserDirtyMetadata entityDataMap) {
        metadata = entityDataMap;
    }

    @Override
    public GeyserDirtyMetadata getEntityData() {
        return metadata;
    }

    @Override
    public void setEntityData(GeyserDirtyMetadata entityData) {
        this.metadata = entityData;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getData(BedrockEntityData bedrockEntityData) {
        return (T) metadata.get(bedrockEntityData.getDataType());
    }




}
