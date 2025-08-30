package gg.cloudworld.geyser.protocol.core.entity.player;

import gg.cloudworld.geyser.protocol.api.entity.player.BedrockPlayer;
import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.world.BedrockLocation;
import gg.cloudworld.geyser.protocol.core.world.BedrockLocationImp;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.geyser.entity.type.player.SessionPlayerEntity;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

import java.util.UUID;

@ApiStatus.Internal
public record BedrockPlayerImp(GeyserSession session) implements BedrockPlayer {

    @Override
    public UUID getUniqueId() {
        return session.playerUuid();
    }

    @Override
    public <E extends BedrockEvent<? extends BedrockPacket>> void sendEvent(E event) {
        session.sendUpstreamPacket(event.getPacket());
    }

    @Override
    public SessionPlayerEntity getEntity() {
        return session.getPlayerEntity();
    }

    @Override
    public BedrockLocation getLocation() {
        return new BedrockLocationImp(getEntity().position());
    }
}
