package com.example.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comm.example.model.Image;

public class DaoImplementation implements DaoInterface {

	public List<Image> list=new ArrayList<Image>();

	
	public Image findImageByImageId(String imageId) 
	{
		Iterator<Image> iter=list.iterator();
		while(iter.hasNext())
		{
			Image objImage = (Image) iter.next();
			
			if(objImage.getImageID().equals(imageId))
			{
				return objImage;
				
			}
		}
		return null;
	}

	public void insertImage(String imageId, String imageUrl, boolean isAvailable)
	{	
		list.add(new Image(imageId, imageUrl,isAvailable));
	}

	public void deleteImageByImageId(String imageId)
	{
		Iterator<Image> iter=list.iterator();
		while(iter.hasNext())
		{
			Image objImage = (Image) iter.next();
			
			if(objImage.getImageID().equals(imageId))
			{
				list.remove(objImage);
				System.out.println("Image deleted with imageId = "+imageId);
				return;
			}
		}
		System.out.println("No image with imageId= "+imageId);
	}

	public void updateImageByImageId(String imageID, String imageUrl, boolean isAvailable) 
	{
		Iterator<Image> iter=list.iterator();
		//int index=0;
		while(iter.hasNext())
		{
			
			Image objImage = (Image) iter.next();
			
			if(objImage.getImageID().equals(imageID))
			{
				objImage.setImageID(imageID);
				objImage.setImageUrl(imageUrl);
				objImage.setAvailable(isAvailable);
				//list.set(index, new Image(imageId,imageUrl,isActive));
				return;
			}
			//index++;
		}
		System.out.println("No image with imageId= "+imageID);
		
	}

	public List<Image> displayAllImages() {
		// TODO Auto-generated method stub
		return list;
	}

}
