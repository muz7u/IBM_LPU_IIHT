package com.example.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import comm.example.model.Speaker;

@Repository
public interface SpeakerDAO 
{

	public Speaker createSpeaker(Speaker speaker);
	public void removeSpeaker(int id);
	public Speaker findSpeaker(int id);
	public Collection<Speaker> findAllSpeaker();
}
