package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="image_id")
	private Integer imageId;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="image_description")
	private String imageDescription;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(Integer imageId, String imageUrl, String imageDescription) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
		this.imageDescription = imageDescription;
	}

	public Image(String imageUrl, String imageDescription) {
		super();
		this.imageUrl = imageUrl;
		this.imageDescription = imageDescription;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imageUrl=" + imageUrl + ", imageDescription=" + imageDescription + "]";
	}
	
	
	
}
