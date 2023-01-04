package net.marscraft.skyrpgstructure.shared.messages.player;

/**
 * Store Object for Messages that get send to Player.
 * Contains ConfigPath of Message and the Default Message.
 * */
public class Message {

    private String configPath, defaultMessage;

    public Message(String configPath, String defaultMessage) {
        this.configPath = configPath;
        this.defaultMessage = defaultMessage;
    }

    public String getConfigPath() {
        return configPath;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }


}
