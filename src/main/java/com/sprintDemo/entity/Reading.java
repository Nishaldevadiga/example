package com.sprintDemo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Reading
{
		// should be auto-generated
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int readingId;

		@OneToOne
		private Connection connection;

		private int unitsConsumed;
		// you have to decide either to store path of meter reading photo or to store
		// meter reading photo
		private String readingPhoto;

//		@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//		@JsonFormat(pattern = "YYYY-MM-dd HH:mm",shape = Shape.STRING)
		private LocalDate readingDate;
		// should be pre-populated based on connection type and other parameter
		private int pricePerUnits;

//		@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy ="billForReading") 
//		private Bill bill;

		public Reading() {
			super();
		}

		public Reading(int readingId, int unitsConsumed, String readingPhoto, LocalDate readingDate, int pricePerUnits) {
			super();
			this.readingId = readingId;
			this.unitsConsumed = unitsConsumed;
			this.readingPhoto = readingPhoto;
			this.readingDate = readingDate;
			this.pricePerUnits = pricePerUnits;
		}

		public int getReadingId() {
			return readingId;
		}

		public void setReadingId(int readingId) {
			this.readingId = readingId;
		}

		public int getUnitsConsumed() {
			return unitsConsumed;
		}

		public void setUnitsConsumed(int unitsConsumed) {
			this.unitsConsumed = unitsConsumed;
		}

		public String getReadingPhoto() {
			return readingPhoto;
		}

		public void setReadingPhoto(String readingPhoto) {
			this.readingPhoto = readingPhoto;
		}

		public LocalDate getReadingDate() {
			return readingDate;
		}

		public void setReadingDate(LocalDate readingDate) {
			this.readingDate = readingDate;
		}

		public int getPricePerUnits() {
			return pricePerUnits;
		}

		public void setPricePerUnits(int pricePerUnits) {
			this.pricePerUnits = pricePerUnits;
		}

		public Connection getConnection() {
			return connection;
		}

		public void setConnection(Connection connection) {
			this.connection = connection;
		}

		@Override
		public String toString() {
			return "Reading [readingId=" + readingId + ", connection=" + connection + ", unitsConsumed=" + unitsConsumed
					+ ", readingPhoto=" + readingPhoto + ", readingDate=" + readingDate + ", pricePerUnits=" + pricePerUnits
					+ "]";
		}

		// public Bill getBill() {
//			return bill;
//		}
//		public void setBill(Bill bill) {
//			this.bill = bill;
//		}

	}


