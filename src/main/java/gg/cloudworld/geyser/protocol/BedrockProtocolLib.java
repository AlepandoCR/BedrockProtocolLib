package gg.cloudworld.geyser.protocol;

import gg.cloudworld.geyser.protocol.api.events.BedrockEvent;
import gg.cloudworld.geyser.protocol.api.events.BedrockEventBuilderFactory;
import gg.cloudworld.geyser.protocol.api.events.listener.manager.BedrockEventManager;
import gg.cloudworld.geyser.protocol.api.logger.BedrockLogger;
import gg.cloudworld.geyser.protocol.api.test.TestListener;
import gg.cloudworld.geyser.protocol.core.event.BedrockEventBuilderFactoryImp;
import gg.cloudworld.geyser.protocol.core.event.BedrockEventManagerImp;
import gg.cloudworld.geyser.protocol.core.event.types.entity.BedrockAddEntityEventImp;
import gg.cloudworld.geyser.protocol.core.event.types.ui.BedrockBossEventImp;
import gg.cloudworld.geyser.protocol.core.event.types.ui.BedrockSetScoreEventImp;
import gg.cloudworld.geyser.protocol.core.event.types.world.BedrockWorldEventImp;
import gg.cloudworld.geyser.protocol.core.logger.BedrockLoggerImp;
import gg.cloudworld.geyser.protocol.core.packet.BedrockPacketSnifferManager;
import gg.cloudworld.geyser.protocol.core.packet.PacketEventRegistry;
import org.cloudburstmc.protocol.bedrock.packet.*;
import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.bedrock.SessionDisconnectEvent;
import org.geysermc.geyser.api.event.bedrock.SessionInitializeEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.session.GeyserSession;

public class BedrockProtocolLib implements Extension
{
    private static<P extends BedrockPacket, E extends BedrockEvent<P>> void registerEvent(Class<P> packetClass, Class<E> eventClass){
        PacketEventRegistry.getInstance().register(packetClass,eventClass);
    }

    private static void registerEvents(){
        registerEvent(AddEntityPacket.class, BedrockAddEntityEventImp.class);
        registerEvent(SetScorePacket.class, BedrockSetScoreEventImp.class);
        registerEvent(BossEventPacket.class, BedrockBossEventImp.class);
        registerEvent(LevelEventPacket.class, BedrockWorldEventImp.class);
    }

    @Subscribe
    public void onEnable(GeyserPostInitializeEvent event){
        registerEvents();
        getBedrockEventManager().registerListener(new TestListener());
    }

    @Subscribe
    public void onBedrockLeave(SessionDisconnectEvent e){
        BedrockPacketSnifferManager.getInstance().processLeave((GeyserSession) e.connection());
    }
    @Subscribe
    public void onBedrockJoin(SessionInitializeEvent e){
        BedrockPacketSnifferManager.getInstance().processJoin((GeyserSession) e.connection());
    }

    public static BedrockEventBuilderFactory getBedrockEventBuilderFactory(){
        return BedrockEventBuilderFactoryImp.getInstance();
    }

    public static BedrockLogger getLogger(){
        return BedrockLoggerImp.getInstance();
    }

    public static BedrockEventManager getBedrockEventManager(){
        return BedrockEventManagerImp.getInstance();
    }
}

