package net.marscraft.skyrpgstructure.modules.custommobs.commands;

import net.marscraft.skyrpgstructure.modules.custommobs.MMCustomMobs;
import net.marscraft.skyrpgstructure.modules.custommobs.ModuleCustomMobs;
import net.marscraft.skyrpgstructure.shared.Utils;
import net.marscraft.skyrpgstructure.shared.logging.LogLevel;
import net.marscraft.skyrpgstructure.shared.logging.logger.console.ConsoleLogger;
import net.marscraft.skyrpgstructure.shared.messages.player.BaseMessages;
import net.marscraft.skyrpgstructure.shared.messages.player.Parameter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Optional;

import static net.marscraft.skyrpgstructure.modules.custommobs.PermCustomMobs.CREATECUSTOMITEMS;

/**
 * Test Command
 * */
public class CmdTest implements CommandExecutor {

    private ConsoleLogger logger;

    public CmdTest(ConsoleLogger logger) {
        this.logger = logger;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(!Utils.checkForPerm(Optional.ofNullable(ModuleCustomMobs.getInstance()), player, CREATECUSTOMITEMS.getPerm(), true)) return false;
        if(args.length > 1) {
            BaseMessages.sendPlayerMessage(player, BaseMessages.commandNotFound, Arrays.asList(
                    new Parameter("%command%", args[0] + " " + args[1])
            ));
            return false;
        }
        player.sendMessage("Hello du Opfer");
        MMCustomMobs.sendPlayerMessage(player, MMCustomMobs.mobCreated, Arrays.asList(
                new Parameter("%mobname%", "Toter Zombie")
        ));
        logger.log(LogLevel.ERROR, Optional.of("Test Error No"), Optional.empty());
        return false;
    }
}
