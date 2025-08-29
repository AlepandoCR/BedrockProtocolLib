package gg.cloudworld.geyser.protocol.core.event.types.world;

import gg.cloudworld.geyser.protocol.api.events.types.world.BedrockWorldEvent;
import gg.cloudworld.geyser.protocol.api.world.BedrockLocation;
import gg.cloudworld.geyser.protocol.core.event.BedrockEventImp;
import gg.cloudworld.geyser.protocol.core.world.BedrockLocationImp;
import org.cloudburstmc.protocol.bedrock.data.LevelEventType;
import org.cloudburstmc.protocol.bedrock.packet.LevelEventPacket;
import org.geysermc.geyser.session.GeyserSession;

public class BedrockWorldEventImp extends BedrockEventImp<LevelEventPacket> implements BedrockWorldEvent  {

    public BedrockWorldEventImp(GeyserSession session, LevelEventPacket packet) {
        super(session, packet);
    }

    @Override
    public LevelEventType getType() {
        return packet.getType();
    }

    @Override
    public BedrockLocation getLocation() {
        return new BedrockLocationImp(packet.getPosition());
    }

    @Override
    public int getData() {
        return packet.getData();
    }

    @Override
    public void setData(int data) {
        packet.setData(data);
    }

    @Override
    public void setType(LevelEventType type) {
        packet.setType(type);
    }

    @Override
    public void setLocation(BedrockLocation bedrockLocation) {
        packet.setPosition(bedrockLocation.toVector3f());
    }
}
