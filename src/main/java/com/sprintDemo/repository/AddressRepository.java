package com.sprintDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintDemo.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}        
