package gg.cloudworld.geyser.protocol.core.event.types.ui;

import gg.cloudworld.geyser.protocol.api.events.types.ui.BedrockBossEvent;
import org.cloudburstmc.protocol.bedrock.packet.BossEventPacket;
import org.geysermc.geyser.session.GeyserSession;

public class BedrockBossEventImp extends BedrockUIEventImp<BossEventPacket> implements BedrockBossEvent {
    public BedrockBossEventImp(GeyserSession session, BossEventPacket packet) {
        super(session, packet);
    }

    @Override
    public long geBossUniqueEntityId() {
        return packet.getBossUniqueEntityId();
    }

    @Override
    public void setBossUniqueEntityId(long uniqueId) {
        packet.setBossUniqueEntityId(uniqueId);
    }

    @Override
    public BedrockBossEventAction getAction() {
        return BedrockBossEventAction.fromCloudburstAction(packet.getAction());
    }

    @Override
    public void setAction(BedrockBossEventAction action) {
        packet.setAction(action.getBedrockAction());
    }

    @Override
    public long getPlayerUniqueEntityId() {
        return packet.getPlayerUniqueEntityId();
    }

    @Override
    public void setPlayerUniqueEntityId(long uniqueId) {
        packet.setPlayerUniqueEntityId(uniqueId);
    }

    @Override
    public String getTitle() {
        return packet.getTitle();
    }

    @Override
    public void setTitle(String title) {
        packet.setTitle(title);
    }

    @Override
    public String getFilteredTitle() {
        return packet.getFilteredTitle();
    }

    @Override
    public void setFilteredTitle(String title) {
        packet.setFilteredTitle(title);
    }

    @Override
    public float getHealthPercentage() {
        return packet.getHealthPercentage();
    }

    @Override
    public void setHealthPercentage(float percentage) {
        packet.setHealthPercentage(percentage);
    }

    @Override
    public int getDarkenSky() {
        return packet.getDarkenSky();
    }

    @Override
    public void setDarkenSky(int darkenSky) {
        packet.setDarkenSky(darkenSky);
    }

    @Override
    public int getColor() {
        return packet.getColor();
    }

    @Override
    public void setColor(int color) {
        packet.setColor(color);
    }

    @Override
    public int getOverlay() {
        return packet.getOverlay();
    }

    @Override
    public void setOverlay(int overlay) {
        packet.setOverlay(overlay);
    }
}
