
package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Image;

public interface ImageDAO 
{
	public List<Image> getAllImages();
	public void addImage(Image image);
	
}
