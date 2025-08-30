package gg.cloudworld.geyser.protocol.api.events;

import gg.cloudworld.geyser.protocol.core.event.BedrockEventBuilderFactoryImp;
import gg.cloudworld.geyser.protocol.core.event.BedrockEventBuilderImp;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;

public interface BedrockEventBuilderFactory {

    static <T extends BedrockEvent<P>, P extends BedrockPacket> BedrockEventBuilderImp<T, P> builderFor(Class<T> eventInterfaceClass){
       return BedrockEventBuilderFactoryImp.getInstance().builderFor(eventInterfaceClass);
    }
}
