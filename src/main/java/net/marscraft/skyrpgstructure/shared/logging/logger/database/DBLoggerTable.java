package net.marscraft.skyrpgstructure.shared.logging.logger.database;

import java.util.HashMap;
import java.util.Map;

public class DBLoggerTable {

    private String name;
    private Map<String, DBLoggerFieldTypes> fields;

    public DBLoggerTable(String name, Map<String, DBLoggerFieldTypes> fields) {
        this.name = name;
        this.fields = fields != null ? fields : new HashMap<>();
    }

    public DBLoggerTable(String name) {
        this(name, null);
    }

    public void addField(String fieldName, DBLoggerFieldTypes fieldType) { fields.put(fieldName, fieldType); }

    public void removeField(String fieldName) {
        fields.remove(fieldName);
    }

    public String getName() {
        return name;
    }
}
