package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SpeakerDAO;

import comm.example.model.Speaker;

@Service
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	private SpeakerDAO refSpeakerDAO;
	
	public Speaker createSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeSpeaker(int id) {
		// TODO Auto-generated method stub

	}

	public Speaker findSpeaker(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Speaker> findAllSpeaker() {
		// TODO Auto-generated method stub
		return null;
	}

}
