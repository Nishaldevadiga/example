package com.sprintDemo.service;

import java.util.List;

import com.sprintDemo.entity.Customer;
import com.sprintDemo.exception.DuplicateCustomerException;
import com.sprintDemo.exception.NoSuchCustomerException;
import com.sprintDemo.exception.NoSuchUserException;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws DuplicateCustomerException;

	public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchUserException;

	public Customer searchCustomerByCustomerAddhar(Long addharNumber) throws NoSuchUserException;

	public Customer searchCustomerBymobile(String mobileNumber) throws NoSuchUserException;

	public Customer searchCustomerByemail(String email) throws NoSuchUserException;

	public Customer updateProfile(Long number, Customer customer);

	public List<Customer> findByName(String firstName, String middleName, String lastName) throws NoSuchCustomerException;


}
