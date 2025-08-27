package gg.cloudworld.geyser.protocol.api.events.types.ui;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;

public interface BedrockUIEvent<T extends BedrockPacket> extends BedrockEvent<T> {
}
