package com.luv2code.springdemo.rest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Admin;
import com.luv2code.springdemo.entity.Event;
import com.luv2code.springdemo.entity.exmpleClass;


@RestController
@RequestMapping("/api")
public class EventRestController {
	
	//public e EventObj;
	List<Event> theEvents = new ArrayList<Event>();
//	Event newObjOne = new Event("101", "25th Sept", "India", "user101");
//	Event newObjTwo = new Event("102", "29th Sept", "USA", "user102");	
//	
	
	//Boolean firstime = false;
		
	//return list of all events
	
		@GetMapping("/events")
		public List<Event> getEvents() {
					return theEvents;
		}
		
		//Delete an event
		@RequestMapping(value = "events/{eventId}", method = RequestMethod.DELETE)
		public String delete(@PathVariable("eventId") String eventId) {

		for(int i = 0; i < theEvents.size(); i++)
		{
			String eventIdCompare = theEvents.get(i).getEventId();
			System.out.print(eventIdCompare);
			System.out.print(eventId);
			if(eventIdCompare.equals(eventId))
			{
				theEvents.remove(i);
				return "Event Deleted Succesfully";
			}
		}
		
			return "Event Cannot be deleted";
		
		}	
		
		//Post new event
		@PostMapping(path = "/events/addevent")
		
	    public String createAnEvent(@RequestBody exmpleClass newEvent) {
			Event newObj = new Event(newEvent.date, newEvent.eventId, newEvent.place, newEvent.userId);
			theEvents.add(newObj);
			return "Event Successfully created";
		}
		
		//Validate the user
		@PostMapping(path = "/login")
		
	    public Boolean validateUser(@RequestBody Admin ad) {
			//Admin ad = new Admin(userCred.userName, userCred.password);
			if(ad.userName.equals("admin") && ad.password.contentEquals("admin"))
			{
				return true;
			}
			return false;
		}
		
		// Update event
		@PutMapping("/events/update/{eventId}")
		public String updateEve(@RequestBody exmpleClass updateEvent, @PathVariable String eventId) 
		{
			Boolean eventExists = false;
			Event newChange = new Event(updateEvent.date, updateEvent.eventId, updateEvent.place, updateEvent.userId);
			for(int i = 0; i < theEvents.size(); i++)
			{
				String pid = theEvents.get(i).getEventId();
				if( pid.equals(updateEvent.eventId))
				{
					theEvents.remove(i);
					theEvents.add(newChange);
					eventExists = true;
				}
			}
			if(eventExists = false)
			{
				return "Event cannot be updated";
			}
			
			return "Event updated successfully";
			
		} 
}

