package net.marscraft.skyrpgstructure.modules.module;

/**
 * Enum that displays the different States a module can enter
 * */
public enum ModuleState {

    STARTING(1, "Starting"),
    ACTIVE(2, "Active"),
    RELOADING(3, "Reloading"),
    SHUTTING_DOWN(4, "Shutting down"),
    INACTIVE(5, "Inactive"),
    ERROR_OCCURRED(6, "Error Occurred")
    ;
    private int id;
    private String name;


    ModuleState(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(ModuleState moduleState) { return moduleState == null ? false : moduleState.getId() == id; }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
