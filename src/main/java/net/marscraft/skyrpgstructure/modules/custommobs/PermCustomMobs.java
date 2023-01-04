package net.marscraft.skyrpgstructure.modules.custommobs;

/**
 * Permissions for Module CustomMobs
 * */
public enum PermCustomMobs {

    CREATECUSTOMITEMS("skyrpg.customitems.createcustomitem"),
    EDITCUSTOMITEM("skyrpg.customitems.editcustomitem")
    ;

    private String perm;

    PermCustomMobs(String perm) {
        this.perm = perm;
    }

    public String getPerm() {
        return perm;
    }


}
