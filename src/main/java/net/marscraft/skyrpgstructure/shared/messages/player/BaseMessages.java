package net.marscraft.skyrpgstructure.shared.messages.player;

import net.marscraft.skyrpgstructure.shared.ConfigManager;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

/**
 * PlayerMessageHandler
 * Contains some Base Messages
 * */
public class BaseMessages extends MessageUtils{

    /**
     * Send when a Command was not found.<p>
     * Parameter<p>
     * %command% --> the command that got send
     * */
    public static final Message commandNotFound = new Message("commands.commandnotfound", "Command %command% wurde nicht gefunden");

    /**
     * Send when the Player has no Permission
     * */
    public static final Message noPermission = new Message("permissions.nopermission", "Dir fehlt die Berechtigung um die Aktion auszuführen.");

    private static ConfigManager configManager;

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static void setConfigManager(ConfigManager configManager) {
        BaseMessages.configManager = configManager;
    }

    public static boolean createDefaultBaseMessagesConfig() {
        setConfigManager(
                MessageUtils.createDefaultConfig(configManager, Arrays.asList(
                        commandNotFound,
                        noPermission
                ))
        );
        return true;
    }

    public static void sendPlayerMessage(Player player, Message message) {
        sendPlayerMessage(player, getConfigValue(configManager, message));
    }

    public static void sendPlayerMessage(Player player, Message message, List<Parameter> parameters) {
        sendPlayerMessage(player, getConfigValue(configManager, message), parameters);
    }

}
