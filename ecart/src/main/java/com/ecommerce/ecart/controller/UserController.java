package com.ecommerce.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecart.entity.User;
import com.ecommerce.ecart.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService theuserService) {
		userService=theuserService;
	}
	
	// expose "/Users" and return list of Users
		@GetMapping("/Users")
		public List<User> findAll() {
			return userService.findall();
		}

		// add mapping for GET /Users/{UserId}
		
		@GetMapping("/Users/{UserId}")
		public User getUser(@PathVariable int UserId) {
			
			User theUser = userService.findById(UserId);
			
			if (theUser == null) {
				throw new RuntimeException("User id not found - " + UserId);
			}
			
			return theUser;
		}
		
		// add mapping for POST /Users - add new User
		
		@PostMapping("/Users")
		public User addUser(@RequestBody User theUser) {
			
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			
			//theUser.setUserId(0);
			
			userService.save(theUser);
			
			return theUser;
		}
		
		// add mapping for PUT /Users - update existing User
		
		@PutMapping("/Users")
		public User updateUser(@RequestBody User theUser) {
			
			userService.save(theUser);
			
			return theUser;
		}
		
		// add mapping for DELETE /Users/{UserId} - delete User
		
		@DeleteMapping("/Users/{UserId}")
		public String deleteUser(@PathVariable int UserId) {
			
			User tempUser = null;
			try {
				tempUser = userService.findById(UserId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// throw exception if null
			
			if (tempUser == null) {
				throw new RuntimeException("User id not found - " + UserId);
			}
			
			userService.deleteById(UserId);
			
			return "Deleted User id - " + UserId;
		}
	
}
