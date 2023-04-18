package kr.ac.kopo.lib.vo;

import java.sql.Date;

public class BookVO {
	
	private String name;
	private String writer;
	private String  publisher;
	private Date date;
	
	public BookVO() {
		super();
	}
	
	

	public BookVO(String name, String writer, String publisher, Date date) {
		super();
		this.name = name;
		this.writer = writer;
		this.publisher = publisher;
		this.date = date;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return name + "\t" + writer + "\t" + publisher + "\t" + date + "\n";
	}
	
	
	
	
	
	
}
