package com.sprintDemo.entity;

import java.time.LocalDate;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Connection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long connectionId;
	private Long consumerNumber;

	private LocalDate applicationDate;
	private LocalDate connectionDate;
	private boolean connectionStatus;

//	 @Enumerated(EnumType.STRING)
	private ConnectionType connectiontype;
	
	@OneToOne
	private Customer customer;

	@OneToOne
	private Address address;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ConnectionType getConnectiontype() {
		return connectiontype;
	}

	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public void setConnectiontype(ConnectionType connectiontype) {
		this.connectiontype = connectiontype;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDate getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(LocalDate connectionDate) {
		this.connectionDate = connectionDate;
	}

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	@Override
	public String toString() {
		return "Connection [connectionId=" + connectionId + ", consumerNumber=" + consumerNumber + ", customer="
				+ customer + ", applicationDate=" + applicationDate + ", connectionDate=" + connectionDate
				+ ", connectionStatus=" + connectionStatus + ", connectiontype=" + connectiontype + ", address="
				+ address + "]";
	}

}
