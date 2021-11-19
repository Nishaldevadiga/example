package com.sprintDemo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Bill_Table")
public class Bill
{
   // should be auto-generated
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long billId;
		
		  @OneToOne   //@MapsId        fetch = FetchType.LAZY,
		  @Fetch(FetchMode.JOIN)
	 @JoinColumn(name="read_id")
		private Reading billForReading;
		
		  private LocalDate billDate;
		private LocalDate billDueDate;
		private int unitsConsumed;
		private int billAmount;
		
		
		
		
		
//		Reading read = new Reading();
		
		
		
		public Bill() {
			super();
		}

		public Bill(Long billId, LocalDate billDate, LocalDate billDueDate, int unitsConsumed,
				int billAmount,Reading billForReading) {
			super();
			this.billId = billId;
			this.billForReading = billForReading;
			this.billDate = billDate;
			this.billDueDate = billDueDate;
			this.unitsConsumed = unitsConsumed;
			this.billAmount = billAmount;
		}
		
		
		
//		public Reading getRead() {
//			return read;
//		}
	//
//		public void setRead(Reading read) {
//			this.read = read;
//		}
	//	
		
		

		public Long getBillId() {
			return billId;
		}
		
		public void setBillId(Long billId) {
			this.billId = billId;
		}
		
		public LocalDate getBillDate() {
			return billDate;
		}
		public void setBillDate(LocalDate billDate) {
			this.billDate = billDate;
		}
		public LocalDate getBillDueDate() {
			return billDueDate;
		}
		public void setBillDueDate(LocalDate billDueDate) {
			this.billDueDate = billDueDate;
		}
		public int getUnitsConsumed() {
			return unitsConsumed;
		}
		public void setUnitsConsumed(int unitsConsumed) {
			this.unitsConsumed = unitsConsumed;
		}
		public int getBillAmount() {
			return billAmount;
		}
		public void setBillAmount(int billAmount) {
			this.billAmount = billAmount;
		}
		public Reading getBillForReading() {
			return billForReading;
		}
		public void setBillForReading(Reading billForReading) {
			this.billForReading = billForReading;
		}

		@Override
		public String toString() {
			return "Bill [billId=" + billId + ", billForReading=" + billForReading + ", billDate=" + billDate
					+ ", billDueDate=" + billDueDate + ", unitsConsumed=" + unitsConsumed + ", billAmount=" + billAmount
					+ "]";
		}


		
	}




