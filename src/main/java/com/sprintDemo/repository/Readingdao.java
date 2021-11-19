package com.sprintDemo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprintDemo.entity.*;

@Repository
public interface  Readingdao  extends JpaRepository<Reading,Integer> 
{	
		//select b.billforReading from Bill b where b.billDate=?2
		//select c.
		//consumerNumber-->connectionId--->readingId-->billId
//		public Reading readMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, LocalDate billDate);

		@Query("select r from Reading r where "
				+ "r.connection=(select c.connectionId from Connection c where c.consumerNumber=?1) And r.readingId=(select b.billForReading from Bill b where b.billDate=?2)")
		public Reading readMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, LocalDate billDate);

		@Query("select r from Reading r where r.connection=(select c.connectionId from Connection c where c.consumerNumber=?1)")
		public List<Reading> searchByReadingByConsumerNumber(Long consumerNumber);

		
		
	}



