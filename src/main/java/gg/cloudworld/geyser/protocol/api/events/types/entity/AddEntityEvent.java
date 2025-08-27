package gg.cloudworld.geyser.protocol.api.events.types.entity;

import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;

/**
 * Called when an entity is added to the player's session.
 */
public interface AddEntityEvent<T extends BedrockPacket> extends BedrockEntityEvent<T> {

}
