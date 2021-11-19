package com.sprintDemo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sprintDemo.entity.Bill;
import com.sprintDemo.entity.Connection;
import com.sprintDemo.entity.ConnectionType;
import com.sprintDemo.entity.Reading;
import com.sprintDemo.repository.Billdao;
import com.sprintDemo.repository.ConnectionRepository;

@Service
public class BillServiceImpl implements BillService1
{
	
	
		@Autowired
		private Billdao bdao; 
		
		ConnectionType enumvalue1;
		
		@Autowired
		private ConnectionRepository connectionRepo;

//		public Bill savebill( Bill bill)
//		{
//			//bill.getBillForReading();
	//	
//			return bdao.save(bill);
//			//return billdao.save(readingId);
//			
//		}
		
		
		@Override
		public Bill viewBillByConsumerNumber(Long consumerNumber)
		{
			
			//Bill bill=new Bill();
			Pageable page = PageRequest.of(0, 1, Sort.by("billDate").descending());

			List<Bill>bill=bdao.readBillByConsumerNumber(consumerNumber, page);
			if(bill!=null && !bill.isEmpty())
			{
				return bill.get(0);
			}
			return null;
		}

		@Override
		public Bill viewBillMobileNumber(String MobileNumber) {
	      	Pageable page = PageRequest.of(0, 1, Sort.by("billDate").descending());

			List<Bill>bill=bdao.readBillByMobileNumber(MobileNumber, page);
			if(bill!=null && !bill.isEmpty())
			{
				return bill.get(0);
			}
			return null;
		}
			
		

		@Override
		public Bill viewBillByEmail(String Email) {
			// TODO Auto-generated method stub
		    Pageable page = PageRequest.of(0, 1, Sort.by("billDate").descending());

			List<Bill> bill=bdao.readBillByEmail(Email, page);
			if(bill!=null && !bill.isEmpty()) {
				return bill.get(0);
			}
			return null;
		}
		

		@Override
		public List<Bill> viewBillForDateRange(LocalDate startdate, LocalDate enddate) {
			// TODO Auto-generated method stub
			
			List<Bill> billlist=new ArrayList<Bill>();
			billlist=bdao.readBillForDateRange(startdate, enddate);
			if(!billlist.isEmpty()) {
				return billlist;
			}
			return null;
		}

		@Override
		public double enrgeyBillCalculator(ConnectionType enumvalue, double noOfUnit) {
			// TODO Auto-generated method stub
			double cost=0.0f;
			if(enumvalue==enumvalue1.NON_INDUSTRIAL) {
				
				cost=noOfUnit*10;
			}
			if(enumvalue==enumvalue.INDUSTRIAL) {
				cost=noOfUnit*20;
				
			}
			if(enumvalue==enumvalue.AGRICULTURAL) {
				cost=noOfUnit*15;
			}
			                                     
			
			return cost;
		}

		@Override
		public Bill generateBill(Reading reading) {
			// TODO Auto-generated method stub
			Bill bill = new Bill();
			bill.setBillForReading(reading);
			bill.setBillDate(reading.getReadingDate());
			bill.setUnitsConsumed(reading.getUnitsConsumed());
			Connection connection = connectionRepo.getById(reading.getConnection().getConnectionId());
			double cost = enrgeyBillCalculator(connection.getConnectiontype(), reading.getUnitsConsumed());
			int roundedCost = (int) Math.round(cost);
			bill.setBillAmount(roundedCost);
			Bill newBill = bdao.save(bill);
			//emailBillToCustomer(reading.getConnection().getConsumerNumber(),reading.getConnection().getCustomer().getEmail());
			
			
			
			return newBill;
		}
		
		@Override
		public void emailBillToCustomer(Long consumerNumber, String email) {
			// TODO Auto-generated method stub
			boolean flag1,flag2;
			 Pageable page = PageRequest.of(0, 1, Sort.by("billDate").descending());
			 Pageable page1 = PageRequest.of(0, 1, Sort.by("billDate").descending());

				List<Bill> bill=bdao.readBillByEmail(email, page);
				if(bill!=null && !bill.isEmpty()) {
					flag1=true;
				}
				
				else {
					flag1=false;
				}
				

				List<Bill>bill1=bdao.readBillByConsumerNumber(consumerNumber, page1);
				if(bill1!=null && !bill1.isEmpty())
				{
				 flag2=true;
				}
				flag2= false;
			
			if(flag1&&flag2) {
//				
				System.out.println("Email Sent Successfully");
				
			}
			else {
				System.out.println("Invalid Credentials");
			}
			
			
		}
		
		
		

	}



