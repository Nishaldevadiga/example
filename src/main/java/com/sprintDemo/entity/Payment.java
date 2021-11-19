package com.sprintDemo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	private LocalDate paymentDate;
	
	
	private PaymentMode paymentMode;
	private double latePaymentCharges;
	private double totalPaid;
	private PaymentStatus paymentstatus;
	
	@OneToOne //(cascade=CascadeType.ALL)
	private Bill bill;

public Payment() {
		super();
	}



public Payment(Long paymentId, LocalDate paymentDate, PaymentMode paymentMode, double latePaymentCharges,
		double totalPaid, PaymentStatus paymentstatus, Bill bill) {
	super();
	this.paymentId = paymentId;
	this.paymentDate = paymentDate;
	this.paymentMode = paymentMode;
	this.latePaymentCharges = latePaymentCharges;
	this.totalPaid = totalPaid;
	this.paymentstatus = paymentstatus;
	this.bill = bill;
}



public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getLatePaymentCharges() {
		return latePaymentCharges;
	}
	public void setLatePaymentCharges(double latePaymentCharges) {
		this.latePaymentCharges = latePaymentCharges;
	}
	public double getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public PaymentStatus getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(PaymentStatus paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	
}
