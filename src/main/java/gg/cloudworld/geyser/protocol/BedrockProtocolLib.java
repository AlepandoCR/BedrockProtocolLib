package gg.cloudworld.geyser.protocol;

import gg.cloudworld.geyser.protocol.api.BedrockProtocolAPI;
import gg.cloudworld.geyser.protocol.core.BedrockProtocolAPIImp;
import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.bedrock.SessionDisconnectEvent;
import org.geysermc.geyser.api.event.bedrock.SessionInitializeEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.session.GeyserSession;

public class BedrockProtocolLib implements Extension {
    private static BedrockProtocolAPI bedrockProtocol;

    @Subscribe
    public void onEnable(GeyserPostInitializeEvent event) {
        bedrockProtocol = new BedrockProtocolAPIImp();
    }

    @Subscribe
    public void onBedrockLeave(SessionDisconnectEvent event) {
        bedrockProtocol.getPacketSnifferManager().processLeave((GeyserSession) event.connection());
    }

    @Subscribe
    public void onBedrockJoin(SessionInitializeEvent event) {
        bedrockProtocol.getPacketSnifferManager().processJoin((GeyserSession) event.connection());
    }

    public static BedrockProtocolAPI getApi() {
        return bedrockProtocol;
    }
}

