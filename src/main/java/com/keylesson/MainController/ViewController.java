package com.keylesson.MainController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keylesson.ServiceClasses.usersService;
import com.keylesson.EntityClasses.Location;
import com.keylesson.EntityClasses.User;
import com.keylesson.EntityClasses.User_Registration;

@Controller

public class ViewController {
	@Autowired
	usersService usersService1;	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView init() {
		return new ModelAndView("main");
    }
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView goToPageDashboard1() {
		return new ModelAndView("dashboard");
    }
	
	@RequestMapping(value = "/dash", method = RequestMethod.POST)
    public @ResponseBody Map<Object, Object> getAll() {
		Map<Object, Object> map = new HashMap<Object, Object>();
	
			List<Map<String,Object>> list = usersService1.getAllRegion();
			
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
				
			}else{
				map.put("status","404");
				map.put("message","Data not found");			
			}
		
		  return map;
    }
	///////////////////////////////////////////
	
	@RequestMapping(value = "/source", method = RequestMethod.GET)
    public ModelAndView goToPageSource() {
		return new ModelAndView("source");
    }
	
	@RequestMapping(value = "/sourceload", method = RequestMethod.POST)
    public @ResponseBody Map<Object, Object> getSourceBody() {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		
			List<Map<String,Object>> list = usersService1.getSource();
			List<Map<String,Object>> regionList = usersService1.getAllRegion();
			if (list != null){
				map1.put("status","200");
				map1.put("message","Data found");
				map1.put("data", list);
				map1.put("data2", regionList);
				
			}else{
				map1.put("status","404");
				map1.put("message","Data not found");			
			}
		
		  return map1;
    }
	
	@RequestMapping(value = "/event", method = RequestMethod.GET)
    public ModelAndView goToPageEvent() {
		return new ModelAndView("event");
    }
	
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView goToPageExport() {
		return new ModelAndView("export");
    }
	@RequestMapping(value = "/exportloc", method = RequestMethod.POST)
    public @ResponseBody Map<Object, Object> getLoc() {
			Map<Object, Object> map = new HashMap<Object, Object>();
	
			List<Map<String,Object>> list = usersService1.getAllLocation();
			
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
				
			}else{
				map.put("status","404");
				map.put("message","Data not found");			
			}
		
		  return map;
    }
	@RequestMapping(value = "/exportreg", method = RequestMethod.GET)
    public @ResponseBody Map<Object, Object> getReg(String id) {
		System.out.println(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
	
			List<Map<String,Object>> list = usersService1.getRegion(id);
			System.out.println(list);
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
				
			}else{
				map.put("status","404");
				map.put("message","Data not found");			
			}
		
		  return map;
    }
	@RequestMapping(value = "/exportroom", method = RequestMethod.GET)
    public @ResponseBody Map<Object, Object> getRoom(String id) {
		System.out.println(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
	
			List<Map<String,Object>> list = usersService1.getRoom(id);
			System.out.println(list);
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
				
			}else{
				map.put("status","404");
				map.put("message","Data not found");			
			}
		
		  return map;
    }
	
	@RequestMapping(value = "/exportoutput", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getReport(String id) {
		System.out.println(id);
		Map<String, Object> map = new HashMap<String, Object>();
	
		Map<String, Object> ret = usersService1.getReport(id);
			System.out.println(ret);
			if (ret.size()>0){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", ret);
				
			}else{
				map.put("status","404");
				map.put("message","Data not found");			
			}
		
		  return map;
    }
	
	/*@RequestMapping(value = "/exportoutput", method = RequestMethod.POST)
    public ModelAndView goToExport(@RequestParam(value = "rroom", required = false) String id) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = usersService1.getReport(id);
		ModelAndView view = new ModelAndView("exportoutput");
		
		view.addObject("data",map);
		return new ModelAndView("exportoutput","data",map);
    }*/
}
