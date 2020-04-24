package com.example.demo.model;

import javax.persistence.Column;import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Image {
	@Id
	@Column(name = "image_id")
	private String imageID;
	@Column(name = "image_url")
	private String imageURL;
	@Column(name = "available")
	@JsonProperty
	private boolean isAvailable;
	public Image() {
		super();
	}
	public Image(String imageID, String imageURL, boolean isAvailable) {
		super();
		this.imageID = imageID;
		this.imageURL = imageURL;
		this.isAvailable = isAvailable;
	}
	public String getImageID() {
		return imageID;
	}
	public void setImageID(String imageID) {
		this.imageID = imageID;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Image [imageID=" + imageID + ", imageURL=" + imageURL + ", isAvailable=" + isAvailable + "]";
	}
	

	
}
