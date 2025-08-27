package gg.cloudworld.geyser.protocol.core.entity.util;

import org.geysermc.geyser.entity.type.Entity;
import org.geysermc.geyser.session.GeyserSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class EntityUtils {

    public static Entity getEntity(GeyserSession session, long geyserId) {
        return session.getEntityCache().getEntityByGeyserId(geyserId);
    }
}
