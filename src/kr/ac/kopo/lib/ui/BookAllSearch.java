package kr.ac.kopo.lib.ui;

import java.util.List;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.BookVO;

public class BookAllSearch extends BookSearch {

	private LibService libService;
	
	public BookAllSearch() {
		libService = new LibService();
	}
	
	@Override
	public void execute() throws Exception {
		
		List<BookVO> bookList = libService.searchAll();
		
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t       도서 전체 출력   \t\t\t\t\t\t\t");
		System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.print("\n\t\t제목\t\t\t저자\t\t\t\t출판사\t\t\t\t입고 날짜\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		LibDAO libDao = new LibDAO();
		for(BookVO book : bookList) {
			System.out.printf("\t%-28s", book.getName());
			System.out.printf("%-31s", book.getWriter());
			System.out.printf("%-30s", book.getPublisher());
			System.out.printf("%10s\n", book.getDate());
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");

	}
}
