package kr.ac.kopo.lib.ui;

import java.util.List;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.BookVO;

public class BookAllSearch extends BaseUI {

	private LibService libService;
	
	public BookAllSearch() {
		libService = new LibService();
	}
	
	@Override
	public void execute() throws Exception {
		
		List<BookVO> bookList = libService.searchAll();
		
		System.out.println("\n\n\n---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|                                                        도서 전체 출력                                                      |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%10s", "제목");
		System.out.printf("%25s", "저자");
		System.out.printf("%33s", "출판사");
		System.out.printf("%39s\n", "입고 날짜");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		LibDAO libDao = new LibDAO();
		for(BookVO book : bookList) {
			System.out.printf("%-31s", book.getName());
			System.out.printf("%-30s", book.getWriter());
			System.out.printf("%-30s", book.getPublisher());
			System.out.printf("%17s\n", book.getDate());
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");

	}
}
