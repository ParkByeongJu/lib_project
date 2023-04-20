package kr.ac.kopo.lib.service;

import java.util.List;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.vo.BookVO;
import kr.ac.kopo.lib.vo.MemberVO;
import kr.ac.kopo.lib.vo.RentalBookVO;

public class LibService {
	
	private LibDAO libDao;
	
	public LibService() {
		libDao = new LibDAO();
	}
	
	public void insertMember(MemberVO member) {

		libDao.insertMember(member);

	}
	
	public List<BookVO> searchAll(){
		List<BookVO> bookList = libDao.searchAll();
		
		return bookList;
	}

	
	public List<BookVO> searchByName(String Name) {
		List<BookVO> bookList = libDao.searchName(Name);
		
		return bookList;
	}

	public List<BookVO> searchByWriter(String writer) {
		List<BookVO> bookList = libDao.searchWriter(writer);
		
		return bookList;
	}
	
	public List<BookVO> searchByPublisher(String publisher) {
		List<BookVO> bookList = libDao.searchPublisher(publisher);
		
		return bookList;
	}
	
	public void rentalBook(String bookname) throws Exception {
	    libDao.bookRent(bookname);
	}
	
	public void returnBook(String bookname) throws Exception {
	    libDao.bookReturn(bookname);
	}
	
	public List<RentalBookVO> rentalBookList(){
		List<RentalBookVO> rentalBookList = libDao.rentalBookList();
		
		return rentalBookList;
	}
	
	public void addBook(BookVO book) {

		libDao.addBook(book);

	}
	public void delBook(String bookname) throws Exception {
	    libDao.delBook(bookname);
	}

}
