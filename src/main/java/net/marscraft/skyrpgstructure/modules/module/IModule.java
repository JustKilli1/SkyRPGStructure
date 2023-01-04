package net.marscraft.skyrpgstructure.modules.module;

import org.bukkit.plugin.java.JavaPlugin;

public interface IModule {

    /**
     * Changes the Module Control
     * @see ModuleControl
     * */
    ModuleState setModuleControl(ModuleControl moduleControl);

    /**
     * Changes the ModuleMode
     * @see ModuleMode
     * */
    void setModuleMode(ModuleMode moduleMode);
    void setPlugin(JavaPlugin plugin);
    void moduleError();

    /**
     * Returns the current Module Mode
     * @see ModuleMode
     * */
    ModuleMode getModuleMode();

    /**
     * Returns the current ModuleState
     * @see ModuleState
     * */
    ModuleState getModuleState();

    /**
     * Returns the Module name
     * */
    String getModuleName();

    /**
     * Returns the Module Description
     * */
    String getModuleDescription();

}
