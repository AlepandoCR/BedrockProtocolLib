package gg.cloudworld.geyser.protocol.api.events.types.ui;

import org.cloudburstmc.protocol.bedrock.data.ScoreInfo;
import org.cloudburstmc.protocol.bedrock.packet.SetScorePacket;

import java.util.List;

/**
 * Represents an event for setting scores in the Bedrock UI.
 * This interface provides methods to manage score actions and score information.
 */
public interface BedrockSetScoreEvent extends BedrockUIEvent<SetScorePacket> {

    /**
     * Retrieves the current score action associated with this event.
     *
     * @return the {@link BedrockScoreAction} representing the current action.
     */
    BedrockScoreAction getAction();

    /**
     * Sets the score action for this event.
     *
     * @param action the {@link BedrockScoreAction} to set.
     */
    void setAction(BedrockScoreAction action);

    /**
     * Retrieves the list of score information associated with this event.
     *
     * @return a list of {@link ScoreInfo} objects.
     */
    List<ScoreInfo> getInfos();

    /**
     * Sets the list of score information for this event.
     *
     * @param inputs a list of {@link ScoreInfo} objects to set.
     */
    void setInfos(List<ScoreInfo> inputs);

    /**
     * Clears all score information associated with this event.
     */
    void clearInfos();

    /**
     * Enum representing the possible score actions in the Bedrock protocol.
     */
    enum BedrockScoreAction {
        /**
         * Represents the action of setting a score.
         */
        SET(SetScorePacket.Action.SET),

        /**
         * Represents the action of removing a score.
         */
        REMOVE(SetScorePacket.Action.REMOVE);

        private final SetScorePacket.Action action;

        /**
         * Constructs a BedrockScoreAction with the corresponding Bedrock protocol action.
         *
         * @param action the {@link SetScorePacket.Action} associated with this enum value.
         */
        BedrockScoreAction(SetScorePacket.Action action) {
            this.action = action;
        }

        /**
         * Retrieves the Bedrock protocol action associated with this enum value.
         *
         * @return the {@link SetScorePacket.Action}.
         */
        public SetScorePacket.Action getBedrockAction() {
            return action;
        }

        /**
         * Converts a Bedrock protocol action to its corresponding BedrockScoreAction.
         *
         * @param action the {@link SetScorePacket.Action} to convert.
         * @return the corresponding {@link BedrockScoreAction}.
         */
        public static BedrockScoreAction fromCloudburstAction(SetScorePacket.Action action) {
            return BedrockScoreAction.valueOf(action.name());
        }
    }
}