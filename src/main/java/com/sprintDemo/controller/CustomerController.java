package com.sprintDemo.controller;

import java.util.List;
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
import com.sprintDemo.entity.Customer;
import com.sprintDemo.exception.DuplicateCustomerException;
import com.sprintDemo.exception.NoSuchCustomerException;
import com.sprintDemo.exception.NoSuchUserException;
import com.sprintDemo.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws DuplicateCustomerException {
		Customer customer1=customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer1,HttpStatus.OK);
}
	
	@GetMapping("/customerbyid/{customerId}")
    public ResponseEntity<Customer> searchCustomerByCustomersId(@PathVariable("customerId")Long customerId ) throws NoSuchUserException {
        Customer customer= customerService.searchCustomerByCustomerId(customerId);
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
	
	@GetMapping("/customerbyadhar/{addharNumber}")
    public ResponseEntity<Customer> searchCustomerBycustomerAdhar(@PathVariable("addharNumber")Long addharNumber ) throws NoSuchUserException{
        Customer customer= customerService.searchCustomerByCustomerAddhar(addharNumber);
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
	
	@GetMapping("/customerbymobile/{mobileNumber}")
    public ResponseEntity<Customer> searchCustomerBymobile(@PathVariable("mobileNumber")String mobileNumber) throws NoSuchUserException {
         Customer customer= customerService.searchCustomerBymobile(mobileNumber);
         return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
	
	@GetMapping("/customerbyemail/{email}")
    public ResponseEntity<Customer> searchCustomerByemail(@PathVariable("email")String email) throws NoSuchUserException {
       Customer customer= customerService.searchCustomerByemail(email);
       return new ResponseEntity<Customer>(customer,HttpStatus.OK);
   }
	
	 @GetMapping("/customerbyname/{firstName}/{middleName}/{lastName}")
	    public ResponseEntity<List<Customer>> findByName(@PathVariable("firstName")String firstName,@PathVariable("middleName")String middleName,@PathVariable("lastName")String lastName) throws NoSuchCustomerException {
	        List<Customer> c = customerService.findByName(firstName,middleName,lastName);
	        return new  ResponseEntity<List<Customer>>(c,HttpStatus.OK);
	    }
	
	@PutMapping("/edit/{number}")
    public  ResponseEntity<Customer>  getProfile(@PathVariable("number")Long number,@RequestBody Customer customer) {
       Customer c= customerService.updateProfile(number,customer);
       return new ResponseEntity<Customer>(c,HttpStatus.OK);
   }
}
