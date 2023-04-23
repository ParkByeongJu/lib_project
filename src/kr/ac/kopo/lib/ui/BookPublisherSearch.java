package kr.ac.kopo.lib.ui;

import java.util.List;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.BookVO;

public class BookPublisherSearch extends BookSearch {
	private LibService libService;
	
	public BookPublisherSearch() {
		libService = new LibService();
	}
	
	@Override
	public void execute() throws Exception {
		
		String publisher = scanStr("\n*** 검색할 출판사를 입력해주세요 *** => ");
		List<BookVO> bookList = libService.searchByPublisher(publisher);
		System.out.println("\n==============================================");
		System.out.println("\t\t출판사 검색 출력\t\t");
		System.out.println("==============================================");
		System.out.print("\t제목\t     저자    출판사\t    입고 날짜\n");
		System.out.println("==============================================");
		LibDAO libDao = new LibDAO();
		for (BookVO book : bookList) {
			System.out.printf("  %-15s", book.getName());
			System.out.printf("%-6s", book.getWriter());
			System.out.printf("%-6s", book.getPublisher());
			System.out.printf("%10s\n", book.getDate());
		}
		System.out.println("==============================================");
	}
}
