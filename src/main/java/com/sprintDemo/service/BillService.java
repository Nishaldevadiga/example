package com.sprintDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintDemo.entity.Bill;
import com.sprintDemo.repository.Billdao;

@Service
public class BillService 
{

	@Autowired
	private Billdao billdao;

	
	
		public BillService()
		{
			super();
		}


		
		
		
		
		public Bill savebill( Bill bill)
		{
			//bill.getBillForReading();
		
			return billdao.save(bill);
			//return billdao.save(readingId);
			
		}
		

		
//		public Bill getbill(long bill_Id ) {
//			return billdao.findById(null).orElse(null);
//		}
	}



