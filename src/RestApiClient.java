package com.demo.demo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.Scanner;
import org.json.JSONObject;

public class RestApiClient {

    public static void main(String... args) throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to device line editor");
        System.out.println("Want to insert device or get device info?");
        System.out.println("To insert type 'set' to get info type 'get'");
        String getOrSet = scanner.nextLine();
        if("get".equalsIgnoreCase(getOrSet)){
            System.out.println();
        }
    }

    public static string getDeviceData(Long id) throws IOException{
        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/device/" + id).openConnection();
		
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if(responseCode == 200){
			String response = "";
			Scanner sc = new Scanner(connection.getInputStream());
			while(sc.hasNextLine()){
				response += sc.nextLine();
				response += "\n";
			}
			sc.close();

			return response;
		}
		
		// an error happened
		return null;
    }

    public static void setDeviceData(String name, String brand, Date creationTime, Long id) throws IOException{
		HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/device/" + id).openConnection();

        connection.setrequestMethod("POST");

        String insertData = "name=" + URLEncoder.encode(name);
        insertData += "brand=" + URLEncoder.encode(brand);
        insertData += "creationTime=" + URLEncoder.encode(creationTime.toGMTString());
        insertData += "id=" + URLEncoder.encode(id.toString());

        connection.setDoOutput(true);

    
}
