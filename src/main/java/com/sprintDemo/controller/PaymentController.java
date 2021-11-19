package com.sprintDemo.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprintDemo.entity.Bill;
import com.sprintDemo.entity.Payment;
import com.sprintDemo.entity.PaymentMode;
import com.sprintDemo.entity.PaymentStatus;
import com.sprintDemo.repository.Billdao;
import com.sprintDemo.repository.PaymentRepository;
import com.sprintDemo.service.BillService;
import com.sprintDemo.service.EmailServiceImpl;
import com.sprintDemo.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	Billdao billrepository;
	@Autowired
	BillService billservice;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PaymentRepository repo;

	
	
	@GetMapping("/viewHistoricalPayments")
	public List<Payment> findAllPayments(@RequestParam("consumerNumber") Long consumerNumber){
		
		return paymentService.viewHistoricalPayments(consumerNumber);
		
	}
	
	
	
	@PostMapping("/payment/")
	public PaymentStatus payBill(@RequestBody Payment payment){
		PaymentStatus paymentstatus= paymentService.payBill(payment);
		if(PaymentStatus.SUCCESS.equals(paymentstatus))
		
		paymentService.sendemailonsuccessfullpayment(payment.getBill().getBillId());
		return paymentstatus;
	}
	
//	@DeleteMapping("/paymentcancel/")
//	public String cancelPayment(@RequestBody Payment payment){
//		Payment newPayment = repo.getById(payment.getPaymentId());
//		repo.delete(newPayment);
//		return "Payment cancelled Successfully";
//	}
	
	
}



