package comm.example.model;

public class Image {
	
	private String imageID;
	private String imageUrl;
	private boolean isAvailable;
	
	
	public String getImageID() {
		return imageID;
	}
	public void setImageID(String imageID) {
		this.imageID = imageID;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Image(String imageID, String imageUrl, boolean isAvailable) {
		super();
		this.imageID = imageID;
		this.imageUrl = imageUrl;
		this.isAvailable = isAvailable;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Image [imageID=" + imageID + ", imageUrl=" + imageUrl + ", isAvailable=" + isAvailable + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageID == null) ? 0 : imageID.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + (isAvailable ? 1231 : 1237);
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (imageID == null) {
			if (other.imageID != null)
				return false;
		} else if (!imageID.equals(other.imageID))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		return true;
	}
	

}
