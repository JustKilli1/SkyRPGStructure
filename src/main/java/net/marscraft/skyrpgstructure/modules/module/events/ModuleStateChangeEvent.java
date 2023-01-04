package net.marscraft.skyrpgstructure.modules.module.events;

import net.marscraft.skyrpgstructure.modules.module.IModule;
import net.marscraft.skyrpgstructure.modules.module.ModuleState;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event that gets called when a Module changes its State
 * */
public class ModuleStateChangeEvent extends Event implements Cancellable {

    private static final HandlerList handlerList = new HandlerList();
    private boolean cancelled;
    private IModule callingModule;
    private ModuleState oldState;
    private ModuleState updatedState;

    public ModuleStateChangeEvent(IModule callingModule, ModuleState oldState, ModuleState updatedState) {
        cancelled = false;
        this.callingModule = callingModule;
        this.oldState = oldState;
        this.updatedState = updatedState;
    }


    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public IModule getCallingModule() {
        return callingModule;
    }

    public ModuleState getOldState() {
        return oldState;
    }

    public ModuleState getUpdatedState() {
        return updatedState;
    }
}
