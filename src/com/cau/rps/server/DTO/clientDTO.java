package com.cau.rps.server.DTO;

import java.net.InetSocketAddress;

public class clientDTO {
	
	private InetSocketAddress clientIP;
	private int connectionID;
	private String clientName;
	
	public InetSocketAddress getClientIP() {
		return clientIP;
	}
	public void setClientIP(InetSocketAddress clientIP) {
		this.clientIP = clientIP;
	}
	public int getConnectionID() {
		return connectionID;
	}
	public void setConnectionID(int connectionID) {
		this.connectionID = connectionID;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
}
