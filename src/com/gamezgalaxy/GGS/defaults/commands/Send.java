/*******************************************************************************
 * Copyright (c) 2012 GamezGalaxy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.gamezgalaxy.GGS.defaults.commands;

import com.gamezgalaxy.GGS.API.plugin.Command;
import com.gamezgalaxy.GGS.iomodel.Player;

public class Send extends Command
{
	@Override
	public String[] getShortcuts()
	{
		return new String[0];
	}

	@Override
	public String getName()
	{
		return "send";
	}

	@Override
	public boolean isOpCommand()
	{
		return false;
	}

	@Override
	public int getDefaultPermissionLevel()
	{
		return 0;
	}

	@Override
	public void execute(Player player, String[] args)
	{
		if(player.lastCommunication == null)
		{
			if(args.length == 3)
			{
				Player to = player.getServer().getPlayer(args[1]);

				if(to != null)
				{
					to.sendMessage("PM FROM " + player.username + ": " + args[2]);
					to.sendMessage("Use /send (message) to reply.");
					to.sendMessage("Use /send (username) (message) to start a new chat.");

					to.lastCommunication = player;
					player.lastCommunication = to;
				} else {
					player.sendMessage(to.username + " is not online.");
				}
			} else {
				player.sendMessage("No chat session exists. Please define the user you are trying to chat with.");
			}
		} else {
			if(args.length >= 2)
			{
				Player to = player.lastCommunication;

				if(to != null)
				{
					to.sendMessage("PM FROM " + player.username + ": " + args[1]);

					to.lastCommunication = player;
				} else {
					player.sendMessage(to.username + " is not online.");
				}
			}
		}
	}
}
