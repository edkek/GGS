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


public class UpdateHealth extends SMPPacket {

    public UpdateHealth(String name, byte ID, PacketManager parent) {
        super(name, ID, parent);
    }
    
    public UpdateHealth(PacketManager pm) {
        this("UpdateHealth", (byte)0x08, pm);
    }

    @Override
    public void handle(SMPPlayer p, Server server, DataInputStream reader) {
    }

    @Override
    public void write(SMPPlayer player, Server server, Object... obj) {
        if (obj.length >= 3) {
            ByteBuffer bb;
            
            if (obj[0] instanceof Short && obj[1] instanceof Short && obj[2] instanceof Float) {
                bb = ByteBuffer.allocate(8);
                
                bb.put(ID);
                bb.putShort((Short)obj[0]);
                bb.putShort((Short)obj[1]);
                bb.putFloat((Float)obj[2]);
                
                try {
                    player.writeData(bb.array());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
