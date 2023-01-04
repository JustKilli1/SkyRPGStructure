package net.marscraft.skyrpgstructure.shared.messages.player;

/**
 * Store Object for Parameters used in Messages.
 * Contains the Name of the Parameter<p>
 * Syntax: %paramname%<p>
 * and the value
 * @see Message
 * */
public class Parameter {

    private String name, value;

    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}
