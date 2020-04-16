package comm.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="speaker")
public class Speaker {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int speakerID;
	
	@Column(name="speaker_name")
	private String speakerName;
	
	@Column(name="speaker_email")
	private String speakerEmail;
	
	@Column(name="is_available")
	private String isAvailable;
	
	@OneToMany(mappedBy = "speaker", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Event> listEvent;

	public Speaker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Speaker(String speakerName, String speakerEmail, String isAvailable) {
		super();
		this.speakerName = speakerName;
		this.speakerEmail = speakerEmail;
		this.isAvailable = isAvailable;
	}

	public Speaker(int speakerID, String speakerName, String speakerEmail, String isAvailable, List<Event> listEvent) {
		super();
		this.speakerID = speakerID;
		this.speakerName = speakerName;
		this.speakerEmail = speakerEmail;
		this.isAvailable = isAvailable;
		this.listEvent = listEvent;
	}

	public int getSpeakerID() {
		return speakerID;
	}

	public void setSpeakerID(int speakerID) {
		this.speakerID = speakerID;
	}

	public String getSpeakerName() {
		return speakerName;
	}

	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}

	public String getSpeakerEmail() {
		return speakerEmail;
	}

	public void setSpeakerEmail(String speakerEmail) {
		this.speakerEmail = speakerEmail;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public List<Event> getListEvent() {
		return listEvent;
	}

	public void setListEvent(List<Event> listEvent) {
		this.listEvent = listEvent;
	}

	@Override
	public String toString() {
		return "Speaker [speakerID=" + speakerID + ", speakerName=" + speakerName + ", speakerEmail=" + speakerEmail
				+ ", isAvailable=" + isAvailable + ", listEvent=" + listEvent + "]";
	}
	
	
	
}
	
	
	
	