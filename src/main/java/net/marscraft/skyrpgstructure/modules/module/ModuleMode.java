package net.marscraft.skyrpgstructure.modules.module;

/**
 * Enum that's used to chane the current Mode of a Module
 * */
public enum ModuleMode {

    LIVE(1, "Live", "skyrpg.modules.access.live"),
    TEST(2, "Test", "skyrpg.modules.access.test"),
    MAINTENANCE(3, "Maintenance", "skyrpg.modules.access.maintenance")
    ;

    private int id;
    private String name, permission;

    ModuleMode(int id, String name, String permission) {
        this.id = id;
        this.name = name;
        this.permission = permission;
    }

    public boolean equals(ModuleMode moduleMode) { return moduleMode == null ? false : id == moduleMode.getId(); }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }

}
