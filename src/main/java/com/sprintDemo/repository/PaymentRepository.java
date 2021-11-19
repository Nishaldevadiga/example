package com.sprintDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sprintDemo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	List<Payment> findByBillBillForReadingConnectionConsumerNumber(Long consumerNumber);
}
