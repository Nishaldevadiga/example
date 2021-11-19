package com.sprintDemo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprintDemo.entity.Bill;
import com.sprintDemo.entity.Connection;
import com.sprintDemo.entity.Reading;
import com.sprintDemo.entity.Customer;


@Repository
public interface Billdao extends JpaRepository<Bill, Long> 
{
	
		//consumerNumber--->connectionId---->readingId---->billId
	    @Query("Select b  from Bill b where b.billForReading in(select r.readingId from Reading r where r.connection=(select c.connectionId from Connection c  where c.consumerNumber=?1))")
		public List<Bill> readBillByConsumerNumber(Long consumerNumber, Pageable page);
	    
	  //customermobileNumber--->consumerNumber--->connectionId---->readingId---->billId
	    @Query("Select b  from Bill b where b.billForReading in (select r.readingId from Reading r where r.connection=(select c.connectionId from Connection c where c.customer="
	    		+ "(select c.customerId from Customer c where c.mobileNumber=?1)))")
	    public List<Bill>  readBillByMobileNumber(String mobileNumber, Pageable page);

	    //customerEmail--->consumerNumber--->connectionId---->readingId---->billId
	    @Query("Select b  from Bill b where b.billForReading in (select r.readingId from Reading r where r.connection=(select c.connectionId from Connection c where c.customer="
	    		+ "(select c.customerId from Customer c where c.email=?1)))")
		public List<Bill> readBillByEmail(String Email, Pageable page);

	    
	    @Query("Select b from Bill b where b.billDate between ?1 AND ?2")
	    public List<Bill> readBillForDateRange(LocalDate startDate,LocalDate enddate);
		
		
	    
	   
	}



