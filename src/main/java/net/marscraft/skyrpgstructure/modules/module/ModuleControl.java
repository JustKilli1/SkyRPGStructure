package net.marscraft.skyrpgstructure.modules.module;

/**
 * Enum thats used to Control Modules
 * */
public enum ModuleControl {

    ENABLE(1, "skyrpg.modules.control.enable"),
    RELOAD(2, "skyrpg.modules.control.reload"),
    DISABLE(3, "skyrpg.modules.control.disable")
    ;

    private int id;
    private String permission;

    ModuleControl(int id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public boolean equals(ModuleControl moduleControl) {
        return moduleControl == null ? false : id == moduleControl.getId();
    }

    public String getPermission() {
        return permission;
    }
    public int getId() { return id; }

}
