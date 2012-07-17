package com.gamezgalaxy.GGS.networking.packets;

import com.gamezgalaxy.GGS.networking.Packet;
import com.gamezgalaxy.GGS.networking.PacketManager;
import com.gamezgalaxy.GGS.networking.PacketType;
import com.gamezgalaxy.GGS.server.Player;
import com.gamezgalaxy.GGS.server.Server;

public class SetBlock extends Packet {

	public SetBlock(String name, byte ID, PacketManager parent, PacketType packetType) {
		super(name, ID, parent, packetType);
	}
	public SetBlock(PacketManager pm) {
		super("SetBlock", (byte)0x05, pm, PacketType.Client_to_Server);
	}

	@Override
	public byte[] Read(Server server, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Write(Player player, Server server) {
		// TODO Auto-generated method stub
		
	}

}
