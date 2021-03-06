/*******************************************************************************
 * Copyright (c) 2013 MCForge.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.ep.ggs.networking.packets.minecraft;

import java.io.DataInputStream;
import java.io.IOException;

import com.ep.ggs.iomodel.SMPPlayer;
import com.ep.ggs.networking.packets.PacketManager;
import com.ep.ggs.server.Server;


public class EntityAction extends SMPPacket {

	public EntityAction(String name, byte ID, PacketManager parent) {
		super(name, ID, parent);
	}

	public EntityAction(PacketManager pm) {
		this("EntityAction", (byte) 0x13, pm);
	}

	@SuppressWarnings("unused") // temp
	@Override
	public void handle(SMPPlayer player, Server server, DataInputStream reader) {
		try {
			int EID = reader.readInt();
			byte actionID = reader.readByte();
		}
		catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void write(SMPPlayer p, Server server, Object... obj) {
	}
}
