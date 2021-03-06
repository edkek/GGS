/*******************************************************************************
 * Copyright (c) 2013 MCForge.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.ep.ggs.networking.packets.classicminecraft;

import java.io.IOException;
import java.nio.ByteBuffer;

import com.ep.ggs.API.io.PacketPrepareEvent;
import com.ep.ggs.iomodel.Player;
import com.ep.ggs.iomodel.SimpleIOClient;
import com.ep.ggs.networking.IOClient;
import com.ep.ggs.networking.packets.PacketManager;
import com.ep.ggs.server.Server;
import com.ep.ggs.world.PlaceMode;



/**
* This packet will handle both the 0x05 packet and the 0x06 packet
* @author Eddie
*
*/
public class SetBlock extends ClassicPacket {
    public SetBlock(String name, byte ID, PacketManager parent) {
        super(name, ID, parent);
    }
    public SetBlock(PacketManager pm) {
        super("SetBlock", (byte)0x05, pm);
        this.length = 8;
    }
    public byte[] getBytes(SimpleIOClient player, Server server, Object...parma) {
        short X = ((Short)parma[0]).shortValue();
        short Y = ((Short)parma[1]).shortValue();
        short Z = ((Short)parma[2]).shortValue();
        byte block = ((Byte)parma[3]).byteValue();
        ByteBuffer bb = ByteBuffer.allocate(8);
        bb.put((byte)0x06);
        bb.putShort(X);
        bb.putShort(Y);
        bb.putShort(Z);
        bb.put(block);
        if (player instanceof Player)
            ((Player)player).setHoldingBlock(block);
        return bb.array();
    }
    @Override
    public void Write(IOClient player, Server server, Object...parma) {
        PacketPrepareEvent event = new PacketPrepareEvent(player, this, server);
        server.getEventSystem().callEvent(event);
        if (event.isCancelled())
            return;
        short X = ((Short)parma[0]).shortValue();
        short Y = ((Short)parma[1]).shortValue();
        short Z = ((Short)parma[2]).shortValue();
        byte block = ((Byte)parma[3]).byteValue();
        ByteBuffer bb = ByteBuffer.allocate(8);
        bb.put((byte)0x06);
        bb.putShort(X);
        bb.putShort(Y);
        bb.putShort(Z);
        bb.put(block);
        if (player instanceof Player)
            ((Player)player).setHoldingBlock(block);
        try {
            player.writeData(bb.array());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void Handle(byte[] message, Server server, IOClient player) {
        Player p = null;
        if (player instanceof Player)
            p = (Player)player;
        else
            return;
        ByteBuffer bb = ByteBuffer.allocate(9);
        bb.put(message);
        short X = bb.getShort(0);
        short Y = bb.getShort(2);
        short Z = bb.getShort(4);
        PlaceMode pm = PlaceMode.parse(bb.get(6));
        byte block = bb.get(7);
        p.handleBlockChange(X, Y, Z, pm, block);
    }
    @Override
    public void Write(IOClient player, Server servers) {
    }

}

