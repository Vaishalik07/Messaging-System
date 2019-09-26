package com.luv2code.Client;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.awt.List;
import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
//import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
public class ClientApp2 {

	private static Boolean validateUser(String username, String password)
	{
	    final String uri = "http://localhost:8080/spring-rest-demo/api/login";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    JSONObject j = new JSONObject();
	    j.put("userName", username);
	    j.put("password", password);
		//postForObject(URI url, Object request, Class<T> responseType)
		return restTemplate.postForObject(uri,j, Boolean.class);
	   
	}
	// Get all events
	private static Object[] getAllEvents()
	{
	    final String uri = "http://localhost:8080/spring-rest-demo/api/events";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    
		//System.out.println(restTemplate.getForObject(uri, List<String>.class));
		//System.out.println();
		
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(uri, Object[].class);
		Object[] objects = responseEntity.getBody();
		/*for(int i  =0; i < objects.length; i++)
		{
			System.out.println(objects[i]);
		}  */
		return objects;
	}
	
	//Delete an event
	private static String deleteAnEvent(String eventId)
	{
	    final String uri = "http://localhost:8080/spring-rest-demo/api/events/{eventId}";
	    RestTemplate restTemplate = new RestTemplate();
	 // URI (URL) parameters
	 Map<String, String> urlParams = new HashMap<String, String>();
	 urlParams.put("eventId", eventId);
	 restTemplate.delete(uri, urlParams);
	 return "Event Deleted Succesfully"; 
	}
	
	//Post event
		private static String addEvent(String eventid, String date, String userid, String place)
		{
	    final String uri = "http://localhost:8080/spring-rest-demo/api/events/addevent";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    JSONObject j = new JSONObject();
	    j.put("eventId", eventid);
	    j.put("date", date);
	    j.put("place", place);
	    j.put("userId", userid);
		//postForObject(URI url, Object request, Class<T> responseType)
		return restTemplate.postForObject(uri,j, String.class);
		}	
		
	//update an event
		private static String updateAnEvent(String eventid, String date, String userid, String place)
		{
	    final String uri = "http://localhost:8080/spring-rest-demo/api/events/update/{eventId}";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    JSONObject j = new JSONObject();
	    j.put("eventId", eventid);
	    j.put("date", date);
	    j.put("place", place);
	    j.put("userId", userid);
		//postForObject(URI url, Object request, Class<T> responseType)
	    Map<String, String> urlParams = new HashMap<String, String>();
		 urlParams.put("eventId", eventid);	    
		 restTemplate.put(uri, j ,urlParams);
		 System.out.println("Event Updated successfully");
		 return "Event updated successfully";
	   
		}	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//validateUser("admin","admin");
		//getAllEvents();
		//deleteAnEvent("102");
		//addEvent("103", "23 spt", "kashmir", "user109");
		//updateAnEvent("102","","","");
		Scanner sc = new Scanner(System.in);
		
		Boolean isAdmin = false;
		Boolean isLoggedIn = false;
		
		while(true)
		{
			if(!isLoggedIn)
			{
				System.out.println("Welcome to Event Management System");
				System.out.println("Select 1 to log in as Admin");
				System.out.println("Select 2 to continue as Guest");
				System.out.println("Select 3 to Exit");
				
				int Option = sc.nextInt();
				switch(Option)
				{
				case 1:
				{
					System.out.println("Enter Username");
					String username = sc.next();
					System.out.println("Enter Password");
					String password = sc.next();
					Boolean flag = validateUser(username, password);
					if(flag)
					{
						isLoggedIn = true;
						isAdmin = true;
						System.out.println("---------------------------------------------------------");
						System.out.println("Hello Admin!");
						System.out.println("Select 1 to get all Events");
						System.out.println("Select 2 to delete an Event");
						System.out.println("Select 3 to add a new Event");
						System.out.println("Select 4 to update an Event");
						System.out.println("Select 5 to Exit admin !");
						System.out.println("---------------------------------------------------------");
						int o = sc.nextInt();
						switch(o)
						{
						case 1:
						{
							Object[] ob = getAllEvents();
							for(int i = 0; i < ob.length; i++)
							{
								System.out.println(ob[i]);
							}
							
							break;
						}
						case 2:
						{
							String del = sc.next();
							String sm = deleteAnEvent(del);
							if(sm.equals("Event Deleted Succesfully"))
							{
								System.out.println("Event deleted successfully");
							}
							else
							{
								System.out.println("Error in event deletion");
							}
							break;
						}
						
						case 3:
						{
							String add01 = sc.next();
							String add02 = sc.next();
							String add03 = sc.next();
							String add04 = sc.next();
							String ans = addEvent(add01, add02, add03, add04);
							if(ans.equals("Event Successfully created"))
							{
								System.out.println("Event creation Successful!");
							}
							else
							{
								System.out.println("Event invalid!");
							}
							break;
						}
						
						case 4:
						{
							String up01 = sc.next();
							String up02 = sc.next();
							String up03 = sc.next();
							String up04 = sc.next();
							String u = updateAnEvent(up01, up02, up03, up04);
							if(u.equals("Event updated successfully"))
							{
								System.out.println("The event has been updated");
							}
							else
							{
								System.out.println("Event updation unsuccessful !");
							}
							break;
						}
						case 5:
						{
							System.out.println("Admin logging off !");
							break;
						}
					}
					}
					break;
				}
				case 2:
				{
     				Object[] ob = getAllEvents();
					for(int i = 0; i < ob.length; i++)
     				{
  					System.out.print(ob[i]);
     				}
	
					
					break;
				}
				default:
					System.out.println("Please select a valid option");
					
				}	
			}
			
			if(isLoggedIn && isAdmin)
			{
				System.out.println("--------------------------------------------------------");
				System.out.println("Select 1 to get all Events");
				System.out.println("Select 2 to delete an Event");
				System.out.println("Select 3 to add a new Event");
				System.out.println("Select 4 to update an Event");
				System.out.println("Select 5 to Exit admin !");
				System.out.println("---------------------------------------------------------");
				int o = sc.nextInt();
				switch(o)
				{
				case 1:
				{
					Object[] ob = getAllEvents();
					for(int i = 0; i < ob.length; i++)
					{
						System.out.print(ob[i]);
					}
					break;
				}
				case 2:
				{
					String del = sc.next();
					String sm = deleteAnEvent(del);
					if(sm.equals("Event Deleted Succesfully"))
					{
						System.out.println("Event deleted successfully");
					}
					else
					{
						System.out.println("Error in event deletion");
					}
					break;
				}
				
				case 3:
				{
					String add01 = sc.next();
					String add02 = sc.next();
					String add03 = sc.next();
					String add04 = sc.next();
					String ans = addEvent(add01, add02, add03, add04);
					if(ans.equals("Event Successfully created"))
					{
						System.out.println("Event creation Successful !");
					}
					else
					{
						System.out.println("Event invalid!");
					}
					break;
				}
				
				case 4:
				{
					String up01 = sc.next();
					String up02 = sc.next();
					String up03 = sc.next();
					String up04 = sc.next();
					String u = updateAnEvent(up01, up02, up03, up04);
					if(u.equals("Event updated successfully"))
					{
						System.out.println("The event has been updated");
					}
					else
					{
						System.out.println("Event updation unsuccessful !");
					}
					break;
				}
				case 5:
				{
					System.out.println("Admin logging off !");
					break;
				}
			}
		}
			
			
			}
	}

}
