package gg.cloudworld.geyser.protocol.api.entity.data;

import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataType;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataTypes;

/**
 * Represents all the entity data properties that can be sent to a Bedrock client.
 */
public enum BedrockEntityData {
    /**
     * A byte containing a bitmask of entity flags.
     */
    FLAGS(EntityDataTypes.FLAGS),
    /**
     * An integer representing the structural integrity of the entity.
     */
    STRUCTURAL_INTEGRITY(EntityDataTypes.STRUCTURAL_INTEGRITY),
    /**
     * An integer that defines a variant of an entity. (e.g., horse, villager)
     */
    VARIANT(EntityDataTypes.VARIANT),
    /**
     * A block ID, used to identify a block.
     */
    BLOCK(EntityDataTypes.BLOCK),
    /**
     * A byte that represents the color of an entity.
     */
    COLOR(EntityDataTypes.COLOR),
    /**
     * A string that represents the name of an entity.
     */
    NAME(EntityDataTypes.NAME),
    /**
     * The entity ID of the owner of this entity.
     */
    OWNER_EID(EntityDataTypes.OWNER_EID),
    /**
     * The entity ID of the target of this entity.
     */
    TARGET_EID(EntityDataTypes.TARGET_EID),
    /**
     * A short indicating the remaining air supply of an entity.
     */
    AIR_SUPPLY(EntityDataTypes.AIR_SUPPLY),
    /**
     * A 3-integer array that represents an effect color.
     */
    EFFECT_COLOR(EntityDataTypes.EFFECT_COLOR),
    /**
     * A byte representing the ambience of a potion effect.
     * @deprecated since v685
     */
    @Deprecated
    EFFECT_AMBIENCE(EntityDataTypes.EFFECT_AMBIENCE),
    /**
     * An integer indicating the duration of a jump.
     */
    JUMP_DURATION(EntityDataTypes.JUMP_DURATION),
    /**
     * An integer representing hurt ticks.
     */
    HURT_TICKS(EntityDataTypes.HURT_TICKS),
    /**
     * An integer representing the hurt direction.
     */
    HURT_DIRECTION(EntityDataTypes.HURT_DIRECTION),
    /**
     * A float indicating the time left to row.
     */
    ROW_TIME_LEFT(EntityDataTypes.ROW_TIME_LEFT),
    /**
     * A float indicating the time right to row.
     */
    ROW_TIME_RIGHT(EntityDataTypes.ROW_TIME_RIGHT),
    /**
     * An integer representing a generic value.
     */
    VALUE(EntityDataTypes.VALUE),
    /**
     * A byte indicating if a wither skull is dangerous.
     */
    WITHER_SKULL_DANGEROUS(EntityDataTypes.WITHER_SKULL_DANGEROUS),
    /**
     * A byte that contains a bitmask of horse flags.
     */
    HORSE_FLAGS(EntityDataTypes.HORSE_FLAGS),
    /**
     * A byte indicating if a firework should be displayed.
     */
    DISPLAY_FIREWORK(EntityDataTypes.DISPLAY_FIREWORK),
    /**
     * The block state of the block to be displayed.
     */
    DISPLAY_BLOCK_STATE(EntityDataTypes.DISPLAY_BLOCK_STATE),
    /**
     * An integer indicating the display offset.
     */
    DISPLAY_OFFSET(EntityDataTypes.DISPLAY_OFFSET),
    /**
     * A byte indicating a custom display.
     */
    CUSTOM_DISPLAY(EntityDataTypes.CUSTOM_DISPLAY),
    /**
     * A byte representing the type of horse.
     */
    HORSE_TYPE(EntityDataTypes.HORSE_TYPE),
    /**
     * The old swell of a creeper.
     */
    OLD_SWELL(EntityDataTypes.OLD_SWELL),
    /**
     * The swell direction of a creeper.
     */
    SWELL_DIRECTION(EntityDataTypes.SWELL_DIRECTION),
    /**
     * The charge amount of a creeper.
     */
    CHARGE_AMOUNT(EntityDataTypes.CHARGE_AMOUNT),
    /**
     * The block state of the block being carried.
     * @deprecated since v827
     */
    @Deprecated
    CARRY_BLOCK_STATE(EntityDataTypes.CARRY_BLOCK_STATE),
    /**
     * A byte representing a client event.
     */
    CLIENT_EVENT(EntityDataTypes.CLIENT_EVENT),
    /**
     * A byte indicating if an item is being used.
     */
    USING_ITEM(EntityDataTypes.USING_ITEM),
    /**
     * A byte that contains a bitmask of player flags.
     */
    PLAYER_FLAGS(EntityDataTypes.PLAYER_FLAGS),
    /**
     * An integer representing the player index.
     */
    PLAYER_INDEX(EntityDataTypes.PLAYER_INDEX),
    /**
     * The position of the bed.
     */
    BED_POSITION(EntityDataTypes.BED_POSITION),
    /**
     * The x-power of a fireball.
     */
    FIREBALL_POWER_X(EntityDataTypes.FIREBALL_POWER_X),
    /**
     * The y-power of a fireball.
     */
    FIREBALL_POWER_Y(EntityDataTypes.FIREBALL_POWER_Y),
    /**
     * The z-power of a fireball.
     */
    FIREBALL_POWER_Z(EntityDataTypes.FIREBALL_POWER_Z),
    /**
     * An auxiliary power value.
     */
    AUX_POWER(EntityDataTypes.AUX_POWER),
    /**
     * The x-position of a fish.
     */
    FISH_X(EntityDataTypes.FISH_X),
    /**
     * The z-position of a fish.
     */
    FISH_Z(EntityDataTypes.FISH_Z),
    /**
     * The angle of a fish.
     */
    FISH_ANGLE(EntityDataTypes.FISH_ANGLE),
    /**
     * An auxiliary value data.
     */
    AUX_VALUE_DATA(EntityDataTypes.AUX_VALUE_DATA),
    /**
     * The entity ID of the leash holder.
     */
    LEASH_HOLDER(EntityDataTypes.LEASH_HOLDER),
    /**
     * The scale of an entity.
     */
    SCALE(EntityDataTypes.SCALE),
    /**
     * A byte indicating if an entity has an NPC.
     */
    HAS_NPC(EntityDataTypes.HAS_NPC),
    /**
     * A string that represents NPC data.
     */
    NPC_DATA(EntityDataTypes.NPC_DATA),
    /**
     * A string that represents entity actions.
     */
    ACTIONS(EntityDataTypes.ACTIONS),
    /**
     * A short indicating the maximum air supply of an entity.
     */
    AIR_SUPPLY_MAX(EntityDataTypes.AIR_SUPPLY_MAX),
    /**
     * An integer representing the mark variant of an entity.
     */
    MARK_VARIANT(EntityDataTypes.MARK_VARIANT),
    /**
     * A byte that represents the container type.
     */
    CONTAINER_TYPE(EntityDataTypes.CONTAINER_TYPE),
    /**
     * An integer representing the container size.
     */
    CONTAINER_SIZE(EntityDataTypes.CONTAINER_SIZE),
    /**
     * An integer representing the container strength modifier.
     */
    CONTAINER_STRENGTH_MODIFIER(EntityDataTypes.CONTAINER_STRENGTH_MODIFIER),
    /**
     * The position of the block target.
     */
    BLOCK_TARGET_POS(EntityDataTypes.BLOCK_TARGET_POS),
    /**
     * An integer representing the wither's invulnerable ticks.
     */
    WITHER_INVULNERABLE_TICKS(EntityDataTypes.WITHER_INVULNERABLE_TICKS),
    /**
     * The entity ID of wither's target A.
     */
    WITHER_TARGET_A(EntityDataTypes.WITHER_TARGET_A),
    /**
     * The entity ID of wither's target B.
     */
    WITHER_TARGET_B(EntityDataTypes.WITHER_TARGET_B),
    /**
     * The entity ID of wither's target C.
     */
    WITHER_TARGET_C(EntityDataTypes.WITHER_TARGET_C),
    /**
     * A short indicating a wither aerial attack.
     */
    WITHER_AERIAL_ATTACK(EntityDataTypes.WITHER_AERIAL_ATTACK),
    /**
     * The width of an entity.
     */
    WIDTH(EntityDataTypes.WIDTH),
    /**
     * The height of an entity.
     */
    HEIGHT(EntityDataTypes.HEIGHT),
    /**
     * An integer representing the fuse time of a TNT.
     */
    FUSE_TIME(EntityDataTypes.FUSE_TIME),
    /**
     * The offset of a seat.
     */
    SEAT_OFFSET(EntityDataTypes.SEAT_OFFSET),
    /**
     * A byte indicating if the rider's rotation is locked.
     */
    SEAT_LOCK_RIDER_ROTATION(EntityDataTypes.SEAT_LOCK_RIDER_ROTATION),
    /**
     * The degrees to lock the rider's rotation.
     */
    SEAT_LOCK_RIDER_ROTATION_DEGREES(EntityDataTypes.SEAT_LOCK_RIDER_ROTATION_DEGREES),
    /**
     * A byte indicating if the seat has rotation.
     */
    SEAT_HAS_ROTATION(EntityDataTypes.SEAT_HAS_ROTATION),
    /**
     * The offset in degrees of the seat's rotation.
     */
    SEAT_ROTATION_OFFSET_DEGREES(EntityDataTypes.SEAT_ROTATION_OFFSET_DEGREES),
    /**
     * The radius of an area effect cloud.
     */
    AREA_EFFECT_CLOUD_RADIUS(EntityDataTypes.AREA_EFFECT_CLOUD_RADIUS),
    /**
     * An integer representing the waiting time for an area effect cloud.
     */
    AREA_EFFECT_CLOUD_WAITING(EntityDataTypes.AREA_EFFECT_CLOUD_WAITING),
    /**
     * The particle ID of an area effect cloud.
     */
    AREA_EFFECT_CLOUD_PARTICLE(EntityDataTypes.AREA_EFFECT_CLOUD_PARTICLE),
    /**
     * The peek amount of a shulker.
     */
    SHULKER_PEEK_AMOUNT(EntityDataTypes.SHULKER_PEEK_AMOUNT),
    /**
     * The attach face of a shulker.
     */
    SHULKER_ATTACH_FACE(EntityDataTypes.SHULKER_ATTACH_FACE),
    /**
     * A boolean indicating if the shulker is attached.
     */
    SHULKER_ATTACHED(EntityDataTypes.SHULKER_ATTACHED),
    /**
     * The attach position of a shulker.
     */
    SHULKER_ATTACH_POS(EntityDataTypes.SHULKER_ATTACH_POS),
    /**
     * The entity ID of the trade target.
     */
    TRADE_TARGET_EID(EntityDataTypes.TRADE_TARGET_EID),
    /**
     * The career of a villager.
     * @deprecated unused AFAIK
     */
    @Deprecated
    CAREER(EntityDataTypes.CAREER),
    /**
     * A byte indicating if a command block is enabled.
     */
    COMMAND_BLOCK_ENABLED(EntityDataTypes.COMMAND_BLOCK_ENABLED),
    /**
     * The name of a command block.
     */
    COMMAND_BLOCK_NAME(EntityDataTypes.COMMAND_BLOCK_NAME),
    /**
     * The last output of a command block.
     */
    COMMAND_BLOCK_LAST_OUTPUT(EntityDataTypes.COMMAND_BLOCK_LAST_OUTPUT),
    /**
     * A byte indicating if a command block should track output.
     */
    COMMAND_BLOCK_TRACK_OUTPUT(EntityDataTypes.COMMAND_BLOCK_TRACK_OUTPUT),
    /**
     * The seat index of the controlling rider.
     */
    CONTROLLING_RIDER_SEAT_INDEX(EntityDataTypes.CONTROLLING_RIDER_SEAT_INDEX),
    /**
     * The strength of an entity.
     */
    STRENGTH(EntityDataTypes.STRENGTH),
    /**
     * The maximum strength of an entity.
     */
    STRENGTH_MAX(EntityDataTypes.STRENGTH_MAX),
    /**
     * The color of an evoker's spell casting.
     */
    EVOKER_SPELL_CASTING_COLOR(EntityDataTypes.EVOKER_SPELL_CASTING_COLOR),
    /**
     * The lifetime ticks of data.
     */
    DATA_LIFETIME_TICKS(EntityDataTypes.DATA_LIFETIME_TICKS),
    /**
     * The pose index of an armor stand.
     */
    ARMOR_STAND_POSE_INDEX(EntityDataTypes.ARMOR_STAND_POSE_INDEX),
    /**
     * The tick offset of an end crystal.
     */
    END_CRYSTAL_TICK_OFFSET(EntityDataTypes.END_CRYSTAL_TICK_OFFSET),
    /**
     * A byte indicating if the nametag should always be shown.
     */
    NAMETAG_ALWAYS_SHOW(EntityDataTypes.NAMETAG_ALWAYS_SHOW),
    /**
     * The second color of an entity.
     */
    COLOR_2(EntityDataTypes.COLOR_2),
    /**
     * The author of a name.
     */
    NAME_AUTHOR(EntityDataTypes.NAME_AUTHOR),
    /**
     * The score of an entity.
     */
    SCORE(EntityDataTypes.SCORE),
    /**
     * The entity ID of a balloon anchor.
     */
    BALLOON_ANCHOR_EID(EntityDataTypes.BALLOON_ANCHOR_EID),
    /**
     * The puffed state of a pufferfish.
     */
    PUFFED_STATE(EntityDataTypes.PUFFED_STATE),
    /**
     * The bubble time of a boat.
     */
    BOAT_BUBBLE_TIME(EntityDataTypes.BOAT_BUBBLE_TIME),
    /**
     * The entity ID of an agent.
     */
    AGENT_EID(EntityDataTypes.AGENT_EID),
    /**
     * The sitting amount of an entity.
     */
    SITTING_AMOUNT(EntityDataTypes.SITTING_AMOUNT),
    /**
     * The previous sitting amount of an entity.
     */
    SITTING_AMOUNT_PREVIOUS(EntityDataTypes.SITTING_AMOUNT_PREVIOUS),
    /**
     * The eating counter of an entity.
     */
    EATING_COUNTER(EntityDataTypes.EATING_COUNTER),
    /**
     * A second byte containing a bitmask of entity flags.
     */
    FLAGS_2(EntityDataTypes.FLAGS_2),
    /**
     * The laying amount of an entity.
     */
    LAYING_AMOUNT(EntityDataTypes.LAYING_AMOUNT),
    /**
     * The previous laying amount of an entity.
     */
    LAYING_AMOUNT_PREVIOUS(EntityDataTypes.LAYING_AMOUNT_PREVIOUS),
    /**
     * The duration of an area effect cloud.
     */
    AREA_EFFECT_CLOUD_DURATION(EntityDataTypes.AREA_EFFECT_CLOUD_DURATION),
    /**
     * The spawn time of an area effect cloud.
     */
    AREA_EFFECT_CLOUD_SPAWN_TIME(EntityDataTypes.AREA_EFFECT_CLOUD_SPAWN_TIME),
    /**
     * The change rate of an area effect cloud.
     * @deprecated since v685
     */
    @Deprecated
    AREA_EFFECT_CLOUD_CHANGE_RATE(EntityDataTypes.AREA_EFFECT_CLOUD_CHANGE_RATE),
    /**
     * The change of an area effect cloud on pickup.
     */
    AREA_EFFECT_CLOUD_CHANGE_ON_PICKUP(EntityDataTypes.AREA_EFFECT_CLOUD_CHANGE_ON_PICKUP),
    /**
     * The pickup count of an area effect cloud.
     */
    AREA_EFFECT_CLOUD_PICKUP_COUNT(EntityDataTypes.AREA_EFFECT_CLOUD_PICKUP_COUNT),
    /**
     * The interact text of an entity.
     */
    INTERACT_TEXT(EntityDataTypes.INTERACT_TEXT),
    /**
     * The trade tier of a villager.
     */
    TRADE_TIER(EntityDataTypes.TRADE_TIER),
    /**
     * The maximum trade tier of a villager.
     */
    MAX_TRADE_TIER(EntityDataTypes.MAX_TRADE_TIER),
    /**
     * The trade experience of a villager.
     */
    TRADE_EXPERIENCE(EntityDataTypes.TRADE_EXPERIENCE),
    /**
     * The skin ID of an entity.
     */
    SKIN_ID(EntityDataTypes.SKIN_ID),
    /**
     * The spawning frames of an entity.
     */
    SPAWNING_FRAMES(EntityDataTypes.SPAWNING_FRAMES),
    /**
     * The tick delay of a command block.
     */
    COMMAND_BLOCK_TICK_DELAY(EntityDataTypes.COMMAND_BLOCK_TICK_DELAY),
    /**
     * A byte indicating if a command block executes on first tick.
     */
    COMMAND_BLOCK_EXECUTE_ON_FIRST_TICK(EntityDataTypes.COMMAND_BLOCK_EXECUTE_ON_FIRST_TICK),
    /**
     * The ambient sound interval of an entity.
     */
    AMBIENT_SOUND_INTERVAL(EntityDataTypes.AMBIENT_SOUND_INTERVAL),
    /**
     * The ambient sound interval range of an entity.
     */
    AMBIENT_SOUND_INTERVAL_RANGE(EntityDataTypes.AMBIENT_SOUND_INTERVAL_RANGE),
    /**
     * The ambient sound event name of an entity.
     */
    AMBIENT_SOUND_EVENT_NAME(EntityDataTypes.AMBIENT_SOUND_EVENT_NAME),
    /**
     * The fall damage multiplier of an entity.
     */
    FALL_DAMAGE_MULTIPLIER(EntityDataTypes.FALL_DAMAGE_MULTIPLIER),
    /**
     * The raw text of an entity's name.
     */
    NAME_RAW_TEXT(EntityDataTypes.NAME_RAW_TEXT),
    /**
     * A byte indicating if an entity can ride a target.
     */
    CAN_RIDE_TARGET(EntityDataTypes.CAN_RIDE_TARGET),
    /**
     * The low tier cured trade discount of a villager.
     */
    LOW_TIER_CURED_TRADE_DISCOUNT(EntityDataTypes.LOW_TIER_CURED_TRADE_DISCOUNT),
    /**
     * The high tier cured trade discount of a villager.
     */
    HIGH_TIER_CURED_TRADE_DISCOUNT(EntityDataTypes.HIGH_TIER_CURED_TRADE_DISCOUNT),
    /**
     * The nearby cured trade discount of a villager.
     */
    NEARBY_CURED_TRADE_DISCOUNT(EntityDataTypes.NEARBY_CURED_TRADE_DISCOUNT),
    /**
     * The timestamp of the nearby cured discount.
     */
    NEARBY_CURED_DISCOUNT_TIME_STAMP(EntityDataTypes.NEARBY_CURED_DISCOUNT_TIME_STAMP),
    /**
     * The hitbox of an entity.
     */
    HITBOX(EntityDataTypes.HITBOX),
    /**
     * A byte indicating if an entity is buoyant.
     */
    IS_BUOYANT(EntityDataTypes.IS_BUOYANT),
    /**
     * The base runtime ID of an entity.
     */
    BASE_RUNTIME_ID(EntityDataTypes.BASE_RUNTIME_ID),
    /**
     * A byte indicating if properties should be updated.
     * @deprecated v557
     */
    @Deprecated
    UPDATE_PROPERTIES(EntityDataTypes.UPDATE_PROPERTIES),
    /**
     * The freezing effect strength of an entity.
     */
    FREEZING_EFFECT_STRENGTH(EntityDataTypes.FREEZING_EFFECT_STRENGTH),
    /**
     * The buoyancy data of an entity.
     */
    BUOYANCY_DATA(EntityDataTypes.BUOYANCY_DATA),
    /**
     * The goat horn count of an entity.
     */
    GOAT_HORN_COUNT(EntityDataTypes.GOAT_HORN_COUNT),
    /**
     * The movement sound distance offset of an entity.
     */
    MOVEMENT_SOUND_DISTANCE_OFFSET(EntityDataTypes.MOVEMENT_SOUND_DISTANCE_OFFSET),
    /**
     * The heartbeat interval in ticks.
     */
    HEARTBEAT_INTERVAL_TICKS(EntityDataTypes.HEARTBEAT_INTERVAL_TICKS),
    /**
     * The heartbeat sound event.
     */
    HEARTBEAT_SOUND_EVENT(EntityDataTypes.HEARTBEAT_SOUND_EVENT),
    /**
     * The last death position of a player.
     */
    PLAYER_LAST_DEATH_POS(EntityDataTypes.PLAYER_LAST_DEATH_POS),
    /**
     * The last death dimension of a player.
     */
    PLAYER_LAST_DEATH_DIMENSION(EntityDataTypes.PLAYER_LAST_DEATH_DIMENSION),
    /**
     * A byte indicating if a player has died.
     */
    PLAYER_HAS_DIED(EntityDataTypes.PLAYER_HAS_DIED),
    /**
     * The collision box of an entity.
     */
    COLLISION_BOX(EntityDataTypes.COLLISION_BOX),
    /**
     * The visible mob effects of an entity.
     */
    VISIBLE_MOB_EFFECTS(EntityDataTypes.VISIBLE_MOB_EFFECTS),
    /**
     * The filtered name of an entity.
     */
    FILTERED_NAME(EntityDataTypes.FILTERED_NAME),
    /**
     * The enter position of a bed.
     */
    BED_ENTER_POSITION(EntityDataTypes.BED_ENTER_POSITION),
    /**
     * The third person camera radius of a seat.
     */
    SEAT_THIRD_PERSON_CAMERA_RADIUS(EntityDataTypes.SEAT_THIRD_PERSON_CAMERA_RADIUS),
    /**
     * The camera relax distance smoothing of a seat.
     */
    SEAT_CAMERA_RELAX_DISTANCE_SMOOTHING(EntityDataTypes.SEAT_CAMERA_RELAX_DISTANCE_SMOOTHING);

    private final EntityDataType<?> dataType;

    BedrockEntityData(EntityDataType<?> dataType) {
        this.dataType = dataType;
    }

    public EntityDataType<?> getDataType() {
        return dataType;
    }
}