package com.keylesson.DaoClasses;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.keylesson.EntityClasses.Location;
import com.keylesson.EntityClasses.User;
import com.keylesson.EntityClasses.User_Registration;
import com.keylesson.ModelClasses.retrieve;
import com.keylesson.ModelClasses.submit;


public interface usersDao {
	public submit addUser1(submit users);
	public boolean addUser2(User users);
	public List<User> getAllUsers();
	public retrieve getUserById(retrieve userid);
	public boolean deleteUser(User users);
	public List<Map<String,Object>> getAllRegion();
	public List<User_Registration> getUsers();
	public List<Map<String, Object>> getSource();
	public List<Map<String,Object>> getAllLocation();
	public List<Map<String, Object>> getRegion(String id);
	public List<Map<String, Object>> getRoom(String id);
	public Map<String, Object> getReport(String id);
}
