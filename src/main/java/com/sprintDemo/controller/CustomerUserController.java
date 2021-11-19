package com.sprintDemo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprintDemo.entity.Address;
import com.sprintDemo.entity.Connection;
import com.sprintDemo.entity.Customer;
import com.sprintDemo.entity.User;
import com.sprintDemo.exception.ResourceNotFoundException;
import com.sprintDemo.service.CustomerUserService;

@RestController
@RequestMapping("/customeruser")
public class CustomerUserController {

	@Autowired
	CustomerUserService customerUserService;

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return customerUserService.addUser(user);
	}

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerUserService.addCustomer(customer);
	}

	@PostMapping("/connection")
	public Connection AddConnection(@RequestBody Connection connection) {

		return customerUserService.addConnection(connection);
	}

	@PostMapping("/address")
	public Address AddAddress(@RequestBody Address address) {
		return customerUserService.addAddress(address);
	}

//	********************Active************************
	@GetMapping(value = "/findActiveConnectionsByVillage")
	public Object findActiveConnectionsByVillage(@RequestParam("villageName") String villageName) {
		List<Connection> connection = customerUserService.findActiveConnectionsByVillage(villageName);
		if (connection == null || connection.isEmpty()) {
			throw new ResourceNotFoundException("No connection found for this village: " + villageName);
		}
		return connection;

	}

	@GetMapping(value = "/findActiveConnectionByTaluka")
	public Object findActiveConnectionsByTaluka(@RequestParam("talukaName") String talukaName) {
		List<Connection> connection = customerUserService.findActiveConnectionsByTaluka(talukaName);
		if (connection == null || connection.isEmpty()) {
			throw new ResourceNotFoundException ("No connection found for this Taluka: " + talukaName);
		}
		return connection;
	}

	@GetMapping(value = "/findActiveConnetionByDistrict")
	public Object findActiveConnectionByDistrict(@RequestParam("districtName") String districtName) {
		List<Connection> connection = customerUserService.findActiveConnectionsByDistrict(districtName);
		if (connection == null || connection.isEmpty()) {
			throw new ResourceNotFoundException ("No connection found for this District: " + districtName);
		}
		return connection;
	}

	@GetMapping(value = "/findActiveConnetionByPincode")
	public Object findActiveConnectionByPincode(@RequestParam("pincodeNumber") String pincodeNumber) {

		List<Connection> connection = customerUserService.findActiveConnectionsByPincode(pincodeNumber);
		if (connection == null || connection.isEmpty()) {
			throw new ResourceNotFoundException("No connection found for this Pincode: " + pincodeNumber);
		}
		return connection;
	}

//*************************	Inactive*****************

	@GetMapping(value = "/findInactiveConnectionsByVillage")
	public Object findInactiveConnectionsByVillage(@RequestParam("villageName") String villageName) {
		List<Connection> connection = customerUserService.findInactiveConnectionsByVillage(villageName);
		if (connection == null || connection.isEmpty()) {
			throw new ResourceNotFoundException("No InActiveconnection found for this village: " + villageName);
		}
		return connection;
	}

	@GetMapping(value = "/findInactiveConnectionsByTaluka")
	public Object findInactiveConnectionsByTaluka(@RequestParam("talukaName") String talukaName) {
		List<Connection> connection = customerUserService.findInactiveConnectionsByTaluk(talukaName);
		if (connection == null || connection.isEmpty()) {
			throw new ResourceNotFoundException ("No InActiveconnection found for this Taluka: " + talukaName);
		}
		return connection;
	}

	@GetMapping(value = "/findInactiveConnectionsByDistrict")
	public Object findInactiveConnectionsByDistrict(@RequestParam("districtName") String districtName) {
		List<Connection> connection = customerUserService.findInactiveConnectionsByDistrict(districtName);
		if (connection == null || connection.isEmpty()) {
			throw new ResourceNotFoundException("No  InActiveconnection found for this District: " + districtName);
		}
		return connection;
	}

	@GetMapping(value = "/findInactiveConnectionsByPincode")
	public Object findInactiveConnectionsByPincode(@RequestParam("pincodeNumber") Integer pincodeNumber) {
		List<Connection> connection = customerUserService.findInactiveConnectionsByPincode(pincodeNumber);
		if (connection == null || connection.isEmpty()) {
			throw new ResourceNotFoundException( "No  InActiveconnection found for this PinCode: " + pincodeNumber);
		}
		return connection;
	}

//	**********************Search*************************
	@GetMapping(value = "/searchByCustomerByConsumerNumber")
	public Object searchByCustomerByConsumerNumber(@RequestParam("consumerNumber") Long consumerNumber) {
		List<Connection> connection = customerUserService.searchByCustomerByConsumerNumber(consumerNumber);
		if (connection == null || connection.isEmpty()) {
			throw new ResourceNotFoundException("No connection found for this ConsumerNumber: " + consumerNumber);
		}
		return connection;

	}

//	**********************modify*************************
	@PutMapping("/modifyConnectionAddress")
	public Object modifyConnectionAddress(@RequestBody Connection connection) {
		try {
			return customerUserService.modifyConnectionAddress(connection);
		} catch (Exception exception) {
			throw new ResourceNotFoundException("Error Occured while Changing The address");
		}

	}
}
