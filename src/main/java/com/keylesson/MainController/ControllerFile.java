package com.keylesson.MainController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;








import com.keylesson.DaoClasses.userDaoImpl;
import com.keylesson.DaoClasses.usersDao;
import com.keylesson.EntityClasses.Location;
import com.keylesson.EntityClasses.User;
import com.keylesson.ModelClasses.retrieve;
import com.keylesson.ModelClasses.submit;
import com.keylesson.ServiceClasses.usersService;
import com.keylesson.ServiceClasses.usersServiceImpl;


@Controller
public class ControllerFile {
		
	@Autowired
	usersService usersService1;	
	
	
//=================For CSS==============================
	
/*	@RequestMapping(value="/welcome", method=RequestMethod.GET)    //if we give value="/" like this we can directly run our project                     
	public ModelAndView helloworld1()                      
	{
		ModelAndView model = new ModelAndView("page1/welcome");  
		model.addObject("msg", "Hi Kamal");   
		return model;
	}	
	
//======================================================	
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)    //if we give value="/" like this we can directly run our project                     
	public ModelAndView helloworld2()                      
	{
		ModelAndView model = new ModelAndView("login/Login");  
		//model.addObject("msg", "Hi Kamal");   
		return model;
	}	*/
	
	
	
	/*
	@RequestMapping(value="/a", method=RequestMethod.GET)    //if we give value="/" like this we can directly run our project                     
	public ModelAndView User()                      
	{
		ModelAndView model = new ModelAndView("dashboard");
		return model;
	}	*/
	
/*	@RequestMapping(value="dash", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getDashboard(){
				
		 Map<String,Object> map = new HashMap<String,Object>();
		 System.out.println("Hey");
	
			List<Location> list = usersService1.GetUsers();
			System.out.println("Hello");	
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
				
			}else{
				map.put("status","404");
				map.put("message","Data not found");			
			}
		
		  return map;
	}*/
	
	
	
	
	
	

	
//1. First Method using model classes	
	
//=================Submit Users==============================
	
/*	@RequestMapping(value="/add1", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view =new ModelAndView("page1/submit");
		return view;
	}
	
	
	@RequestMapping(value="/submit.html", method=RequestMethod.POST)                                            
	public ModelAndView Submit(submit model1,BindingResult result)        
	{                                                                                                
	   if(result.hasErrors())
	   {
		ModelAndView model2 = new ModelAndView("submit");  //if it is error send it back to submit.jsp 
		model2.addObject("headerMsg", "Enter the correct format");  
		return model2;	
	   }
	   
	  // usersServiceImpl dao = new usersServiceImpl();
	    		
		model1=usersService1.addUser1(model1);
				
		ModelAndView model2 = new ModelAndView("submitOutput");
		model2.addObject("headerMsg", "Value inserted successfully");  
		
		model2.addObject("msg", model1);                                                  //This name will store the value in msg

		return model2;
	}
	
	
//=================Retrieve Users=====================
	
	
	@RequestMapping(value="/retrieve", method = RequestMethod.GET)
	public ModelAndView getResult(){
		ModelAndView view =new ModelAndView("page2/retrieve");
		return view;
	}
	
	
	@RequestMapping(value="/result.html", method=RequestMethod.POST)                                            
	public ModelAndView Retrieve(retrieve model1,BindingResult result)        
	{                                                                                                
	   if(result.hasErrors())
	   {
		ModelAndView model2 = new ModelAndView("page2/retrieve");  //if it is error send it back to retrieve.jsp 
		model2.addObject("headerMsg", "Enter the correct format");  
		return model2;	
	   }
	  
	  // DaoClasses.userDaoImpl dao = new DaoClasses.userDaoImpl();	   	
		
	    model1=usersService1.getUserById(model1);
		
		ModelAndView model2 = new ModelAndView("page2/retrieveOutput");
		model2.addObject("headerMsg", "Your Output is");  
		
		model2.addObject("msg",  model1);                                                 

		return model2;
	}	
	
//=================================================================
	
	
	
	
	
	
	
	
	
	
//2.Second Method using Restful API
// NO NEED POJO or Model Class
	
//==================Restful API====================================
	
	
	@RequestMapping(value="/allusers", method = RequestMethod.GET)
	public ModelAndView getPage2(){
		ModelAndView view =new ModelAndView("page2/allusersOutput");
		return view;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(){
				
		 Map<String,Object> map = new HashMap<String,Object>();
	
			List<User> list = usersService1.getAllUsers();
			 		
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
	
	
 //===========================================================

	@RequestMapping(value = "/first", method = RequestMethod.GET)
    public ModelAndView goToPage() {
		return new ModelAndView("dashboard");
    }*/
	
	
	
	
	
	
	//===========================================================	
	@RequestMapping(value="/add2", method = RequestMethod.GET)
	public ModelAndView getPage4(){
		ModelAndView view =new ModelAndView("save");
		return view;
	}

	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(User users){
		
		Map<String,Object> map = new HashMap<String,Object>();		
		 //DaoClasses.userDaoImpl dao = new DaoClasses.userDaoImpl();
		if(usersService1.addUser2(users)){
			map.put("status","200");
			map.put("message","Your record has been saved successfully");
		}
		
		return map;
	}
	}
		
	
//=========================================================

/*	@RequestMapping(value="/remove", method = RequestMethod.GET)
	public ModelAndView getPage5(){
		ModelAndView view =new ModelAndView("page2/delete");
		return view;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(User users){
		Map<String,Object> map = new HashMap<String,Object>();		
		 //DaoClasses.userDaoImpl dao = new DaoClasses.userDaoImpl();
		if(usersService1.deleteUser(users)){
			map.put("status","200");
			map.put("message","Your record has been deleted successfully");
		}
		
		return map;
	}
		
}
*/
//=============================================================





	

	
	






	