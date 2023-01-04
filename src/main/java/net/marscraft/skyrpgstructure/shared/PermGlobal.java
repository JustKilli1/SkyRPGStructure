package net.marscraft.skyrpgstructure.shared;

public enum PermGlobal {

    /**
     * Highest Tier Permission
     * Can do everything with the Plugin
     * */
    ADMIN("skyrpg.admin"),
    /**
     * Developer Perm only for Debugging
     * */
    DEVELOPER("skyrpg.developer")

    ;

    private String perm;

    PermGlobal(String perm) {
        this.perm = perm;
    }

    public String getPerm() {
        return perm;
    }

}
