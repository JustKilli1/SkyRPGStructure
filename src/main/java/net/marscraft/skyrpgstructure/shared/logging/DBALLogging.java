package net.marscraft.skyrpgstructure.shared.logging;

import net.marscraft.skyrpgstructure.shared.ConfigManager;
import net.marscraft.skyrpgstructure.shared.database.DBAccessLayer;
import net.marscraft.skyrpgstructure.shared.logging.logger.console.ConsoleLogger;

public class DBALLogging extends DBAccessLayer {


    public DBALLogging(ConsoleLogger logger, ConfigManager mysqlConfig) {
        super(logger, mysqlConfig);
    }

    public void createLoggingTable() {

    }

}
