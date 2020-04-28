package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ImageDAO;
import com.example.demo.model.Image;

@RestController
public class ImageController 
{
	private ImageDAO imageDAO;
	
	@Autowired
	public ImageController(ImageDAO imageDAO) {
		super();
		this.imageDAO = imageDAO;
	}


	@RequestMapping("/getAll")
	public List<Image> getAllImage()
	{
		return imageDAO.getAllImages();
		
	}


	@RequestMapping("/images")
	public ResponseEntity<Image> addImage(@RequestBody Image image)
	{
		imageDAO.addImage(image);
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
	
}
