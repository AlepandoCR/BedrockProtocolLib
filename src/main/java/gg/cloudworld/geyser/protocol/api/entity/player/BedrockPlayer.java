package gg.cloudworld.geyser.protocol.api.entity.player;

import org.geysermc.geyser.session.GeyserSession;

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
}