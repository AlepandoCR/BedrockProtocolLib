# BedrockProtocolLib

A Geyser extension that provides a simple API for other extensions to listen to Bedrock packet events.

## Requirements

- Java 21 or higher
- Geyser API 2.8.3 or higher

## Installation

1. Place the `.jar` file into the `extensions` folder of your Geyser installation.
2. Restart Geyser.

## For Developers

### Usage

To listen to Bedrock packet events, you need to create a class that implements `BedrockEventListener` and has methods annotated with `@BedrockEventHandler`.

### Available Events

- `BedrockAddEntityEvent`
- `BedrockBossEvent`
- `BedrockSetScoreEvent`
- `BedrocWorldEvent`

### Example

Here is an example of a listener that listens for the `AddEntityEvent`:

```java
import gg.cloudworld.geyser.protocol.api.events.listener.BedrockEventListener;
import gg.cloudworld.geyser.protocol.api.events.listener.annotations.BedrockEventHandler;
import gg.cloudworld.geyser.protocol.api.events.types.entity.AddEntityEvent;
import org.geysermc.geyser.entity.type.Entity;

public class MyListener implements BedrockEventListener {
    @BedrockEventHandler
    public void onEntitySpawn(BedrockAddEntityEvent entityEvent){
        // Do something with the event
    }
}
```

### Registering the listener

To register your listener, you need to call `BedrockProtocolLib.getApi().getEventManager().registerListener()` from your extension's `onEnable()` method:

```java
import gg.cloudworld.geyser.protocol.api.events.listener.manager.BedrockEventManager;
import org.geysermc.geyser.api.event.lifecycle.GeyserEnableEvent;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.api.event.Subscribe;

public class MyExtension implements Extension {

    @Subscribe
    public void onEnable(GeyserPostInitializeEvent event) {
        BedrockProtocolLib.getApi().getEventManager().registerListener(new MyListener());
    }
}
```

