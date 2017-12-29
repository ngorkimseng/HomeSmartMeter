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
public class test{
	public static void main(String args[])
	{
		List<Map<String,Object>> regoinList = getAllRegion();
		System.out.println(regoinList.toString());

	}
	public static List<Map<String, Object>> getAllRegion() {
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
					.createQuery("SELECT D.room.region.name , D.room.ID, D.power, D.water from Data D");
			List<Object[]> q = qury.list();

			for (Object b[] : q) {
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("region_name", b[0]);
				map.put("room", b[1]);
				map.put("power", b[2]);
				map.put("water", b[3]);
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
	}