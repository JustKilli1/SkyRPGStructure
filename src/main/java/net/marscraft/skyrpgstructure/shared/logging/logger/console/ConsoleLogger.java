package net.marscraft.skyrpgstructure.shared.logging.logger.console;

import net.marscraft.skyrpgstructure.modules.module.IModule;
import net.marscraft.skyrpgstructure.shared.logging.LogLevel;
import net.marscraft.skyrpgstructure.shared.logging.logger.LoggerField;
import org.bukkit.Bukkit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

/**
 * Writes Log in Console
 * */
public class ConsoleLogger {
    private String name;
    private Optional<IModule> module;

    public ConsoleLogger(String name) {
        this.name = name;
        module = Optional.empty();
    }
    public ConsoleLogger(IModule module) {
        this.module = Optional.ofNullable(module);
        name = this.module.isPresent() ? this.module.get().getModuleName() : "Anonym";

    }

    public void log(LogLevel logLevel, Optional<String> message, Optional<Exception> ex) {
        if(logLevel == null) return;
        if(LogLevel.ERROR.equals(logLevel) && module.isPresent()) module.get().moduleError();
        if(!message.isPresent() && !ex.isPresent()) return;
        String rawMessage = message.isPresent() ? message.get() : "No Message";
        Bukkit.getConsoleSender().sendMessage(formatMessage(logLevel, rawMessage, ex));
    }

    @Deprecated
    public void log(LogLevel logLevel, LoggerField message, Optional<Exception> ex) {
        //log(logLevel, Optional.ofNullable(Arrays.asList(message)), ex);
    }

    public String getName() {
        return name;
    }

    /**
     * Formats a message
     * @param level The Log Level
     * @param msg the Message that gets formatted
     * @param ex Stacktrace from this Exception gets printed
     * @see LogLevel
     * */
    private String formatMessage(LogLevel level, String msg, Optional<Exception> ex){
        return level.getColor()+ "\nLevel: "+ level.getId() + " " + level.getName() + "\n" +
                "Module: " + name + "\n" +
                "Message: " + msg + (ex.isPresent() ?
                "\nException: " +  getStackTraceAsStr(ex.get()) : "");
    }

    /**
     * Gets the Stacktrace from an Exception as String
     * */
    private String getStackTraceAsStr(Exception ex) {
        StringWriter strWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(strWriter);
        ex.printStackTrace(printWriter);
        return strWriter.toString();
    }

    /**
     * Turns a LoggerField list into a String by combining all the value fields.
     * @param message List that gets converted
     * @return LoggerField list as String
     * @see LoggerField
     * */
    @Deprecated
    private String getMessage(List<LoggerField> message) {
        String result = "";
        for(int i = 0; i < message.size(); i++) {
            result += message.get(i).getValue();
            if(i != message.size()) result += " ";
        }
        return result;
    }

}
