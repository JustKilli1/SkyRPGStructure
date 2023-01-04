package net.marscraft.skyrpgstructure.shared;

import net.marscraft.skyrpgstructure.shared.logging.LogLevel;
import net.marscraft.skyrpgstructure.shared.logging.logger.console.ConsoleLogger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.Optional;

public class ConfigManager {

    private File file;
    private FileConfiguration config;
    private ConsoleLogger logger;

    public ConfigManager(ConsoleLogger logger, Plugin plugin, String path) {
        this(logger, plugin.getDataFolder().getAbsolutePath() + "/" + path);
    }

    public ConfigManager(ConsoleLogger logger, String path) {
        this.logger = logger;
        file = new File(path);
        config = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Saves the Config file
     * @return true if success
     * */
    public boolean save() {
        try {
            config.save(file);
            return true;
        } catch (Exception ex) {
            logger.log(LogLevel.ERROR, Optional.of("Could not save ConfigFile with Path: " + file.getAbsolutePath()), Optional.of(ex));
            return false;
        }
    }
    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
    public File getFile() { return file; }
    public FileConfiguration getConfig() {
        return config;
    }
}
