package comm.example.model;

import java.sql.Date;
import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "event")
public class Event 
{		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "event_id")
		private int eventId;

		@Column(name = "event_name")
		private String eventName;

		@Temporal(TemporalType.DATE)
		@Column(name = "event_date")
		private Date eventDate;
		
		@Temporal(TemporalType.TIME)
		@Column(name = "event_time")
		private int eventTime;
		
		
		@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
		@JoinColumn(name="speaker_id")
		private Speaker speakerId;


		public Event(int eventId, String eventName, Date eventDate, int eventTime, Speaker speakerId) {
			super();
			this.eventId = eventId;
			this.eventName = eventName;
			this.eventDate = eventDate;
			this.eventTime = eventTime;
			this.speakerId = speakerId;
		}


		public Event(String eventName, Date eventDate, int eventTime) {
			super();
			this.eventName = eventName;
			this.eventDate = eventDate;
			this.eventTime = eventTime;
		}


		public Event() {
			super();
			// TODO Auto-generated constructor stub
		}


		public int getEventId() {
			return eventId;
		}


		public void setEventId(int eventId) {
			this.eventId = eventId;
		}


		public String getEventName() {
			return eventName;
		}


		public void setEventName(String eventName) {
			this.eventName = eventName;
		}


		public Date getEventDate() {
			return eventDate;
		}


		public void setEventDate(Date eventDate) {
			this.eventDate = eventDate;
		}


		public int getEventTime() {
			return eventTime;
		}


		public void setEventTime(int eventTime) {
			this.eventTime = eventTime;
		}


		public Speaker getSpeakerId() {
			return speakerId;
		}


		public void setSpeakerId(Speaker speakerId) {
			this.speakerId = speakerId;
		}


		@Override
		public String toString() {
			return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate
					+ ", eventTime=" + eventTime + ", speakerId=" + speakerId + "]";
		}



}
