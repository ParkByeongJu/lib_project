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

		System.out.println("\n\n\n---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|                                                     출판사 도서 출력                                                        |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%12s", "제목");
		System.out.printf("%29s", "저자");
		System.out.printf("%34s", "출판사");
		System.out.printf("%30s\n", "입고 날짜");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		LibDAO libDao = new LibDAO();
		for (BookVO book : bookList) {
			System.out.printf("%-37s", book.getName());
			System.out.printf("%-32s", book.getWriter());
			System.out.printf("%-22s", book.getPublisher());
			System.out.printf("%16s\n", book.getDate());

		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------\n\n\n");

	}
}
