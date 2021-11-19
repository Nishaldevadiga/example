package com.sprintDemo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintDemo.entity.Reading;
import com.sprintDemo.repository.Readingdao;

@Service
public class ReadingService 
{
	@Autowired
	private Readingdao readingdao;

	
	public ReadingService() 
	{
				super();
	}


		

			
			public Reading getReading(int readingId) {
				return readingdao.getById(readingId);
				
			}    //for foreign key
			
			
			
			
			
			public Reading showreading(int reading_Id ) {
				return readingdao.findById(reading_Id).orElse(null);
			}
			
			
			
			public Reading savereading(Reading reading) {
				// TODO Auto-generated method stub
				return readingdao.save(reading);
			}
			
			
			public Reading findMeterReadingByConsumerNumberAndBillDate(int reading_Id, LocalDate billDate) {
				
				List<Reading> reading = readingdao.findAll();
				
				for(Reading read : reading) {
					if(read.getReadingDate().equals(billDate) && read.getReadingId()==(reading_Id))
							{
						
						return read;
					}
				}
				return null;
			}
		}



