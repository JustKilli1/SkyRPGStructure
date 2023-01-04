package net.marscraft.skyrpgstructure.modules.custommobs.database;

import net.marscraft.skyrpgstructure.shared.ConfigManager;
import net.marscraft.skyrpgstructure.shared.database.DBAccessLayer;
import net.marscraft.skyrpgstructure.shared.logging.logger.console.ConsoleLogger;

public class DBALCustomMobs extends DBAccessLayer {

    public DBALCustomMobs(ConsoleLogger logger, ConfigManager mysqlConfig) {
        super(logger, mysqlConfig);
    }

}
