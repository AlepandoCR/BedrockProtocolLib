package gg.cloudworld.geyser.protocol.core;

import gg.cloudworld.geyser.protocol.api.BedrockProtocolAPI;
import gg.cloudworld.geyser.protocol.api.events.BedrockEventBuilderFactory;
import gg.cloudworld.geyser.protocol.api.events.listener.manager.BedrockEventManager;
import gg.cloudworld.geyser.protocol.api.logger.BedrockLogger;
import gg.cloudworld.geyser.protocol.core.packet.BedrockPacketSnifferManagerImp;
import org.jetbrains.annotations.ApiStatus;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.core.event.types.entity.BedrockAddEntityEventImp;
import gg.cloudworld.geyser.protocol.core.event.types.ui.BedrockBossEventImp;
import gg.cloudworld.geyser.protocol.core.event.types.ui.BedrockSetScoreEventImp;
import gg.cloudworld.geyser.protocol.core.event.types.world.BedrockWorldEventImp;
import gg.cloudworld.geyser.protocol.core.packet.PacketEventRegistry;
import org.cloudburstmc.protocol.bedrock.packet.AddEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.cloudburstmc.protocol.bedrock.packet.BossEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetScorePacket;

import gg.cloudworld.geyser.protocol.core.event.BedrockEventBuilderFactoryImp;
import gg.cloudworld.geyser.protocol.core.event.BedrockEventManagerImp;
import gg.cloudworld.geyser.protocol.core.logger.BedrockLoggerImp;

@ApiStatus.Internal
public class BedrockProtocolAPIImp implements BedrockProtocolAPI {
    private final PacketEventRegistry packetEventRegistry;
    private final BedrockEventBuilderFactory eventBuilderFactory;
    private final BedrockLogger logger;
    private final BedrockEventManager eventManager;
    private final BedrockPacketSnifferManagerImp packetSnifferManager;

    public BedrockProtocolAPIImp() {
        this.packetEventRegistry = new PacketEventRegistry();
        this.eventBuilderFactory = new BedrockEventBuilderFactoryImp(this.packetEventRegistry);
        this.logger = new BedrockLoggerImp();
        this.eventManager = new BedrockEventManagerImp();
        this.packetSnifferManager = new BedrockPacketSnifferManagerImp(this.packetEventRegistry);
        registerEvents();
    }

    private void registerEvents() {
        registerEvent(AddEntityPacket.class, BedrockAddEntityEventImp.class);
        registerEvent(SetScorePacket.class, BedrockSetScoreEventImp.class);
        registerEvent(BossEventPacket.class, BedrockBossEventImp.class);
        registerEvent(LevelEventPacket.class, BedrockWorldEventImp.class);
    }

    @Override
    public BedrockEventManager getEventManager() {
        return this.eventManager;
    }

    @Override
    public BedrockLogger getLogger() {
        return this.logger;
    }

    @Override
    public BedrockEventBuilderFactory getEventBuilderFactory() {
        return this.eventBuilderFactory;
    }

    @Override
    public <P extends BedrockPacket, E extends BedrockEvent<P>> void registerEvent(Class<P> packetClass, Class<E> eventClass) {
        this.packetEventRegistry.register(packetClass, eventClass);
    }

    @Override
    public gg.cloudworld.geyser.protocol.api.packet.BedrockPacketSnifferManager getPacketSnifferManager() {
        return this.packetSnifferManager;
    }
}
