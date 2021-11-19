package com.sprintDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprintDemo.entity.Payment;
import com.sprintDemo.entity.PaymentStatus;



@Service
public interface PaymentService {
	public List<Payment> viewHistoricalPayments(Long consumerNumber);
	
	public Payment getPaymentById(Long id);
	
	public Payment savePayment(Payment payment);
	
	public PaymentStatus payBill(Payment payment);

	public void sendemailonsuccessfullpayment(Long billId);
	
	
	
	
	
}
