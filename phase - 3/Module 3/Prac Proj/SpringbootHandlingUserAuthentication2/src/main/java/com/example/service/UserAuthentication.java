package com.example.service;

import java.util.ArrayList; 
import java.util.List;

import com.example.demo.User; 

public class UserAuthentication 
{ 
	List<User> lists = new ArrayList<User>(); 
	public boolean Login(User u) 
	{

	boolean res = false; 
	for (User user : lists) 
	{ 
		if (user.getEmail().equals(u.getEmail()) && user.getPassword().equals(u.getPassword()))
		{ 
			res = true; 
			break; 
		} 
	} 
	return res; 
} 

public List<User> listOfUser(User u) 
{ 
	this.lists.add(u); 
	return this.lists; 
	// Return the updated list 
} 

public String registration(User u) 
{ 
	String res = null; 
	for (User user : lists) 
	{ 
		if (user.getEmail().equals(u.getEmail())) 
		{ 
			res = "Email already exists";
			break; 
		} 
		else 
		{ 
			listOfUser(u); 
			res = "Registered"; 
			break; 
		} 
	} 
	return res; 
} 
}
