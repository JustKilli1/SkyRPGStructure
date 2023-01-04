package net.marscraft.skyrpgstructure.shared.database;

import net.marscraft.skyrpgstructure.shared.ConfigManager;
import net.marscraft.skyrpgstructure.shared.logging.LogLevel;
import net.marscraft.skyrpgstructure.shared.logging.logger.console.ConsoleLogger;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Handles Database Connection
 * */
public class MySQL {

    private ConsoleLogger logger;
    private ConfigManager configManager;
    private FileConfiguration config;
    private String host, port, database, username, password;
    private Connection con;

    public MySQL(ConsoleLogger logger, ConfigManager configManager) {
        this.logger = logger;
        this.configManager = configManager;
        this.config = configManager.getConfig();
        createDefaultConfig();
    }

    /**
     * Creates Default Config File
     * */
    private void createDefaultConfig() {
        config.addDefault("sql.host", "SQL.IP");
        config.addDefault("sql.port", "3306");
        config.addDefault("sql.username", "USERNAME");
        config.addDefault("sql.password", "PASSWORD");
        config.addDefault("sql.database", "DATABASE");
        config.options().copyDefaults(true);
        configManager.save();
    }

    /**
     * Reloads the Config File
     * */
    private void reloadDBSettings() {
        configManager.reload();
        host = config.getString("sql.host");
        port = config.getString("sql.port");
        database = config.getString("sql.database");
        username = config.getString("sql.username");
        password = config.getString("sql.password");
    }

    /**
     * Connects to Database
     * */
    public void connect() {
        if(isConnected()) return;
        reloadDBSettings();
        String conStr = "jdbc:mysql://"
                + host + ":"
                + port + "/"
                + database
                + "?autoReconnect=true&useSSL=false";
        try {

            con = DriverManager.getConnection(conStr, username, password);
        } catch (SQLException ex) {
            logger.log(LogLevel.ERROR, Optional.of("Could not connect to Database. Connection Str: " + conStr), Optional.of(ex));
        }
    }

    /**
     * Disconnects from Database
     * */
    public void disconnect() {
        if(!isConnected()) return;
        try {
            con.close();
        } catch (SQLException ex) {
            logger.log(LogLevel.ERROR, Optional.of("Could not disconnect from Database"), Optional.of(ex));
        }
    }

    public boolean isConnected() {
        return (con != null);
    }

    public Connection getConnection() {
        return con;
    }

}
