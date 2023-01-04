package net.marscraft.skyrpgstructure.modules.custommobs.database;

import net.marscraft.skyrpgstructure.shared.database.DBHandler;

public class DBHCustomMobs extends DBHandler {

    private DBALCustomMobs sql;

    public DBHCustomMobs(DBALCustomMobs sql) {
        super(sql);
        this.sql = sql;
    }

}
