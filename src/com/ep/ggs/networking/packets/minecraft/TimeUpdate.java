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
import java.nio.ByteBuffer;

import com.ep.ggs.iomodel.SMPPlayer;
import com.ep.ggs.networking.packets.PacketManager;
import com.ep.ggs.server.Server;


public class TimeUpdate extends SMPPacket {

    public TimeUpdate(String name, byte ID, PacketManager parent) {
        super(name, ID, parent);
    }
    
    public TimeUpdate(PacketManager pm) {
        this("LoginRequest", (byte)0x04, pm);
    }

    @Override
    public void handle(SMPPlayer p, Server server, DataInputStream reader) {
    }

    @Override
    public void write(SMPPlayer player, Server server, Object... obj) {
        if (obj.length >= 2) {
            ByteBuffer bb;
            
            if (obj[0] instanceof Long && obj[1] instanceof Long) {
                bb = ByteBuffer.allocate(17);
                
                bb.put(ID);
                bb.putLong((Long)obj[0]);
                bb.putLong((Long)obj[1]);
                
                try {
                    player.writeData(bb.array());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
