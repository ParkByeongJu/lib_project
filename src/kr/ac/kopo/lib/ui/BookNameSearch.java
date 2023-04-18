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
		
		String name = scanStr("\n검색할 책 제목을 입력해주세요 : ");
		List<BookVO> bookList = libService.searchByName(name);

		System.out.println("\n-------------------------------");
		System.out.println("\t도서 제목 검색 출력\t");
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
