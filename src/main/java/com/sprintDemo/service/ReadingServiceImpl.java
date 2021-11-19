package com.sprintDemo.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cg.dao.Readingdao;
import com.sprintDemo.entity.Reading;
import  com.sprintDemo.repository.Readingdao;

@Service
public class ReadingServiceImpl implements ReadingService1
{
		@Autowired
		private Readingdao repo;
		
		//@Autowired
		//private Readingdao readingdao;
		
		
		public Reading selfSubmitReading(Reading reading)
		{
			return repo.save(reading);
		}

		@Override
		public Reading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumbers, LocalDate billDate)
		{
	        System.out.println(billDate);
	        System.out.println("hello");
			Reading reading = repo.readMeterReadingByConsumerNumberAndBillDate(consumerNumbers, billDate);
			
			
			return reading;
		}
		
		
			public List<Reading> findMeterReadingByConsumerNumber (Long consumerNumber)
			{
		        List<Reading> connection = repo.searchByReadingByConsumerNumber(consumerNumber);
		        return connection;
		        
		    }
			
			
			
		}









//			List<Reading> reading=repo.findAll();
//			
//			List<Reading> read1=new ArrayList<Reading>();	
	//
//			for(Reading read : reading)
//			{
//				if(read.getReadingId()==(consumernumber) )
//				{
//			       //  List<Reading> read1=new ArrayList<Reading>();	
//			         
//			         read1.add(read);
//				}
//			}
//			
//			return read1;
//		}
	//	

		
		





