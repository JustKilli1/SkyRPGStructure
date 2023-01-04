package net.marscraft.skyrpgstructure.shared;

import net.marscraft.skyrpgstructure.modules.module.IModule;
import net.marscraft.skyrpgstructure.modules.module.ModuleMode;
import net.marscraft.skyrpgstructure.shared.messages.player.BaseMessages;
import org.bukkit.entity.Player;

import java.util.Optional;

/**
 * A Class that contains useful Methods for the whole Project
 * */
public class Utils {


    /**
     * Checks if the Player has the Permissions to execute the Action
     * @param callingModule The Module from where the Method was called.
     *                     Is used to check if Player has the needed Permissions to use the Module in its current ModuleMode
     * @param callingPlayer Player that gets checked
     * @param perm Permissions that gets checked
     * @param sendNoPermMessage If true automatically send the user the NoPermission Base Message if the permission check was false.
     * @see IModule
     * @see ModuleMode
     * */
    public static boolean checkForPerm(Optional<IModule> callingModule, Player callingPlayer, String perm, boolean sendNoPermMessage) {
        if(callingPlayer.hasPermission(PermGlobal.ADMIN.getPerm())) return true;

        boolean result = callingModule.isPresent() ?
                callingPlayer.hasPermission(perm) && callingPlayer.hasPermission(callingModule.get().getModuleMode().getPermission())
                :
                callingPlayer.hasPermission(perm);

        if(!result && sendNoPermMessage) BaseMessages.sendPlayerMessage(callingPlayer, BaseMessages.noPermission);
        return result;
    }

}
