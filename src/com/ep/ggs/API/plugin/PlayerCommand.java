/*******************************************************************************
 * Copyright (c) 2013 MCForge.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.ep.ggs.API.plugin;

import com.ep.ggs.API.CommandExecutor;
import com.ep.ggs.iomodel.Player;


public abstract class PlayerCommand extends Command {
    
    @Override
    public void execute(CommandExecutor e, String[] args0) {
        if (e instanceof Player) {
            Player player = (Player)e;
            execute(player, args0);
        }
        else
            e.sendMessage("This command can only be used ingame!");
    }
    
    /**
     * Execute this command
     * @param player
     *              The <b>client</b> that used this command
     * @param args
     *           The arguments passed
     */
    public abstract void execute(Player player, String[] args);
}

