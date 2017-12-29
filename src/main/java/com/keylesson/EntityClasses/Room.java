package com.keylesson.EntityClasses;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	private int user_ID;
	private int region_ID;
	private int ID;
	private String name;
	private String board_MAC;
	private String type;
	private Timestamp created_at;
	private Timestamp updated_at;

	private User_Registration user_registration;
	private Region region;
	private Set<Data> data;
	private Set<Report> report;
	private Set<Board> board;

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

	public String getBoard_MAC() {
		return board_MAC;
	}

	public void setBoard_MAC(String board_MAC) {
		this.board_MAC = board_MAC;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getRegion_ID() {
		return region_ID;
	}

	public void setRegion_ID(int region_ID) {
		this.region_ID = region_ID;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public Set<Report> getReport() {
		return report;
	}

	public void setReport(Set<Report> report) {
		this.report = report;
	}

	public Set<Board> getBoard() {
		return board;
	}

	public void setBoard(Set<Board> board) {
		this.board = board;
	}

	public Set<Data> getData() {
		return data;
	}

	public void setData(Set<Data> data) {
		this.data = data;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public User_Registration getUser_registration() {
		return user_registration;
	}

	public void setUser_registration(User_Registration user_registration) {
		this.user_registration = user_registration;
	}
}
