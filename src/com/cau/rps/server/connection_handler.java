package com.cau.rps.server;

import com.cau.rps.server.rpsServer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.cau.rps.server.DTO.clientDTO;


public class connection_handler implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		/*System.out.println(t.getRequestMethod()); // GET
		System.out.println(t.getRemoteAddress()); // 0:0:0:0:0:0:0:1:13553
		System.out.println(t.getRequestURI()); // /test?a=80&b=50
		System.out.println(t.getRequestURI().getQuery()); //a=80&b=50*/
		String response = "default_response";
		clientDTO client = new clientDTO();
		if(t.getRequestURI().getQuery().length() > 0)
		{
			Map<String, String> params = queryToMap(t.getRequestURI().getQuery());
			String id = params.get("id");
			String name = new String(params.get("name").getBytes("UTF-8"), "UTF-8");
			client.setClientIP(t.getRemoteAddress());
			client.setConnectionID(Integer.parseInt(id));
			client.setClientName(name);
		}	
		rpsServer.clientList.add(client);
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
		for(int i=0; i<rpsServer.clientList.size();i++)
		{
			System.out.println(rpsServer.clientList.get(i).getClientIP().getAddress());
			System.out.println(rpsServer.clientList.get(i).getClientName());
			System.out.println(rpsServer.clientList.get(i).getConnectionID());
		}
		System.out.println("");
	}
	
	private static Map<String, String> queryToMap(String query) {
		Map<String, String> result = new HashMap<String, String>();
		for (String param : query.split("&")) {
			String pair[] = param.split("=");
			if (pair.length > 1) {
				for(int i=0; i<pair.length; i = i+2){
					result.put(pair[i], pair[++i]);	
				}
			} else {
				result.put(pair[0], "");
			}
		}
		return result;
	}

}
