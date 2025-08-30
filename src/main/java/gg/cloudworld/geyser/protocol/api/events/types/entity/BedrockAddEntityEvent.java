package gg.cloudworld.geyser.protocol.api.events.types.entity;

import org.cloudburstmc.protocol.bedrock.packet.AddEntityPacket;

/**
 * Called when an entity is added to the player's session.
 */
public interface BedrockAddEntityEvent extends BedrockEntityEvent<AddEntityPacket> {

}
