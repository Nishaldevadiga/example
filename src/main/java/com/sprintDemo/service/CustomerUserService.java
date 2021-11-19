package com.sprintDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintDemo.entity.Address;
import com.sprintDemo.entity.Connection;
import com.sprintDemo.entity.Customer;
import com.sprintDemo.entity.User;
import com.sprintDemo.exception.ResourceNotFoundException;
import com.sprintDemo.repository.AddressRepository;
import com.sprintDemo.repository.ConnectionRepository;
import com.sprintDemo.repository.CustomerRepository;
import com.sprintDemo.repository.UserRepository;

@Service
public class CustomerUserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ConnectionRepository connectionRepository;

	@Autowired
	AddressRepository addressRepository;

	public CustomerUserService() {
		super();
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Connection addConnection(Connection connection) {
		return connectionRepository.save(connection);
	}

	public Address addAddress(Address address) {

		return addressRepository.save(address);
	}

//*****************************Active*************************
	public List<Connection> findActiveConnectionsByVillage(String villageName) {
		// TODO Auto-generated method stub
		List<Connection> connection = connectionRepository.findByAddressVillageAndConnectionStatusTrue(villageName);

		return connection;
	}

	public List<Connection> findActiveConnectionsByTaluka(String talukaName) {
		// TODO Auto-generated method stub
		List<Connection> connection = connectionRepository.findByAddressTalukaAndConnectionStatusTrue(talukaName);
		return connection;
	}

	public List<Connection> findActiveConnectionsByDistrict(String districtName) {
		// TODO Auto-generated method stub

		List<Connection> connection = connectionRepository.findByAddressDistrictAndConnectionStatusTrue(districtName);
		return connection;
	}

	public List<Connection> findActiveConnectionsByPincode(String pincodeNumber) {

		// TODO Auto-generated method stub
		List<Connection> connection = connectionRepository.findByAddressPincodeAndConnectionStatusTrue(pincodeNumber);

		return connection;
	}

//**********************************Inactive********************
	public List<Connection> findInactiveConnectionsByVillage(String villageName) {
		// TODO Auto-generated method stub

		List<Connection> connection = connectionRepository.findByAddressVillageAndConnectionStatusFalse(villageName);
		return connection;
	}

	public List<Connection> findInactiveConnectionsByTaluk(String talukaName) {
		// TODO Auto-generated method stub
		List<Connection> connection = connectionRepository.findByAddressTalukaAndConnectionStatusFalse(talukaName);
		return connection;

	}

	public List<Connection> findInactiveConnectionsByDistrict(String districtName) {
		// TODO Auto-generated method stub
		List<Connection> connection = connectionRepository.findByAddressDistrictAndConnectionStatusFalse(districtName);
		return connection;

	}

	public List<Connection> findInactiveConnectionsByPincode(Integer pincodeNumber) {
		// TODO Auto-generated method stub

		List<Connection> connection = connectionRepository.findByAddressPincodeAndConnectionStatusFalse(pincodeNumber);
		return connection;
	}

//	*****************************Serach*************************
	public List<Connection> searchByCustomerByConsumerNumber(Long consumerNumber) {
		// TODO Auto-generated method stub

		List<Connection> connection = connectionRepository.findByConsumerNumber(consumerNumber);
		return connection;

	}
//	*************************Modify**************************

	public Object modifyConnectionAddress(Connection connection) {
		// TODO Auto-generated method stub
//	Connection dbconnecton=connectionRepository.findById()
		if (!connectionRepository.findById(connection.getConnectionId()).isPresent()) {
			throw new ResourceNotFoundException("connection  Id not found");
		}
		connectionRepository.save(connection);
		return "Address Succesfully changes for this Connection";

	}

}
