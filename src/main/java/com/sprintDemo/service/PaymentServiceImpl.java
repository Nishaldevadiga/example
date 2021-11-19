package com.sprintDemo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintDemo.entity.Bill;
import com.sprintDemo.entity.Customer;
import com.sprintDemo.entity.Payment;
import com.sprintDemo.entity.PaymentStatus;
import com.sprintDemo.exception.NoSuchCustomerException;
import com.sprintDemo.repository.Billdao;
import com.sprintDemo.repository.CustomerRepository;
import com.sprintDemo.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	EmailServiceImpl emailserviceimpl; 
	
	@Autowired
	private PaymentRepository repository;
	@Autowired
	private Billdao billRepository;
	
	@Autowired
	private CustomerRepository customerrepository;
	//@Autowired
	//PaymentDao paymentDao;
	@Override
	public Payment savePayment(Payment payment) {
		return repository.save(payment);
	}

	@Override
	public List<Payment> viewHistoricalPayments(Long consumerNumber) {
		Customer customer=customerrepository.getById(consumerNumber);
		if(customer==null)
			throw new NoSuchCustomerException("consumer number is invalid");
		return repository.findByBillBillForReadingConnectionConsumerNumber(consumerNumber);
	}



	@Override
	public Payment getPaymentById(Long id) {
		 return repository.findById(id).orElse(null);
	}
	

	@Override
	public PaymentStatus payBill(Payment payment) {
		Bill bill = billRepository.findById(payment.getBill().getBillId()).orElse(null);

		LocalDate  billDueDate = bill.getBillDueDate();
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(billDueDate, currentDate);

		if(period.getDays() <= 10 && period.getMonths() <=1) {
			payment.setLatePaymentCharges(0);
			payment.setPaymentstatus(PaymentStatus.SUCCESS);
			payment.setTotalPaid(bill.getBillAmount());
			payment.setPaymentDate(LocalDate.now());
			
			//return paymentDao.createBill(payment);
			
			if(repository.save(payment) != null) return PaymentStatus.SUCCESS;
			else return PaymentStatus.FAILURE;
		
		}
		else if(period.getDays() > 10 && period.getDays() <= 20 && period.getMonths() <=1) {
			payment.setLatePaymentCharges(10);
			payment.setPaymentstatus(PaymentStatus.SUCCESS);
			payment.setTotalPaid(bill.getBillAmount() + payment.getLatePaymentCharges());
			payment.setPaymentDate(LocalDate.now());

			//return paymentDao.createBill(payment);
			
			if(repository.save(payment) != null) return PaymentStatus.SUCCESS;
			else return PaymentStatus.FAILURE;
		}
		else {
			payment.setLatePaymentCharges(20);
			payment.setPaymentstatus(PaymentStatus.SUCCESS);
			payment.setTotalPaid(bill.getBillAmount() + payment.getLatePaymentCharges());
			payment.setPaymentDate(LocalDate.now());

			//return paymentDao.createBill(payment);
			
			if(repository.save(payment) != null) return PaymentStatus.SUCCESS;
			else return PaymentStatus.FAILURE;
		}

	}

	@Override
	public void sendemailonsuccessfullpayment(Long billId) {
		try {
		String email=billRepository.findById(billId).get().getBillForReading().getConnection().getCustomer().getEmail();
		emailserviceimpl.sendSimpleMessage(email,"Payment success" , "Payment done");
		}catch(Exception e) {
			System.out.println("failed to send mail");
		}
	}



	
	}


