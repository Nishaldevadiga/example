package com.sprintDemo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprintDemo.entity.Reading;
import com.sprintDemo.service.BillService1;
import com.sprintDemo.service.ReadingService1;

@RestController
public class ReadingController 
{
	   @Autowired
		ReadingService1 service;
		
		@Autowired
		BillService1 billService1;
		
		@PostMapping("/selfreading")
		public Reading selfSubmitReading(@RequestBody Reading reading)
		{
			
			 Reading newReading = service.selfSubmitReading(reading);
			 billService1.generateBill(newReading);
			 return newReading ;
		}
		
//		@GetMapping("/MeterReading")
	//	
//			public Reading findMeterReadingByConsumerNumberAndBillDate(int reading_Id, LocalDate billDate)
//			{
//			 return service.findMeterReadingByConsumerNumberAndBillDate(reading_Id, billDate);
//			}
		
		@GetMapping("/readby/{consumerNumber}/{billDate}")	
		public Reading findMeterReadingByConsumerNumberAndBillDate(@PathVariable ("consumerNumber")Long consumerNumber,@PathVariable ("billDate") String billDate)
		{
	           //date1=new SimpleDateFormat("yyyy-mm-dd");
			System.out.println(billDate);
			
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
			LocalDate date=LocalDate.parse(billDate, formatter);

			
			          
			//return service.findMeterReadingByConsumerNumber(1).get(0);
			   
			   
				return service.findMeterReadingByConsumerNumberAndBillDate(consumerNumber,date);
		}
		
		@GetMapping("/consumerid/{consumer_id}")
		public List<Reading> findMeterReadingByConsumerNumber(@PathVariable ("consumer_id")Long consumer_id)
		{
			   
			   return service.findMeterReadingByConsumerNumber(consumer_id);
		}
		
		
			
			
		}



