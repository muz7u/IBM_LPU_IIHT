package com.example.service;

import java.util.List;

import com.example.dao.DaoInterface;

import comm.example.model.Image;

public class ServiceImplementation implements ServiceInterface 
{

	private DaoInterface refDaoInterface;
	
	public Image findImageByImageIdService(String imageId) {
		// TODO Auto-generated method stub
		
		return refDaoInterface.findImageByImageId(imageId);
		
	}

	public void insertImageService(String imageId, String imageUrl, boolean isAvailable) {
		// TODO Auto-generated method stub
		refDaoInterface.insertImage(imageId, imageUrl, isAvailable);
	}

	public void deleteImageByImageIdService(String imageId) {
		// TODO Auto-generated method stub
		refDaoInterface.deleteImageByImageId(imageId);
	}

	public void updateImageByImageIdService(String imageId, String imageUrl, boolean isAvailable) {
		// TODO Auto-generated method stub
		refDaoInterface.updateImageByImageId(imageId, imageUrl, isAvailable);
	}

	public List<Image> displayAllImagesService() {
		// TODO Auto-generated method stub
		return refDaoInterface.displayAllImages();
	}

}
