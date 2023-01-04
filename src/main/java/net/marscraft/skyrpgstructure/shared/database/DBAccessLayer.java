package net.marscraft.skyrpgstructure.shared.database;

import net.marscraft.skyrpgstructure.shared.ConfigManager;
import net.marscraft.skyrpgstructure.shared.logging.LogLevel;
import net.marscraft.skyrpgstructure.shared.logging.logger.console.ConsoleLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DBAccessLayer {

    protected ConsoleLogger logger;
    /**
     * Normal Sql Commands no Data processing
     * */

    private MySQL mySql;

    public DBAccessLayer(ConsoleLogger logger, ConfigManager mysqlConfig) {
        this.logger = logger;
        mySql = new MySQL(logger, mysqlConfig);
        mySql.connect();
    }

    public void disable() {
        mySql.disconnect();
    }

    /**
     * Reconnects to database if not connected
     */
    private void checkAndReconnectConnection() {
        if (!mySql.isConnected()) {
            mySql.connect();
        }
    }

    protected boolean executeSQLRequest(String sqlQuery) {
        checkAndReconnectConnection();
        if (mySql.isConnected()) {
            Connection connection = mySql.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                logger.log(LogLevel.ERROR, Optional.of("Execute SQL request failed. " + sqlQuery), Optional.of(ex));
                return false;
            }
        } else {
            return false;
        }
    }
    protected ResultSet querySQLRequest(String sqlQuery) {
        checkAndReconnectConnection();
        if (mySql.isConnected()) {
            Connection connection = mySql.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                return ps.executeQuery();
            } catch (SQLException ex) {
                logger.log(LogLevel.ERROR, Optional.of("Query SQL request failed. " + sqlQuery), Optional.of(ex));
                return null;
            }
        } else {
            return null;
        }
    }
}
