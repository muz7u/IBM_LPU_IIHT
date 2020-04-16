package com.example.service;

import java.util.Collection;

import comm.example.model.Speaker;

public interface SpeakerService
{
	public Speaker createSpeaker(Speaker speaker);
	public void removeSpeaker(int id);
	public Speaker findSpeaker(int id);
	public Collection<Speaker> findAllSpeaker();
}
