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
		
		System.out.println("\n\n\n-----------------------------------------------------------------------------------------------");
		System.out.println("|                                       도서 전체 출력                                            |");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("%12s", "제목");
		System.out.printf("%24s", "저자");
		System.out.printf("%22s", "출판사");
		System.out.printf("%24s\n", "입고 날짜");
		System.out.println("-----------------------------------------------------------------------------------------------");
		LibDAO libDao = new LibDAO();
		for(BookVO book : bookList) {
			System.out.printf("%-30s", book.getName());
			System.out.printf("%-22s", book.getWriter());
			System.out.printf("%-18s", book.getPublisher());
			System.out.printf("%16s\n", book.getDate());
		}
		System.out.println("-----------------------------------------------------------------------------------------------\n\n");

	}
}
