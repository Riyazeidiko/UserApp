package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showPage(Model model) {
		System.out.println("register");
		//set form backing object-[Form<=>Object]
		model.addAttribute("user", new User());
		return "UserRegister";
	}
	
	//2. save/update data
		@RequestMapping(value="/save",method=POST)
		public String saveUser(@ModelAttribute User user,Model model) {
			//save operation
			Integer userId=userService.saveUser(user);
			//clean form
			model.addAttribute("user", new User());
			//return message to UI
			model.addAttribute("message", "User '"+userId+"' saved");
			return "UserRegister";
		}
	
	
		//3. display all values
		@RequestMapping("/all")
		public String showAllUsers(Model model) {
			List<User> users=userService.getAllUsers();
			model.addAttribute("list", users);
			return "UserData";
		}
	
		//4. Delete User based on PathVariable-id
		@RequestMapping("/delete/{id}")
		public String deleteUser(@PathVariable Integer id,Model model) {
			//delete record
			userService.deleteUser(id);
			//get new data and goto UI
			List<User> users=userService.getAllUsers();
			model.addAttribute("message", "User '"+id+"' Deleted");
			model.addAttribute("list", users);
			return "UserData";
		}
	
	
		//5. show Edit Page
		@RequestMapping("/edit/{id}")
		public String showEditPage(@PathVariable Integer id,Model model) {
			//load user from DB
			User p=userService.getuserById(id);
			//send object to UI => Form data
			model.addAttribute("user", p);
			return "UserRegister";
		} 
}
