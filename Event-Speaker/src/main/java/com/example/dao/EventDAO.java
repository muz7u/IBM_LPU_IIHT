package com.example.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import comm.example.model.Event;

@Repository
public interface EventDAO 
{
	public Event createEvent(Event event);
	public void removeEvent(int id);
	public Event findEvent(int id);
	public Collection<Event> findAllEvent();
}
