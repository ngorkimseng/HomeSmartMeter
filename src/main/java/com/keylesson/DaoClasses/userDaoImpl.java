package com.keylesson.DaoClasses;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.keylesson.EntityClasses.Data;
import com.keylesson.EntityClasses.Location;
import com.keylesson.EntityClasses.Region;
import com.keylesson.EntityClasses.Room;
import com.keylesson.EntityClasses.User;
import com.keylesson.EntityClasses.User_Registration;
import com.keylesson.HibernateUtil.HibernateUtil;
import com.keylesson.ModelClasses.retrieve;
import com.keylesson.ModelClasses.submit;
import com.keylesson.ServiceClasses.usersService;

@Repository
public class userDaoImpl implements usersDao {

	public submit addUser1(submit model1) {
		Transaction trns = null;
		Integer id = model1.getId();
		String name = model1.getName();
		String salary = model1.getSalary();

		User user = new User();
		user.setUser_id(id);
		user.setUser_name(name);
		user.setUser_salary(salary);

		Session session = HibernateUtil.buildSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			return model1;
		} finally {
			session.flush();
			session.close();
		}
		return model1;
	}

	public boolean addUser2(User user) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			session.flush();
			session.close();
		}
		return true;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			users = session.createQuery("from User").list();
			System.out.println(users);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return users;
		} finally {
			session.flush();
			session.close();
		}
		return users;
	}

	public retrieve getUserById(retrieve model1) {

		User user = null;
		Transaction trns = null;

		Integer id = model1.getId();

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from User where user_id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);

			user = (User) query.uniqueResult();

			Integer id1 = user.getUser_id();
			String name = user.getUser_name();
			String salary = user.getUser_salary();

			model1.setId(id1);
			model1.setName(name);
			model1.setSalary(salary);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return model1;
		} finally {
			session.flush();
			session.close();
		}
		return model1;
	}

	public boolean deleteUser(User users) {

		Integer id1 = 0;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			id1 = users.getUser_id();
			trns = session.beginTransaction();
			String queryString = "delete from User where user_id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id1);
			query.executeUpdate();
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return true;

	}

	/*
	 * List<User> users = new ArrayList<User>(); Transaction trns = null;
	 * Session session = HibernateUtil.getSessionFactory().openSession(); try {
	 * trns = session.beginTransaction(); users =
	 * session.createQuery("from Users").list(); System.out.println(users); }
	 * catch (RuntimeException e) { e.printStackTrace(); return users; } finally
	 * { session.flush(); session.close(); } return users;
	 */

	// ===========================================================

	public List<User_Registration> getUsers() {
		List<User_Registration> locations = new ArrayList<User_Registration>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			locations = session.createQuery("FROM User_Registration").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return locations;
		} finally {
			session.flush();
			session.close();
		}
		return locations;
	}

	/*
	 * public List<Map<String,Object>> getAllLocations1() { List<Location>
	 * locations = new ArrayList<Location>(); List<Map<String,Object>> list =
	 * new ArrayList<Map<String,Object>>(); Transaction trns1 = null; Session
	 * session = HibernateUtil.getSessionFactory().openSession(); try{ trns1 =
	 * session.beginTransaction(); Query query = session.createQuery(
	 * "Select SUM(power), SUM(water) From Data D group by (D.room_ID.region_ID)"
	 * ); List<Object> obj = query.list(); System.out.println(obj.size());
	 * for(int i=0;i<locations.size();i++){ Map<String,Object> map = new
	 * HashMap<String,Object>(); List<String> region = new ArrayList<String>();
	 * map.put("id",locations.get(i).getID() ); map.put("name",
	 * locations.get(i).getName()); for(int j=0;j<region.size();j++){
	 * Map<String,Object> mapone = new HashMap<String,Object>(); List<String>
	 * room = new ArrayList<String>(); for (int k=0;k<room.size();k++){
	 * Map<String, Object> maptwo = new HashMap<String, Object>(); List<String>
	 * data = new ArrayList<String>(); maptwo.put("power", locations);
	 * 
	 * } } for(Region re : locations.get(i).getRegion()){
	 * region.add(re.getName()); } map.put("region_list", region);
	 * 
	 * list.add(map); } } catch (RuntimeException e){ e.printStackTrace();
	 * 
	 * }finally { session.flush(); session.close(); } return list; }
	 */
	/*
	 * public List<Map<String,Object>> getAllLocations1() { List<Location>
	 * locations = new ArrayList<Location>(); List<Map<String,Object>> list =
	 * new ArrayList<Map<String,Object>>(); Transaction trns1 = null; Session
	 * session = HibernateUtil.getSessionFactory().openSession(); try{ trns1 =
	 * session.beginTransaction(); locations =
	 * session.createQuery("FROM Location").list(); for(int
	 * i=0;i<locations.size();i++){ Map<String,Object> map = new
	 * HashMap<String,Object>(); List<String> region = new ArrayList<String>();
	 * map.put("id",locations.get(i).getID() ); map.put("name",
	 * locations.get(i).getName()); for(Region re :
	 * locations.get(i).getRegion()){ region.add(re.getName()); }
	 * map.put("region_list", region);
	 * 
	 * list.add(map); }
	 * 
	 * } catch (RuntimeException e){ e.printStackTrace();
	 * 
	 * }finally { session.flush(); session.close(); } return list; }
	 */
	/*
	 * public static void main(String arg[]){ List<Location> locations = new
	 * ArrayList<Location>(); List<Map<String,Object>> list = new
	 * ArrayList<Map<String,Object>>(); Transaction trns1 = null; Session
	 * session = HibernateUtil.getSessionFactory().openSession(); try{ trns1 =
	 * session.beginTransaction(); Query query =
	 * session.createQuery("from Location"); List<Location> obj = query.list();
	 * int power=0; int water=0; System.out.println(obj.size());
	 * List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
	 * for(int i=0;i<obj.size();i++){ Map<String,Object> map = new
	 * HashMap<String,Object>(); Map<String,Object> all = new
	 * HashMap<String,Object>(); for(Region re : obj.get(i).getRegion()){
	 * System.out.println("-----"); for(Room room : re.getRoom()){ for(Data data
	 * : room.getData()){ if(data!=null){ power = power + data.getPower(); water
	 * = water + data.getWater(); }
	 * 
	 * } } } map.put("water", water); map.put("power", power); water =0;
	 * power=0; all.put(obj.get(i).getName(), map); list_map.add(all);
	 * 
	 * } System.out.println("Heyyy"); System.out.println(list_map); for(int
	 * i=0;i<locations.size();i++){ Map<String,Object> map = new
	 * HashMap<String,Object>(); List<String> region = new ArrayList<String>();
	 * map.put("id",locations.get(i).getID() ); map.put("name",
	 * locations.get(i).getName()); for(int j=0;j<region.size();j++){
	 * Map<String,Object> mapone = new HashMap<String,Object>(); List<String>
	 * room = new ArrayList<String>(); for (int k=0;k<room.size();k++){
	 * Map<String, Object> maptwo = new HashMap<String, Object>(); List<String>
	 * data = new ArrayList<String>(); maptwo.put("power", locations);
	 * 
	 * } } for(Region re : locations.get(i).getRegion()){
	 * region.add(re.getName()); } map.put("region_list", region);
	 * 
	 * list.add(map); }
	 * 
	 * } catch (RuntimeException e){ e.printStackTrace();
	 * 
	 * }finally { session.flush(); session.close(); } }
	 */
	/*
	 * public List<Map<String,Object>> User() { List<User_Master> user = new
	 * ArrayList<User_Master> (); List<Map<String,Object>> userList = new
	 * ArrayList<Map<String,Object>>(); Transaction trns = null; Session session
	 * = HibernateUtil.getSessionFactory().openSession(); try { String
	 * batch_string=""; trns = session.beginTransaction(); String hql =
	 * "FROM User_Master U where U.role_id.role_auth !='ROLE_CUSTOMER' and U.status='true'"
	 * ; Query query = session.createQuery(hql); user = query.list(); for(int
	 * i=0;i<user.size();i++){ Map<String,Object> map = new
	 * HashMap<String,Object>(); map.put("full_name",
	 * user.get(i).getFullname()); map.put("user_name",
	 * user.get(i).getUsername()); if(user.get(i).getBatch_id()==null){
	 * batch_string = "no"; } else{ batch_string =
	 * String.valueOf(user.get(i).getBatch_id().getBatch_number()); }
	 * map.put("batch", batch_string); map.put("role",
	 * user.get(i).getRole_id().getRole_name()); map.put("phone",
	 * user.get(i).getPhone_number()); map.put("email", user.get(i).getEmail());
	 * map.put("gender", user.get(i).getGender()); map.put("password",
	 * user.get(i).getPassword()); map.put("user_id", user.get(i).getUser_id());
	 * userList.add(map);
	 * 
	 * } System.out.println("dd"); } catch (RuntimeException e) {
	 * e.printStackTrace();
	 * 
	 * } finally { session.flush(); session.close(); }
	 * 
	 * return userList; }
	 */

	public List<Map<String, Object>> getAllRegion() {
		List<Map<String, Object>> regions = new ArrayList<Map<String, Object>>();
		// List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Transaction trns1 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns1 = session.beginTransaction();
			Query qury = session
					.createQuery(" select P.room.region.name, sum(P.power),sum(P.water) FROM Data P group by (P.room.region.ID)");
			List<Object[]> q = qury.list();

			for (Object b[] : q) {
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("region_name", b[0]);
				map.put("power", b[1]);
				map.put("water", b[2]);
				regions.add(map);
			}
			System.out.println(regions);
		} catch (RuntimeException e) {
			e.printStackTrace();

		} finally {
			session.flush();
			session.close();
		}
		return regions;
	}

	public List<Map<String, Object>> getSource() {
		List<Map<String, Object>> locations = new ArrayList<Map<String, Object>>();
		Transaction trns1 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns1 = session.beginTransaction();
			Query qury = session
					.createQuery("SELECT D.room.region.id, D.room.region.name , D.room.ID, D.power, D.water from Data D");
			List<Object[]> q = qury.list();
			
			for (Object b[] : q) {
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("region_name", b[0]);
				}

			for (Object b[] : q) {
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("region_id", b[0]);
				map.put("region_name", b[1]);
				map.put("room", b[2]);
				map.put("power", b[3]);
				map.put("water", b[4]);
				locations.add(map);
			}
			System.out.println(locations);
		}

		catch (RuntimeException e) {
			e.printStackTrace();

		} finally {
			session.flush();
			session.close();
		}
		return locations;
	}

	public List<Map<String, Object>> getAllLocation() {
		List<Location> location = new ArrayList<Location>();
		List<Map<String, Object>> locations = new ArrayList<Map<String, Object>>();
		Transaction trns1 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns1 = session.beginTransaction();
			String queryString = ("from Location");
			Query query = session.createQuery(queryString);
			location = query.list();
			for (int i = 0; i < location.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", location.get(i).getName());
				map.put("id", location.get(i).getID());
				locations.add(map);
			}
			System.out.println(locations);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return locations;
	}

	public List<Map<String, Object>> getRegion(String id) {
		List<Region> region = new ArrayList<Region>();
		List<Map<String, Object>> regions = new ArrayList<Map<String, Object>>();
		Transaction trns1 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns1 = session.beginTransaction();
			String queryString = "from Region where location.ID = " + id;
			Query query = session.createQuery(queryString);

			region = query.list();
			for (int i = 0; i < region.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", region.get(i).getID());
				map.put("name", region.get(i).getName());
				regions.add(map);
			}
			System.out.println(regions);
		} catch (RuntimeException e) {
			e.printStackTrace();

		} finally {
			session.flush();
			session.close();
		}
		return regions;

	}
	
	public List<Map<String, Object>> getRoom(String id) {
		List<Room> room = new ArrayList<Room>();
		List<Map<String, Object>> rooms = new ArrayList<Map<String, Object>>();
		Transaction trns1 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns1 = session.beginTransaction();
			String queryString = "from Room where region.ID = " + id;
			Query query = session.createQuery(queryString);

			room = query.list();
			for (int i = 0; i < room.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", room.get(i).getID());
				map.put("name", room.get(i).getName());
				rooms.add(map);
			}
			System.out.println(rooms);
		} catch (RuntimeException e) {
			e.printStackTrace();

		} finally {
			session.flush();
			session.close();
		}
		return rooms;

	}
	
	public Map<String, Object> getReport(String id) {
		List<Data> data = new ArrayList<Data>();
		List<Room> room = new ArrayList<Room>();
		Transaction trns1 = null;
		Map<String, Object> rooms = new HashMap<String, Object>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns1 = session.beginTransaction();
			String queryString = "from Data where room.ID=" + id;
			String queryString2 = " from Room where ID=" + id;
			Query query = session.createQuery(queryString);
			Query query2 = session.createQuery(queryString2);
			room = query2.list();
			data = query.list();
			rooms.put("name", room.get(0).getName());
			rooms.put("id", id);
			rooms.put("power",data.get(0).getPower());
			rooms.put("water", data.get(0).getWater());
			System.out.println(rooms);
		} catch (RuntimeException e) {
			e.printStackTrace();

		} finally {
			session.flush();
			session.close();
		}
		return rooms;

	}
		
	
		/*DEmo*/
/*	public static void main(String arg[]) {
		List<Location> location = new ArrayList<Location>();
		List<Map<String, Object>> locations = new ArrayList<Map<String, Object>>();
		Transaction trns1 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns1 = session.beginTransaction();
			String queryString = ("from Location");
			Query query = session.createQuery(queryString);
			location = query.list();
			for (int i = 0; i < location.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", location.get(i).getName());
				map.put("id", location.get(i).getID());
				locations.add(map);
			}
			System.out.println(locations);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}*/
	

}
