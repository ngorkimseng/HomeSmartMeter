package com.keylesson.EntityClasses;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="region")
public class Region {
	//private int location_ID;
	private int ID;
	private String name;
	private String description;
	private Timestamp created_at;
	private Timestamp updated_at;

	private Location location;
	private Set<Room> room;

	/*public int getLocation_ID() {
		return location_ID;
	}

	public void setLocation_ID(int location_ID) {
		this.location_ID = location_ID;
	}*/

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Room> getRoom() {
		return room;
	}

	public void setRoom(Set<Room> room) {
		this.room = room;
	}

}
