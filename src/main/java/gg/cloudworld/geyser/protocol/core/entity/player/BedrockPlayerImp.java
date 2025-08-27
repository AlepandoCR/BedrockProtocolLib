package gg.cloudworld.geyser.protocol.core.entity.player;

import gg.cloudworld.geyser.protocol.api.entity.player.BedrockPlayer;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class BedrockPlayerImp implements BedrockPlayer {

    private final GeyserSession session;

    public BedrockPlayerImp(GeyserSession session){
        this.session = session;
    }
    @Override
    public GeyserSession getSession() {
        return session;
    }
}
