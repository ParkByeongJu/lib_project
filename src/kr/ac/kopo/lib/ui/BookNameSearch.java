package kr.ac.kopo.lib.ui;

import java.util.List;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.BookVO;

public class BookNameSearch extends BaseUI {

private LibService libService;
	
	public BookNameSearch() {
		libService = new LibService();
	}
	
	@Override
	public void execute() throws Exception {
		
		String name = scanStr("\n*** 검색할 책 제목을 입력해주세요 *** : ");
		List<BookVO> bookList = libService.searchByName(name);
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t       제목 검색 출력   \t\t\t\t\t\t\t");
		System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.print("\n\t\t제목\t\t\t저자\t\t\t\t출판사\t\t\t\t입고 날짜\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		LibDAO libDao = new LibDAO();
		for (BookVO book : bookList) {
			System.out.printf("\t%-28s", book.getName());
			System.out.printf("%-31s", book.getWriter());
			System.out.printf("%-30s", book.getPublisher());
			System.out.printf("%10s\n", book.getDate());

		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------\n\n\n");

	}

}
