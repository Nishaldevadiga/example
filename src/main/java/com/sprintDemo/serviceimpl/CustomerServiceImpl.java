package com.sprintDemo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprintDemo.entity.Customer;
import com.sprintDemo.entity.User;
import com.sprintDemo.exception.DuplicateCustomerException;
import com.sprintDemo.exception.NoSuchCustomerException;
import com.sprintDemo.exception.NoSuchUserException;
import com.sprintDemo.repository.CustomerRepository;
import com.sprintDemo.service.CustomerService;
import com.sprintDemo.service.UserService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	UserService userService;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) throws DuplicateCustomerException {
		String email=customer.getEmail();
		User un= userService.findByUserName(email);
		if(un==null) {
			throw new DuplicateCustomerException("Customer need to signup");
	}
		return customerRepository.save(customer);
	}

	@Override
	public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchUserException {
		Customer customer=customerRepository.getById(customerId);
		if(customer==null) {
			throw new NoSuchUserException("No such Customer by customerId: "+customerId);
		}
			return customerRepository.getById(customerId);
	}

	@Override
	public Customer searchCustomerByCustomerAddhar(Long addharNumber) throws NoSuchUserException {
		Customer customer=customerRepository.findByaddharNumber(addharNumber);
		if(customer==null) {
			throw new NoSuchUserException("No such Customer by addharNumber: "+addharNumber);
		}
		return customerRepository.findByaddharNumber(addharNumber);
	}

	@Override
	public Customer searchCustomerBymobile(String mobileNumber) throws NoSuchUserException {
		Customer customer=customerRepository.findBymobileNumber(mobileNumber);
		if(customer==null) {
			throw new NoSuchUserException("No such Customer by mobileNumber: "+mobileNumber);
		}
		return customerRepository.findBymobileNumber(mobileNumber);
	}

	@Override
	public Customer searchCustomerByemail(String email) throws NoSuchUserException {
		Customer customer=customerRepository.findByemail(email);
		if(customer==null) {
			throw new NoSuchUserException("No such Customer by email: "+email);
		}
		return customerRepository.findByemail(email);
	}

	@Override
	 public Customer updateProfile(Long number,Customer customer) {
        Optional<Customer> optional = customerRepository.findById(number);
        Customer cust = optional.get();
        String s =customer.getFirstName();
        String t = customer.getMiddleName();
        String u = customer.getLastName();
        String v = customer.getEmail();
        String w = customer.getMobileNumber();
        cust.setFirstName(s);
        cust.setMiddleName(u);
        cust.setLastName(t);
        cust.setEmail(v);
        cust.setMobileNumber(w);
        customerRepository.save(cust);
         return cust;
   }
	
	@Override
	  public List<Customer> findByName(String firstName,String middleName,String lastName) throws NoSuchCustomerException {
		        List<Customer> cust = customerRepository.findByName(firstName,middleName,lastName);
		        if(cust.isEmpty()|| cust == null) {
		            throw new NoSuchCustomerException("customer not found for the given name:"+firstName+ middleName+ lastName);
		            }
		        return cust;
		    }
}
