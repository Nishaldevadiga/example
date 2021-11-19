package com.sprintDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sprintDemo.entity.Customer;




@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	public Customer findByEmail(String email);
	
	@Query("from Customer c where c.customerId=?1")
	public Customer getById(Long userId);
	
	 @Query("from Customer c where c.addharNumber=?1")
	    public Customer findByaddharNumber(Long number);
	 
	 @Query("from Customer c where c.mobileNumber=?1")
	    public Customer findBymobileNumber(String number);
	 
	 @Query("from Customer c where c.email=?1")
	    public Customer findByemail(String email);
	 
	 @Query("from Customer c where c.firstName=?1 and c.middleName=?2 and c.lastName=?3")
	    public List<Customer>findByName(String firstName, String middleName,String lastName);

}
