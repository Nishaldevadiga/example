package com.sprintDemo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintDemo.entity.Bill;
import com.sprintDemo.entity.Reading;
import com.sprintDemo.service.BillService;
import com.sprintDemo.service.ReadingService;
import com.sprintDemo.service.ReadingServiceImpl;

@RestController
@RequestMapping
public class BillAndReadingController
{
	

		
	@Autowired
     BillService billservice;
		
		@Autowired
		ReadingService readingservice;
		
		
		
		
		@PostMapping("/bill")//For Bill
		public Bill addbill(@RequestBody Bill bill) {
			
			return billservice.savebill(bill);
		}
		
		
		@PostMapping("/bill/{readingId}")
		public Bill getbill(@PathVariable("readingId") int readingId,@RequestBody Bill bill ) {
		Reading read=readingservice.getReading(readingId);
			System.out.println(read);
		    bill.setBillForReading(read);
		    Bill b = billservice.savebill(bill);
		    System.out.println(b);
			//System.out.println(user);
//			System.out.println(user.getBillForReading());
			return null;
//			return billservice.getbill(id);
		}
		
		
		@PostMapping("/reading")//For reader class
		public Reading savereading(@RequestBody Reading reading) {
			System.out.println("health chek");
			System.out.println(reading);
			return readingservice.savereading(reading);
		}
		
		@GetMapping("/reading/{id}")
		public Reading showreading(@PathVariable("id") int id ) {
			return readingservice.showreading(id);
		}

	//	
//		@GetMapping("/readby/{reading_Id}/{billDate}")
//		public Reading findMeterReadingByConsumerNumberAndBillDate(@PathVariable ("reading_Id") Integer reading_Id,@PathVariable ("billDate") LocalDate billDate) {
//		return readingservice.findMeterReadingByConsumerNumberAndBillDate(reading_Id, billDate);
	//}

		
		
		
		

	}



