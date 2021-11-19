package com.sprintDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sprintDemo.entity.User;
import com.sprintDemo.exception.DuplicateUserException;
import com.sprintDemo.exception.InvalidLoginCredentialException;
import com.sprintDemo.exception.NoSuchUserException;
import com.sprintDemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws DuplicateUserException{
			User user1=userService.registerUser(user);
			return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginCheck(@RequestBody User user) throws InvalidLoginCredentialException {	
		String user1= userService.ValidateLogin(user.getUserName(),user.getPassword());
		return new ResponseEntity<String>(user1,HttpStatus.OK);
	}
	
	@GetMapping("/userbyname/{userName}")
    public ResponseEntity<User> searchUserByUserName(@PathVariable("userName")String userName) throws NoSuchUserException {
        User user= userService.searchUserByUsreName(userName);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
	
	@GetMapping("/userbyid/{userId}")
    public ResponseEntity<User> searchUserByUserId(@PathVariable("userId")Long userId ) throws NoSuchUserException {
        User user= userService.searchUserByUsreId(userId);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
	
	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user) throws NoSuchUserException {
		User user1= userService.update(user);
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
	
	
}