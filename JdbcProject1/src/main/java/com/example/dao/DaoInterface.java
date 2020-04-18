package com.example.dao;

import java.util.List;

import comm.example.model.Image;

public interface DaoInterface
{

	public Image findImageByImageId(String imageId);
	public void insertImage(String imageId, String imageUrl, boolean isAvailable);
	public void deleteImageByImageId(String imageId);
	public void updateImageByImageId(String imageId,String imageUrl, boolean isAvailable);
	public List<Image> displayAllImages();
	
}
