package com.keylesson.EntityClasses;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="board")
public class Board {
	private int room_ID;
	private String MAC;
	private String description;
	private String remark;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	private Room room;
	
	public int getRoom_ID() {
		return room_ID;
	}
	public void setRoom_ID(int room_ID) {
		this.room_ID = room_ID;
	}
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String MAC) {
		this.MAC = MAC;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
}
