package net.marscraft.skyrpgstructure.shared.logging.logger.database;

import net.marscraft.skyrpgstructure.shared.logging.DBALLogging;
import net.marscraft.skyrpgstructure.shared.logging.LogLevel;
import net.marscraft.skyrpgstructure.shared.logging.logger.ILogger;
import net.marscraft.skyrpgstructure.shared.logging.logger.LoggerField;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Optional;

public class DatabaseLogger implements ILogger {

    private DBALLogging sql;

    public DatabaseLogger(JavaPlugin plugin) {
        //sql = new DBALLogging(new ConfigManager(plugin, "MySQLLogging.yml"));
    }

    @Override
    public void log(LogLevel logLevel, Optional<List<LoggerField>> message, Optional<Exception> ex) {

    }

    @Override
    public void log(LogLevel logLevel, LoggerField message, Optional<Exception> ex) {

    }

    @Override
    public String getName() {
        return null;
    }
}
