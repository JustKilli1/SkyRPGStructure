package net.marscraft.skyrpgstructure.modules.module;

import net.marscraft.skyrpgstructure.modules.custommobs.ModuleCustomMobs;
import net.marscraft.skyrpgstructure.modules.module.events.ModuleStateChangeEvent;
import net.marscraft.skyrpgstructure.shared.logging.LogLevel;
import net.marscraft.skyrpgstructure.shared.logging.logger.console.ConsoleLogger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class ModuleHandler implements Listener {

    /**
     * Instance of Main Class to register Module Events
     * */
    private JavaPlugin plugin;
    private ConsoleLogger logger;
    /**
     * List with all Modules in Plugin
     * */
    private List<IModule> modules;

    /**
     * Single ModuleHandler instance
     * */
    private static final ModuleHandler instance = new ModuleHandler();

    private ModuleHandler() {
        modules = new ArrayList<>();
        logger = new ConsoleLogger("ModuleHandler");
    }

    /**
     * Returns the Single Instance of the Class
     * @return Instance of Class ModuleHandler
     * */
    public static final ModuleHandler getInstance() { return instance;}

    /**
     * Handles {@code ModuleStateChangeEvent}
     * @param event Calling Event
     * @see ModuleStateChangeEvent
     * */
    @EventHandler
    public void handleModuleStateChange(ModuleStateChangeEvent event) {
        ModuleState old = event.getOldState();
        ModuleState updated = event.getUpdatedState();
        String moduleName = event.getCallingModule().getModuleName();

         logger.log(
                 ModuleState.ERROR_OCCURRED.equals(updated) ? LogLevel.ERROR : LogLevel.INFO,
                 Optional.of(moduleName + " >> Status von " + old + " zu " + updated + " geändert"),
                 Optional.empty()
         );
    }

    /**
     * Changes ModuleControl on given Module
     * @param moduleControl Value that gets set
     * @param moduleName Name of the Module which ModuleControl gets changed
     * @return Returns the state of the Module that got changed.<p>
     *         Returns an Empty Optional if no Module with the name {@code moduleName} got found.
     * @see ModuleControl
     * @see ModuleState
     * */
    public Optional<ModuleState> changeModuleControl(ModuleControl moduleControl, String moduleName) {
        for(IModule module : modules) {
            if(module.getModuleName().equalsIgnoreCase(moduleName)) {
                module.setModuleControl(moduleControl);
                return Optional.ofNullable(module.getModuleState());
            }
        }
        return Optional.empty();
    }
    /**
     * Changes ModuleControl on all Modules
     * @param moduleControl Value that gets set
     * @return Returns the {@code moduleName} and {@code ModuleState} of all Modules that got the
     *         {@code ModuleState.ERROR_OCCURRED} state after changing their Control.<p>
     *         Returns an Empty Optional if no Module got an Error
     * @see ModuleControl
     * @see ModuleState
     * */
    public Optional<Map<String, ModuleState>> changeModuleControl(ModuleControl moduleControl) {
        Map<String, ModuleState> occuredErrors = new HashMap<>();
        for(IModule module : modules) {
            module.setModuleControl(moduleControl);
            if(module.getModuleState().equals(ModuleState.ERROR_OCCURRED))
                occuredErrors.put(module.getModuleName(), module.getModuleState());
        }
        return occuredErrors.isEmpty() ? Optional.empty() : Optional.ofNullable(occuredErrors);
    }

    /**
     * Changes ModuleMode on one given Module
     * @param moduleMode Value that gets set
     * @param moduleName Name of the Module which ModuleMode gets changed
     * @return Returns the state of the Module that got changed.<p>
     *         Returns an Empty Optional if no Module with the name {@code moduleName} got found.
     * @see ModuleMode
     * @see ModuleState
     * */
    public Optional<ModuleState> changeModuleMode(ModuleMode moduleMode, String moduleName) {
        logger.log(LogLevel.ERROR, Optional.ofNullable("Test"), Optional.empty());
        for(IModule module : modules) {
            if(module.getModuleName().equalsIgnoreCase(moduleName)) {
                module.setModuleMode(moduleMode);
                return Optional.ofNullable(module.getModuleState());
            }
        }
        return Optional.empty();
    }
    /**
     * Changes ModuleMode on all Modules
     * @param moduleMode Value that gets set
     * @return Returns the {@code moduleName} and {@code ModuleState} of all Modules that got the
     *         {@code ModuleState.ERROR_OCCURRED} state after changing their Mode.<p>
     *         Returns an Empty Optional if no Module got an Error
     * @see ModuleMode
     * @see ModuleState
     * */
    public Optional<Map<String, ModuleState>> changeModuleMode(ModuleMode moduleMode) {
        Map<String, ModuleState> occuredErrors = new HashMap<>();
        for(IModule module : modules) {
            module.setModuleMode(moduleMode);
            if(module.getModuleState().equals(ModuleState.ERROR_OCCURRED))
                occuredErrors.put(module.getModuleName(), module.getModuleState());
        }
        return occuredErrors.isEmpty() ? Optional.empty() : Optional.ofNullable(occuredErrors);
    }

    /**
     * Returns the ModuleMode of the Module with the name {@code moduleName}
     * @param moduleName Name of the Module.
     * @return Optional with the ModuleMode of the given Module.<p>
     *         Empty Optional if no Module with the name {@code moduleName} was found
     * @see ModuleMode
     * */
    public Optional<ModuleMode> getModuleMode(String moduleName) {
        for(IModule module : modules) {
            if(module.getModuleName().equalsIgnoreCase(moduleName)) {
                return Optional.ofNullable(module.getModuleMode());
            }
        }
        return Optional.empty();
    }

    /**
     * Returns the ModuleMode of all Modules
     * @return Optional with the ModuleName and ModuleMode of all Modules.<p>
     *         Empty Optional if no Modules where found
     * @see ModuleMode
     * */
    public Optional<Map<String, ModuleMode>> getModuleMode() {
        Map<String, ModuleMode> moduleModes = new HashMap<>();
        for(IModule module : modules) {
            moduleModes.put(module.getModuleName(), module.getModuleMode());
        }
        return moduleModes.isEmpty() ? Optional.empty() : Optional.ofNullable(moduleModes);
    }

    /**
     * Returns the ModuleState of the Module with the name {@code moduleName}
     * @param moduleName Name of the Module.
     * @return Optional with the ModuleState of the given Module.<p>
     *         Empty Optional if no Module with the name {@code moduleName} was found
     * @see ModuleState
     * */
    public Optional<ModuleState> getModuleState(String moduleName) {
        for(IModule module : modules) {
            if(module.getModuleName().equalsIgnoreCase(moduleName)) {
                return Optional.ofNullable(module.getModuleState());
            }
        }
        return Optional.empty();
    }

    /**
     * Returns the ModuleState of all Modules
     * @return Optional with the ModuleName and ModuleState of all Modules.<p>
     *         Empty Optional if no Modules where found
     * @see ModuleState
     * */
    public Optional<Map<String, ModuleState>> getModuleState() {
        Map<String, ModuleState> moduleModes = new HashMap<>();
        for(IModule module : modules) {
            moduleModes.put(module.getModuleName(), module.getModuleState());
        }
        return moduleModes.isEmpty() ? Optional.empty() : Optional.ofNullable(moduleModes);
    }

    public void setPlugin(JavaPlugin plugin) {
        this.plugin = plugin;
        createModules();
    }

    /**
     * Creates instances from all Modules and adds them to field {@code modules}
     * */
    private void createModules() {
        modules = new ArrayList<>();
        ModuleCustomMobs moduleCustomMobs = ModuleCustomMobs.getInstance();
        moduleCustomMobs.setPlugin(plugin);
        moduleCustomMobs.setModuleMode(ModuleMode.LIVE);
        modules.add(moduleCustomMobs);
    }

}
