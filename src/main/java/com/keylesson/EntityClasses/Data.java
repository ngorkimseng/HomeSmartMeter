package com.keylesson.EntityClasses;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="data")
public class Data {
	private int ID;
	private int room_ID;
	private int power;
	private int water;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Room room;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
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
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getRoom_ID() {
		return room_ID;
	}
	public void setRoom_ID(int room_ID) {
		this.room_ID = room_ID;
	}

}
