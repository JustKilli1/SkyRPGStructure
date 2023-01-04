package net.marscraft.skyrpgstructure.modules.custommobs;

import net.marscraft.skyrpgstructure.modules.custommobs.commands.CmdTest;
import net.marscraft.skyrpgstructure.modules.module.*;
import net.marscraft.skyrpgstructure.modules.module.events.ModuleStateChangeEvent;
import net.marscraft.skyrpgstructure.shared.ConfigManager;
import net.marscraft.skyrpgstructure.shared.logging.logger.console.ConsoleLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static net.marscraft.skyrpgstructure.modules.module.ModuleControl.*;
import static net.marscraft.skyrpgstructure.modules.module.ModuleMode.*;
import static net.marscraft.skyrpgstructure.modules.module.ModuleState.*;

public class ModuleCustomMobs implements IModule {

    private static final ModuleCustomMobs instance = new ModuleCustomMobs();
    private final String moduleName = "CustomMobs";
    private final String moduleDescription = "Creates Custom Mobs";
    private JavaPlugin plugin;
    private static ConsoleLogger logger;
    private ModuleControl moduleControl;
    private ModuleMode moduleMode;
    private ModuleState moduleState;


    private ModuleCustomMobs() {

    }

    /**
     * Returns the Single Instance of the Class
     * @return Instance of Class ModuleHandler
     * */
    public static final ModuleCustomMobs getInstance() {
        if(logger == null) logger = new ConsoleLogger(instance);
        return instance;
    }

    @Override
    public ModuleState setModuleControl(ModuleControl moduleControl) {
        if(moduleControl == null) return moduleState;
        if(moduleControl.equals(this.moduleControl)) return moduleState;
        if(plugin == null) {
            setModuleState(ERROR_OCCURRED);
            return moduleState;
        }
        this.moduleControl = moduleControl;
        switch (moduleControl) {
            case ENABLE:
                setModuleState(STARTING);
                registerCommands();
                registerListener();
                if(!createConfigs()) {
                    setModuleState(ERROR_OCCURRED);
                    break;
                }
                setModuleState(ACTIVE);
                break;
            case RELOAD:
                setModuleState(RELOADING);
                //Reload logic
                setModuleState(ACTIVE);
                break;
            case DISABLE:
                setModuleState(SHUTTING_DOWN);
                //Shut down logic
                setModuleState(INACTIVE);
                break;
        }
        return moduleState;
    }

    private void registerCommands() {
        plugin.getCommand("test").setExecutor(new CmdTest(logger));
    }

    private void registerListener() {

    }

    private boolean createConfigs() {
        MMCustomMobs.setConfigManager(new ConfigManager(logger, plugin, "/CustomMobs/messages.yml"));
        return MMCustomMobs.createDefaultCustomItemsMessageConfig();
    }

    @Override
    public void setModuleMode(ModuleMode moduleMode) {
        setModuleControl(ENABLE);
        this.moduleMode = moduleMode;
        String permission;
        switch (moduleMode) {
            case LIVE:
                permission = LIVE.getPermission();
                //Permission Check
                break;
            case TEST:
                permission = TEST.getPermission();
                //Permission Check
                break;
            case MAINTENANCE:
                permission = MAINTENANCE.getPermission();
                //Permission Check
                break;
        }
    }

    @Override
    public void setPlugin(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void moduleError() {
        setModuleState(ERROR_OCCURRED);
    }

    @Override
    public ModuleMode getModuleMode() {
        return moduleMode;
    }

    @Override
    public ModuleState getModuleState() {
        return moduleState;
    }

    @Override
    public String getModuleName() {
        return moduleName;
    }

    @Override
    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleState(ModuleState moduleState) {
        ModuleState old = this.moduleState;
        this.moduleState = moduleState;
        Bukkit.getPluginManager().callEvent(new ModuleStateChangeEvent(this, old, this.moduleState));
    }

}
