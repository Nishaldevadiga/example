package com.sprintDemo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sprintDemo.entity.Bill;
import com.sprintDemo.entity.ConnectionType;
import com.sprintDemo.repository.Billdao;
import com.sprintDemo.service.BillService;
import com.sprintDemo.service.BillServiceImpl;

@RestController
public class BillController 
{


	@Autowired
	private BillServiceImpl billservice; 
	
	@GetMapping("/viewbillconsumernumber/{consumerNumber}")
	public Bill viewBillByConsumerNumber(@PathVariable("consumerNumber") Long consumerNumber)
	{
		// Use connection repo and find row matching consumer number. If not found, then throw Exception with 400 http error code and consumer number does not exists
		return billservice.viewBillByConsumerNumber(consumerNumber);
	}
	
	@GetMapping("/viewBillMobileNumber/{MobileNumber}")
	public Bill viewBillMobileNumber(@PathVariable("MobileNumber") String MobileNumber)
	{
		return billservice.viewBillMobileNumber(MobileNumber);
	}
 
	
	@GetMapping("/viewBillByEmail/{Email}")
	public Bill viewBillByEmail(@PathVariable("Email") String Email)
	{
		return billservice.viewBillByEmail(Email);
	}
 
	@GetMapping("/viewBillForDateRange/{startdate}/{enddate}")
	public List<Bill> viewBillForDateRange(@PathVariable("startdate") String startdate,@PathVariable("enddate") String enddate)
	{
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate date=LocalDate.parse(startdate, formatter);
		
		DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate date1=LocalDate.parse(enddate, formatter1);

		return billservice.viewBillForDateRange(date, date1);
	}
    
//	@GetMapping(" enrgeyBillCalculator/{enumvalue}/{noOfUnit}")
//	public double enrgeyBillCalculator(@PathVariable("enumvalue") ConnectionType enumvalue,@PathVariable("noOfUnit") double noOfUnit)
//	{
//		return billservice.enrgeyBillCalculator(enumvalue, noOfUnit);
//	}

}


