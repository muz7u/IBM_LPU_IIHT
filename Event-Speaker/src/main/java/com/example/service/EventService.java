package com.example.service;

import java.util.Collection;

import comm.example.model.Event;

public interface EventService
{
	public Event createEvent(Event event);
	public void removeEvent(int id);
	public Event findEvent(int id);
	public Collection<Event> findAllEvent();
}
