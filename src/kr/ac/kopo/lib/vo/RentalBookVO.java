package kr.ac.kopo.lib.vo;

import java.sql.Date;

public class RentalBookVO {
	
	private String name;
	private String member;
	private Date rentalDate;
	private Date returnDate;
	private String rentalStatus;
	
	
	public RentalBookVO() {
		super();
	}

	public RentalBookVO(String name, String member, Date rentalDate, Date returnDate, String rentalStatus) {
		super();
		this.name = name;
		this.member = member;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.rentalStatus = rentalStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

	@Override
	public String toString() {
		return "RentalBookVO [name=" + name + ", member=" + member + ", rentalDate=" + rentalDate + ", returnDate="
				+ returnDate + ", rentalStatus=" + rentalStatus + "]";
	}
	
	
	
	

}
