package gg.cloudworld.geyser.protocol.core.event;

import gg.cloudworld.geyser.protocol.api.entity.player.BedrockPlayer;
import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.core.entity.player.BedrockPlayerImp;
import gg.cloudworld.geyser.protocol.core.event.types.entity.AddEntityEventImp;
import gg.cloudworld.geyser.protocol.core.packet.PacketEventRegistry;
import org.cloudburstmc.protocol.bedrock.packet.AddEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public abstract class BedrockEventImp<T extends BedrockPacket> implements BedrockEvent<T> {

    private final BedrockPlayer player;

    protected T packet;

    public BedrockEventImp(GeyserSession session, T packet) {
        player = new BedrockPlayerImp(session);
        this.packet = packet;
        saveToRegistry();
    }

    protected BedrockEventImp(BedrockPlayer player) {
        this.player = player;
    }

    @Override
    public BedrockPlayer getBedrockPlayer() {
        return player;
    }

    @Override
    public T getPacket() {
        return packet;
    }

    protected abstract Class<T> getPacketClass();

    protected abstract Class<?extends BedrockEvent<T>> getEventClass();

    private void saveToRegistry(){
        PacketEventRegistry.getInstance().register(getPacketClass(), getEventClass());
    }
}
