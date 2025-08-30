package gg.cloudworld.geyser.protocol.api.events.types.ui;

import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.cloudburstmc.protocol.bedrock.packet.BossEventPacket;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a Bedrock Boss Event, which is used to manage and display boss bars in the Bedrock protocol.
 * This interface extends the {@link BedrockPacket} and provides methods to manipulate boss event properties.
 */
public interface BedrockBossEvent extends BedrockUIEvent<BossEventPacket> {

    /**
     * Gets the unique entity ID of the boss.
     *
     * @return the unique entity ID of the boss.
     */
    long geBossUniqueEntityId();

    /**
     * Sets the unique entity ID of the boss.
     *
     * @param uniqueId the unique entity ID to set.
     */
    void setBossUniqueEntityId(long uniqueId);

    /**
     * Gets the current action of the boss event.
     *
     * @return the current {@link BedrockBossEventAction}.
     */
    BedrockBossEventAction getAction();

    /**
     * Sets the action for the boss event.
     *
     * @param action the {@link BedrockBossEventAction} to set.
     */
    void setAction(BedrockBossEventAction action);

    /**
     * Gets the unique entity ID of the player associated with the boss event.
     *
     * @return the unique entity ID of the player.
     */
    long getPlayerUniqueEntityId();

    /**
     * Sets the unique entity ID of the player associated with the boss event.
     *
     * @param uniqueId the unique entity ID to set.
     */
    void setPlayerUniqueEntityId(long uniqueId);

    /**
     * Gets the title of the boss event.
     *
     * @return the title of the boss event.
     */
    String getTitle();

    /**
     * Sets the title of the boss event.
     *
     * @param title the title to set.
     */
    void setTitle(String title);

    /**
     * Gets the filtered title of the boss event.
     *
     * @return the filtered title of the boss event.
     */
    String getFilteredTitle();

    /**
     * Sets the filtered title of the boss event.
     *
     * @param title the filtered title to set.
     */
    void setFilteredTitle(String title);

    /**
     * Gets the health percentage of the boss.
     *
     * @return the health percentage of the boss.
     */
    float getHealthPercentage();

    /**
     * Sets the health percentage of the boss.
     *
     * @param percentage the health percentage to set.
     */
    void setHealthPercentage(float percentage);

    /**
     * Gets the darken sky value for the boss event.
     *
     * @return the darken sky value.
     */
    int getDarkenSky();

    /**
     * Sets the darken sky value for the boss event.
     *
     * @param darkenSky the darken sky value to set.
     */
    void setDarkenSky(int darkenSky);

    /**
     * Gets the color of the boss bar.
     *
     * @return the color of the boss bar.
     */
    int getColor();

    /**
     * Sets the color of the boss bar.
     *
     * @param color the color to set.
     */
    void setColor(int color);

    /**
     * Gets the overlay of the boss bar.
     *
     * @return the overlay of the boss bar.
     */
    int getOverlay();

    /**
     * Sets the overlay of the boss bar.
     *
     * @param overlay the overlay to set.
     */
    void setOverlay(int overlay);

    /**
     * Represents the possible actions for a boss event.
     */
    enum BedrockBossEventAction {

        /**
         * Action to create a new boss event.
         */
        CREATE(BossEventPacket.Action.CREATE),

        /**
         * Action to register a player to the boss event.
         */
        REGISTER_PLAYER(BossEventPacket.Action.REGISTER_PLAYER),

        /**
         * Action to remove the boss event.
         */
        REMOVE(BossEventPacket.Action.REMOVE),

        /**
         * Action to unregister a player from the boss event.
         */
        UNREGISTER_PLAYER(BossEventPacket.Action.UNREGISTER_PLAYER),

        /**
         * Action to update the health percentage of the boss.
         */
        UPDATE_PERCENTAGE(BossEventPacket.Action.UPDATE_PERCENTAGE),

        /**
         * Action to update the name of the boss event.
         */
        UPDATE_NAME(BossEventPacket.Action.UPDATE_NAME),

        /**
         * Action to update the properties of the boss event.
         */
        UPDATE_PROPERTIES(BossEventPacket.Action.UPDATE_PROPERTIES),

        /**
         * Action to update the style of the boss event.
         */
        UPDATE_STYLE(BossEventPacket.Action.UPDATE_STYLE),

        /**
         * Action to query the boss event.
         */
        QUERY(BossEventPacket.Action.QUERY);

        private final BossEventPacket.Action bedrockAction;

        /**
         * Constructs a BossEventAction with the corresponding Bedrock action.
         *
         * @param bedrockAction the Bedrock action associated with this BossEventAction.
         */
        BedrockBossEventAction(BossEventPacket.Action bedrockAction) {
            this.bedrockAction = bedrockAction;
        }

        /**
         * Gets the Bedrock action associated with this BossEventAction.
         *
         * @return the Bedrock action.
         */
        public BossEventPacket.Action getBedrockAction() {
            return this.bedrockAction;
        }

        public static BedrockBossEventAction fromCloudburstAction(BossEventPacket.@NotNull Action action) {
            return BedrockBossEventAction.valueOf(action.name());
        }
    }
}