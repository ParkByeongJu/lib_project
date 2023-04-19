package kr.ac.kopo.lib.ui;

import java.util.List;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.BookVO;
import kr.ac.kopo.lib.vo.RentalBookVO;

public class RentalSearch extends AdminUI {
	
	private LibService libService;
	
	public  RentalSearch() {
		libService = new LibService();
	}

	@Override
	public void execute() throws Exception {
		List<RentalBookVO> rentalBookList = libService.rentalBookList();
				
		System.out.println("\n\n\n-----------------------------------------------------------------------------------------------");
		System.out.println("|                                       대여 현황 전체 출력                                            |");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("%30s", "제목");
		System.out.printf("%30s", "대여 회원");
		System.out.printf("%30s", "대여 날짜");
		System.out.printf("%30s", "반납 날짜");
		System.out.printf("%30s\n", "대여 현황");
		System.out.println("-----------------------------------------------------------------------------------------------");
		LibDAO libDao = new LibDAO();
		for(RentalBookVO book : rentalBookList) {
			String name = book.getName() != null ? book.getName() : "";
	        String member = book.getMember() != null ? book.getMember() : "";
	        String rentalDate = book.getRentalDate() != null ? book.getRentalDate().toString() : "";
	        String returnDate = book.getReturnDate() != null ? book.getReturnDate().toString() : "";
	        String rentalStatus = book.getRentalStatus() != null ? book.getRentalStatus() : "";
			System.out.printf("%-30s", name);
			System.out.printf("%-30s", member);
			System.out.printf("%-30s", rentalDate);
			System.out.printf("%-30s", returnDate);
			System.out.printf("%-30s\n", rentalStatus);
		}
		System.out.println("-----------------------------------------------------------------------------------------------\n\n");

	}

}
	

