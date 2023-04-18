package kr.ac.kopo.lib.ui;

import java.util.List;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.BookVO;

public class BookPublisherSearch extends BaseUI {
	private LibService libService;
	
	public BookPublisherSearch() {
		libService = new LibService();
	}
	
	@Override
	public void execute() throws Exception {
		
		String publisher = scanStr("\n*** 검색할 책 제목을 입력해주세요 *** : ");
		List<BookVO> bookList = libService.searchByPublisher(publisher);

		System.out.println("\n-------------------------------");
		System.out.println("\t도서 출판사 검색 출력\t");
		System.out.println("-------------------------------");
		System.out.println("\n---------------------------------------------");
		System.out.println("제목\t\t저자\t출판사\t입고날짜");
		System.out.println("---------------------------------------------");
		LibDAO libDao = new LibDAO();
		for (BookVO book : bookList) {
			System.out.println(book.getName() + "\t" + book.getWriter() + "\t" + book.getPublisher() + "\t" + book.getDate());

		}

	}
}
