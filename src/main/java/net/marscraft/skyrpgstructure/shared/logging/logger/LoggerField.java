package net.marscraft.skyrpgstructure.shared.logging.logger;

import java.util.Optional;

public class LoggerField {

    private Optional<String> tableName, fieldName;
    private String value;

    /**
     * Constructor for DatabaseLogger
     * Not Implemented
     * */
    public LoggerField(String fieldName, String tableName, String value) {
        this.tableName = Optional.ofNullable(tableName);
        this.fieldName = Optional.ofNullable(fieldName);
        this.value = value;
    }

    /**
     * Constructor for ConsoleLogger
     * */
    public LoggerField(String value) {
        this.value = value;
    }

    public Optional<String> getFieldName() {
        return fieldName;
    }

    public String getValue() {
        return value;
    }
}
