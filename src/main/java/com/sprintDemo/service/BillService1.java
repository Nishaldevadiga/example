package com.sprintDemo.service;

import java.time.LocalDate;
import java.util.List;

import com.sprintDemo.entity.Bill;
import com.sprintDemo.entity.ConnectionType;
import com.sprintDemo.entity.Reading;

public interface BillService1 
{
	
	    public Bill viewBillByConsumerNumber(Long consumerNumber);
	    
	    public Bill viewBillMobileNumber(String MobileNumber);
	    
	    public Bill viewBillByEmail(String Email);
	    
	    public List<Bill>viewBillForDateRange(LocalDate startdate,LocalDate enddate);

	    public double enrgeyBillCalculator(ConnectionType enumvalue,double noOfUnit);
	    
	    public void emailBillToCustomer(Long consumerNumber,String email);
	    
	    public Bill generateBill(Reading reading);
}



