package com.sprintDemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintDemo.entity.Connection;
@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {

	List<Connection> findByAddressVillageAndConnectionStatusTrue(String villageName );

	List<Connection> findByAddressTalukaAndConnectionStatusTrue(String talukaName);

	List<Connection> findByAddressDistrictAndConnectionStatusTrue(String districtName);

	List<Connection> findByAddressPincodeAndConnectionStatusTrue(String pincodeNumber);

	List<Connection> findByAddressVillageAndConnectionStatusFalse(String villageName);
	
	List<Connection> findByAddressTalukaAndConnectionStatusFalse(String talukaName);

	List<Connection> findByConsumerNumber(Long consumerNumber);

	List<Connection> findByAddressDistrictAndConnectionStatusFalse(String districtName);

	List<Connection> findByAddressPincodeAndConnectionStatusFalse(Integer pincodeNumber);
}
