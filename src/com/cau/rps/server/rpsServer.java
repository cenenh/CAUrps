package com.cau.rps.server;

import java.net.InetSocketAddress;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpServer;
import com.cau.rps.server.connection_handler;
import com.cau.rps.server.DTO.clientDTO;

public class rpsServer {
	public static ArrayList<clientDTO> clientList = new ArrayList<clientDTO>(); 
	
	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8989), 0);
		server.createContext("/connection", new connection_handler());
		server.setExecutor(null); // creates a default executor
		server.start();
		System.out.println("Running http server....");
		
	}
}