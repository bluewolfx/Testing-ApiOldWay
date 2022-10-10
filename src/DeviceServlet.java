package com.demo.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class DeviceRepository extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServeletResponse response) throws IOException, ServletException {
        
		String requestUrl = request.getRequestURI();
		String name = requestUrl.substring("/device/".length());
		
		Device device = DataStore.getInstance().getDevice(id);
		
		if(device != null){
			String json = "{\n";
			json += "\"name\": " + JSONObject.quote(device.getName()) + ",\n";
			json += "\"brand\": " + JSONObject.quote(device.getBrand()) + ",\n";
			json += "\"creationTime\": " + device.getCreationTime() + "\n";
            json += "\"id\": " + device.getId() + "\n";
			json += "}";
			response.getOutputStream().println(json);
		}
		else{
			
			response.getOutputStream().println("{}");
		}
	}
	
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = request.getParameter("name");
		String about = request.getParameter("brand");
		Date creationTime = request.getParameter("creationTime");
        Long id = request.getParameter("id");
		
		DataStore.getInstance().putDevice(new Device(name, brand, creationTime, id));
    }

}
