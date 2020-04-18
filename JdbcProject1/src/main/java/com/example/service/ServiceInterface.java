package com.example.service;

import java.util.List;

import comm.example.model.Image;

public interface ServiceInterface 
{

	public Image findImageByImageIdService(String imageId);
	public void insertImageService(String imageId, String imageUrl, boolean isAvailable);
	public void deleteImageByImageIdService(String imageId);
	public void updateImageByImageIdService(String imageId,String imageUrl, boolean isAvailable);
	public List<Image> displayAllImagesService();
}
