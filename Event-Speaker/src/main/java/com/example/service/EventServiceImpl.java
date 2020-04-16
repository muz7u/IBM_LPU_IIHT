package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EventDAO;

import comm.example.model.Event;

@Service
public class EventServiceImpl implements EventService
{
	@Autowired
	private EventDAO refEventDAO;

	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		return  refEventDAO.createEvent(event);
	}

	public void removeEvent(int id) {
		// TODO Auto-generated method stub
		 refEventDAO.removeEvent(id);
		
	}

	public Event findEvent(int id) {
		// TODO Auto-generated method stub
		return  refEventDAO.findEvent(id);
	}

	public Collection<Event> findAllEvent() {
		// TODO Auto-generated method stub
		return  refEventDAO.findAllEvent();
	}

}
