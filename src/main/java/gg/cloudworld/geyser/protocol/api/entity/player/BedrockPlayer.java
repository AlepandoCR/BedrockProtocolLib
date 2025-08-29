package gg.cloudworld.geyser.protocol.api.entity.player;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.geyser.session.GeyserSession;

import java.util.UUID;

/**
 * Represents a player in the Bedrock protocol.
 * Provides methods to access the player's associated session.
 */
public interface BedrockPlayer {

    /**
     * Gets the Geyser session associated with this player.
     *
     * @return the {@link GeyserSession} instance for this player.
     */
    GeyserSession getSession();

    UUID getUniqueId();

    <E extends BedrockEvent<? extends BedrockPacket>>void sendPacket(E event);
}