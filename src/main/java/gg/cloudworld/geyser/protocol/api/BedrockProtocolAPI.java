package gg.cloudworld.geyser.protocol.api;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.events.BedrockEventBuilderFactory;
import gg.cloudworld.geyser.protocol.api.events.listener.manager.BedrockEventManager;
import gg.cloudworld.geyser.protocol.api.logger.BedrockLogger;
import gg.cloudworld.geyser.protocol.api.packet.BedrockPacketSnifferManager;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;

/**
 * Main class for BedrockProtocolLib
 */
public interface BedrockProtocolAPI {

    /**
     * @return The {@link BedrockEventManager} for this library
     */
    BedrockEventManager getEventManager();

    /**
     * @return The {@link BedrockLogger} for this library
     */
    BedrockLogger getLogger();

    /**
     * @return The {@link BedrockEventBuilderFactory} for this library
     */
    BedrockEventBuilderFactory getEventBuilderFactory();

    /**
     * @param packetClass BedrockPacket class
     * @param eventClass  BedrockEvent class
     */
    <P extends BedrockPacket, E extends BedrockEvent<P>> void registerEvent(Class<P> packetClass, Class<E> eventClass);

    /**
     * @return The {@link BedrockPacketSnifferManager} for this library
     */
    BedrockPacketSnifferManager getPacketSnifferManager();
}
