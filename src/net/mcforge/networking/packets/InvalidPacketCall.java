/*******************************************************************************
 * Copyright (c) 2013 MCForge.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package net.mcforge.networking.packets;

public class InvalidPacketCall extends RuntimeException {

    public InvalidPacketCall(String string) {
        super(string);
    }

    private static final long serialVersionUID = 1L;
}
