/*******************************************************************************
 * Copyright (c) 2012 GamezGalaxy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.gamezgalaxy.GGS.API.plugin;

import com.gamezgalaxy.GGS.server.Server;
import com.gamezgalaxy.GGS.server.Tick;

public abstract class Game extends Plugin implements Tick {

	public Game(Server server) {
		super(server);
	}
	
	public abstract void Start();
	
	public abstract void Stop();
	
	public abstract void Tick();
}
