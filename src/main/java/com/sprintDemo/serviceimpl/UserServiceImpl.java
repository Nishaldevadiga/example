package com.sprintDemo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprintDemo.entity.User;
import com.sprintDemo.exception.DuplicateUserException;
import com.sprintDemo.exception.InvalidLoginCredentialException;
import com.sprintDemo.exception.NoSuchUserException;
import com.sprintDemo.repository.UserRepository;
import com.sprintDemo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	public UserServiceImpl() {
		super();
	}
	
	@Override
	public User registerUser(User user) throws DuplicateUserException {
		String use=user.getUserName();
		User user1=userRepository.findByUserName(use);
		if(user1!=null) {
			throw new DuplicateUserException("user is existing");
		}
		return userRepository.save(user);
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	
	String message;
	@Override
	public String ValidateLogin(String userName, String password) throws InvalidLoginCredentialException {
		User user=userRepository.findByUserName(userName);
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				message="welcome "+user.getUserName();
			}	
			else {
		     throw new InvalidLoginCredentialException("Login details are not correct");
	}
			return message;
	}
	
	@Override
	public User searchUserByUsreName(String userName) throws NoSuchUserException {
		User user=userRepository.findByUserName(userName);
		if(user==null) {
			throw new NoSuchUserException("No such user by userName :"+userName);
		}
		return user;
	}
	
	@Override
	public User searchUserByUsreId(Long userId) throws NoSuchUserException {
		User user=userRepository.getById(userId);
		if(user==null) {
			throw new NoSuchUserException("No such user by id: "+userId);
		}
		return user;
	}
	
	@Override
	public User update(User user) throws NoSuchUserException {
		String username=user.getUserName();
		User use=userRepository.findByUserName(username);
		if(use==null) {
			throw new NoSuchUserException("No such user by userName: "+user);
		}
			userRepository.update(user.getPassword(),user.getUserName());
			return use;
	}
	
	

}
