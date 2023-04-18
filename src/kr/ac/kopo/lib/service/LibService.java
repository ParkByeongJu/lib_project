package kr.ac.kopo.lib.service;

import java.util.List;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.vo.BookVO;
import kr.ac.kopo.lib.vo.MemberVO;

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
	
	public void rentalBook(String rentbook) throws Exception {
			
			libDao.bookRent(rentbook);
			
	}

}
