package gg.cloudworld.geyser.protocol.api.events.listener.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a method as a Bedrock event handler.
 * Methods annotated with this will be invoked when the corresponding event is triggered.
 *
 * <p>Usage:</p>
 * <ul>
 *   <li>Apply this annotation to methods intended to handle specific Bedrock events.</li>
 *   <li>The method must match the expected signature for the event listener.</li>
 * </ul>
 *
 * <p>Retention:</p>
 * <ul>
 *   <li>This annotation is retained at runtime, allowing it to be accessed via reflection.</li>
 * </ul>
 *
 * <p>Target:</p>
 * <ul>
 *   <li>This annotation can only be applied to methods.</li>
 * </ul>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BedrockEventHandler {
}