package com.keylesson.ServiceClasses;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.keylesson.EntityClasses.Location;
import com.keylesson.EntityClasses.User;
import com.keylesson.EntityClasses.User_Registration;
import com.keylesson.DaoClasses.usersDao;
import com.keylesson.ModelClasses.retrieve;
import com.keylesson.ModelClasses.submit;


@Service
public class usersServiceImpl implements usersService{

	@Autowired
	usersDao usersDao1;
	
	public submit addUser1(submit users){
		return usersDao1.addUser1(users);	
	}
	
	public boolean addUser2(User users) {
		return usersDao1.addUser2(users);
	}

	public List<User> getAllUsers() {
		return usersDao1.getAllUsers();
	}
	
	public retrieve getUserById(retrieve userid){
		return usersDao1.getUserById(userid);
	}

	public boolean deleteUser(User users){
		return usersDao1.deleteUser(users);
	}
	public List<Map<String,Object>> getAllRegion() {
		return usersDao1.getAllRegion();
	}
	public List<User_Registration> getUsers(){
		return usersDao1.getUsers();
	}
	public List<Map<String,Object>> getSource() {
		return usersDao1.getSource();
	}
	public  List<Map<String,Object>> getAllLocation(){
		return usersDao1.getAllLocation();
	}
	public List<Map<String, Object>> getRegion(String id){
		return usersDao1.getRegion(id);
	}
	public List<Map<String, Object>> getRoom(String id){
		return usersDao1.getRoom(id);
	}
	public Map<String, Object> getReport(String id){
		return usersDao1.getReport(id);
	}
	
	
}
