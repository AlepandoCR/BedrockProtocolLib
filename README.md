# BedrockProtocolLib

A Geyser extension that provides a simple API for other extensions to listen to Bedrock packet events.

## Installation

1. Download the latest release from the [releases page](https://github.com/your-repo/releases).
2. Place the downloaded `.jar` file into the `extensions` folder of your Geyser installation.
3. Restart Geyser.

## For Developers

## Usage

To listen to Bedrock packet events, you need to create a class that implements `BedrockEventListener` and has methods annotated with `@BedrockEventHandler`.

### Example

Here is an example of a listener that listens for the `AddEntityEvent`:

```java
import gg.cloudworld.geyser.protocol.api.events.listener.BedrockEventListener;
import gg.cloudworld.geyser.protocol.api.events.listener.annotations.BedrockEventHandler;
import gg.cloudworld.geyser.protocol.api.events.types.entity.AddEntityEvent;
import org.geysermc.geyser.entity.type.Entity;

public class MyListener implements BedrockEventListener {
    @BedrockEventHandler
    public void onEntitySpawn(AddEntityEvent entityEvent){
        Class<? extends Entity> entityClass =  entityEvent.getEntity().getRawEntity().getClass();
        String msg = "Entity spawned: " + entityClass.getSimpleName();
        // Do something with the event
    }
}
```

### Registering the listener

To register your listener, you need to call `BedrockEventManager.registerListener()` from your extension's `onEnable()` method:

```java
import gg.cloudworld.geyser.protocol.api.events.listener.manager.BedrockEventManager;
import org.geysermc.geyser.api.extension.Extension;

public class MyExtension implements Extension {

    @Suscribe
    public void onEnable(GeyserPostInitializeEvent event) {
        BedrockEventManager.registerListener(new MyListener());
    }
}
```

