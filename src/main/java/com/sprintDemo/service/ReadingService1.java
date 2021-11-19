package com.sprintDemo.service;

import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.List;

import com.sprintDemo.entity.Reading;

public interface ReadingService1
{

		public Reading selfSubmitReading(Reading reading);

		public Reading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, LocalDate billDate);
		
		public List<Reading> findMeterReadingByConsumerNumber(Long consumernumber);
		
	   


	}



