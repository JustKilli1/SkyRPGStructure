package net.marscraft.skyrpgstructure.base;

import net.marscraft.skyrpgstructure.modules.module.ModuleControl;
import net.marscraft.skyrpgstructure.modules.module.ModuleHandler;
import net.marscraft.skyrpgstructure.modules.module.ModuleMode;
import net.marscraft.skyrpgstructure.shared.ConfigManager;
import net.marscraft.skyrpgstructure.shared.logging.logger.console.ConsoleLogger;
import net.marscraft.skyrpgstructure.shared.messages.player.BaseMessages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class SkyRPGStructure extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Hello World!");
        ModuleHandler moduleHandler = ModuleHandler.getInstance();
        moduleHandler.setPlugin(this);
        Bukkit.getPluginManager().registerEvents(moduleHandler, this);
        moduleHandler.changeModuleControl(ModuleControl.RELOAD);
        moduleHandler.changeModuleControl(ModuleControl.DISABLE, "customitems");
        moduleHandler.changeModuleMode(ModuleMode.TEST, "customitems");
        ConsoleLogger sharedLogger = new ConsoleLogger("Shared");
        BaseMessages.setConfigManager(new ConfigManager(sharedLogger, this, "BaseMessages.yml"));
        BaseMessages.createDefaultBaseMessagesConfig();
    }

    @Override
    public void onDisable() {

    }
}
