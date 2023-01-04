package net.marscraft.skyrpgstructure.shared.messages.player;

import net.marscraft.skyrpgstructure.shared.ConfigManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Provides basic Player Message Methods
 * */
public class MessageUtils {

    public static void sendPlayerMessage(Player player, String message) {
        player.sendMessage(message);
    }

    public static void sendPlayerMessage(Player player, String message, List<Parameter> parameters) {
        for (Parameter parameter : parameters) {
            message = message.replace(parameter.getName(), parameter.getValue());
        }
        sendPlayerMessage(player, message);
    }

    protected static ConfigManager createDefaultConfig(ConfigManager configManager, List<Message> messages) {
        FileConfiguration config = configManager.getConfig();
        messages.forEach(message -> config.addDefault(message.getConfigPath(), message.getDefaultMessage()));
        config.options().copyDefaults(true);
        configManager.save();
        return configManager;
    }

    protected static String getConfigValue(ConfigManager configManager, Message message) {
        return String.valueOf(configManager.getConfig().get(message.getConfigPath()));
    }

}
