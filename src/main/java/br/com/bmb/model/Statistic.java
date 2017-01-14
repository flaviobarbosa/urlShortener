package br.com.bmb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statistic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private long timeTaken;
	
	private Date created;
	
	private Date lastAccess;
	
	private int numberOfRequests;
	
	public Statistic() {
		super();
	}

	public Statistic(long timeTaken) {
		super();
		this.timeTaken = timeTaken;
		this.created = new Date();
		this.lastAccess = null;
		this.numberOfRequests = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public int getNumberOfRequests() {
		return numberOfRequests;
	}

	public void setNumberOfRequests(int numberOfRequests) {
		this.numberOfRequests = numberOfRequests;
	}

	@Override
	public String toString() {
		return "Statistic [id=" + id + ", timeTaken=" + timeTaken + ", created=" + created + ", lastAccess="
				+ lastAccess + ", numberOfRequests=" + numberOfRequests + "]";
	}
}
