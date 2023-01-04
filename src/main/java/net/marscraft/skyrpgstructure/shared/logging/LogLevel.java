package net.marscraft.skyrpgstructure.shared.logging;

import org.bukkit.ChatColor;

/**
 * Different Log Levels
 * */
public enum LogLevel {


    INFO(1, "Info", 'I', ChatColor.GREEN),
    WARNING(2, "Warning", 'W', ChatColor.YELLOW),
    ERROR(3, "Du bist am Arsch", 'E', ChatColor.RED)
    ;
    private int id;
    private String name;
    private char shortForm;
    private ChatColor color;

    LogLevel(int id, String name, char shortForm, ChatColor color) {
        this.id = id;
        this.name = name;
        this.shortForm = shortForm;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getShortForm() {
        return shortForm;
    }

    public ChatColor getColor() {
        return color;
    }
}
