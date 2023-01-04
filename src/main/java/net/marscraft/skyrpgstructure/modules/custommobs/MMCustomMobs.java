package net.marscraft.skyrpgstructure.modules.custommobs;

import net.marscraft.skyrpgstructure.shared.ConfigManager;
import net.marscraft.skyrpgstructure.shared.messages.player.MessageUtils;
import net.marscraft.skyrpgstructure.shared.messages.player.Message;
import net.marscraft.skyrpgstructure.shared.messages.player.Parameter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
/**
 * PlayerMessageHandler
 * Contains Messages for the Module CustomMobs
 * */
public class MMCustomMobs extends MessageUtils {


    public static final Message mobCreated = new Message("Mobs.New Mob Created", "Mob %mobname% erstellt!");
    public static final Message mobDeleted = new Message("items.deleted", "Item %itemname% gelöscht!");
    public static final Message editMobName = new Message("items.edit.rename", "Item %olditemname% hat jetzt den Namen %newitemname%");
    public static final Message editSpawnChance = new Message("items.drop", "Ein Item wurde gedroppt");
    private static ConfigManager configManager;

    public static void setConfigManager(ConfigManager configManager) {
        MMCustomMobs.configManager = configManager;
    }

    /**
     * Create Default CustomItems Config
     * */
    public static boolean createDefaultCustomItemsMessageConfig() {
        setConfigManager(
                MessageUtils.createDefaultConfig(configManager, Arrays.asList(
                        mobCreated,
                        mobDeleted,
                        editMobName,
                        editSpawnChance
                ))
        );
        return true;
    }

    /**
     * Sends a Player the given message
     * @param player Player who receives the Message
     * @param message Message that gets send to the Player
     * */
    public static void sendPlayerMessage(Player player, Message message) {
        sendPlayerMessage(player, getConfigValue(configManager, message));
    }

    /**
     * Sends a Player the given message and replaces Parameters in the message with their Values
     * @param player Player who receives the Message
     * @param message Message that gets send to the Player
     * @param parameters Parameters that get replaced in the Message
     * */
    public static void sendPlayerMessage(Player player, Message message, List<Parameter> parameters) {
        sendPlayerMessage(player, getConfigValue(configManager, message), parameters);
    }

}
