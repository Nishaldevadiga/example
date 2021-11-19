package com.sprintDemo.service;

import com.sprintDemo.entity.User;
import com.sprintDemo.exception.DuplicateUserException;
import com.sprintDemo.exception.InvalidLoginCredentialException;
import com.sprintDemo.exception.NoSuchUserException;

public interface UserService {

	public User registerUser(User user) throws DuplicateUserException;

	public User findByUserName(String userName);
	
	public String ValidateLogin(String userName, String password) throws InvalidLoginCredentialException;

	public User searchUserByUsreName(String userName) throws NoSuchUserException;

	public User searchUserByUsreId(Long userId) throws NoSuchUserException;

	public User update(User user) throws NoSuchUserException;

}
