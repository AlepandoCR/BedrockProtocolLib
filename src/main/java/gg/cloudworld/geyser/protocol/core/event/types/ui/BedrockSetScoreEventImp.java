package gg.cloudworld.geyser.protocol.core.event.types.ui;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.events.types.ui.BedrockSetScoreEvent;
import org.cloudburstmc.protocol.bedrock.data.ScoreInfo;
import org.cloudburstmc.protocol.bedrock.packet.SetScorePacket;
import org.geysermc.geyser.session.GeyserSession;

import java.util.List;

public class BedrockSetScoreEventImp extends BedrockUIEventImp<SetScorePacket> implements BedrockSetScoreEvent {

    public BedrockSetScoreEventImp(GeyserSession session, SetScorePacket packet) {
        super(session, packet);
    }

    @Override
    public BedrockScoreAction getAction() {
        return BedrockScoreAction.fromCloudburstAction(packet.getAction());
    }

    @Override
    public void setAction(BedrockScoreAction action) {
        packet.setAction(action.getBedrockAction());
    }

    @Override
    public List<ScoreInfo> getInfos() {
        return packet.getInfos();
    }

    @Override
    public void setInfos(List<ScoreInfo> inputs) {
        packet.setInfos(inputs);
    }

    @Override
    public void clearInfos() {
        packet.getInfos().clear();
    }
}
