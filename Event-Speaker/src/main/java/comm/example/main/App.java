package comm.example.main;

import java.sql.Date;
import java.util.Collection;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.EventService;
import com.example.service.EventServiceImpl;
import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;

import comm.example.model.Event;
import comm.example.model.Speaker;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
    SpeakerService speakerService=ctx.getBean("speakerServiceImpl", SpeakerServiceImpl.class);
    EventService eventService=ctx.getBean("eventServiceImpl", EventServiceImpl.class);
    int key;
    Scanner sc=new Scanner(System.in);
    
    System.out.println("enter your choice");
    System.out.println("1.Insert a speaker");
    System.out.println("2. Insert an event");
    System.out.println("3. Remove a speaker");
    System.out.println("4. Remove an event");
    System.out.println("5. Find a speaker");
    System.out.println("6. Find an event");
    System.out.println("7. List all speakers");
    System.out.println("8. List all events");
    
    System.out.println("0. Exit");
    
    key=sc.nextInt();
    
    

			
			while(key!=0)
			{
			switch (key) {
			
				case 0:
			       
		        //exit
		        System.exit(0);
				break;
			
				case 1:
			        //create speaker
			        Speaker speaker=speakerService.createSpeaker(new Speaker("Nilay","nilay@example.com","YES"));
			        System.out.println("Data Inserted" + speaker);
					break;
				case 2:
			        //create event
			        Event event=eventService.createEvent(new Event());
			        
			        System.out.println("Enter the event name");
			        String eventName=sc.next();
			        event.setEventName(eventName);
			        
			        System.out.println("Enter the event date");
			        String str="2020-05-16";
			        Date eventDate= Date.valueOf(str);
			        event.setEventDate(eventDate);
			        
			        System.out.println("Enter the time");
			        int eventTime=3;
			        event.setEventTime(eventTime);
			        

			        System.out.println("Data Inserted" + event);
			        break;
					

				case 3:
				       
			        //remove speaker
			        speakerService.removeSpeaker(1);
					break;
					
				case 4:
				       
			        //remove event
					
					System.out.println("Enter the ID of event you want to find : ");
					int id=sc.nextInt();
			        eventService.removeEvent(id);
					break;	
					
				case 5:
					//find speaker by id
					System.out.println("Enter the speaker ID to find your speaker : ");
					int id1=sc.nextInt();
					Speaker speaker1 = speakerService.findSpeaker(id1);
					System.out.println("Speaker : " +speaker1);
					
				case 6:
					//find event by id
					System.out.println("Enter the speaker ID to find your speaker : ");
					int id2=sc.nextInt();
					Event event1 = eventService.findEvent(id2);
					System.out.println("Speaker : " +event1);
					
				case 7:
					//list all speakers
					Collection<Speaker> collection = speakerService.findAllSpeaker();
					for (Speaker s : collection) {
						System.out.println(s);
					}
					break;
					
				case 8:
					//list all events
					Collection<Event> collection1 = eventService.findAllEvent();
					for (Event e : collection1) {
						System.out.println(e);
					}
					break;
					
//				case 9:
					//find event by speaker id
					//event obj is required
	//				Speaker objSpeaker = speakerService.findSpeaker((event.getSpeakerId()).getSpeakerID());
					
//					break;
					
					
					
				default:
					System.out.println("Please enter a valid choice");
					break;		
					
				}
			
				System.out.println("enter your choice");
			    System.out.println("1.Insert a speaker");
			    System.out.println("2. Insert an event");
			    System.out.println("3. Remove a speaker");
			    System.out.println("4. Remove an event");
			    System.out.println("5. Find a speaker");
			    System.out.println("6. Find an event");
			    System.out.println("7. List all speakers");
			    System.out.println("8. List all events");
			    
			    System.out.println("0. Exit");
			    
			    key=sc.nextInt();
			
			    
			}
			   
				
				
    }
    	
}
