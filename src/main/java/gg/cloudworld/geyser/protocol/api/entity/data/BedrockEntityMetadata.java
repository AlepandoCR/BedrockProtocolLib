package gg.cloudworld.geyser.protocol.api.entity.data;

import org.geysermc.geyser.entity.GeyserDirtyMetadata;

/**
 * Interface representing metadata for a Bedrock entity.
 * Provides methods to get and set entity data, as well as retrieve specific data types.
 */
public interface BedrockEntityMetadata {

    /**
     * Retrieves the dirty metadata associated with the entity.
     *
     * @return the {@link GeyserDirtyMetadata} of the entity.
     */
    public GeyserDirtyMetadata getEntityData();

    /**
     * Sets the dirty metadata for the entity.
     *
     * @param entityData the {@link GeyserDirtyMetadata} to set.
     */
    public void setEntityData(GeyserDirtyMetadata entityData);

    /**
     * Retrieves specific data associated with the entity based on the provided data type.
     *
     * @param bedrockEntityData the {@link BedrockEntityData} type to retrieve.
     * @param <T> the type of the data to return.
     * @return the data of the specified type.
     */
    public <T> T getData(BedrockEntityData bedrockEntityData);
}