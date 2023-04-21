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
				
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t       대여 현황 전체 출력\t\t\t\t\t\t\t|");
		System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println("\t      제목\t\t   대여 회원\t\t   대여 날짜\t\t   반납 날짜\t\t   대여 현황");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		LibDAO libDao = new LibDAO();
		for(RentalBookVO book : rentalBookList) {
			String name = book.getName() != null ? book.getName() : "";
	        String member = book.getMember() != null ? book.getMember() : "-";
	        String rentalDate = book.getRentalDate() != null ? book.getRentalDate().toString() : "-";
	        String returnDate = book.getReturnDate() != null ? book.getReturnDate().toString() : "-";
	        String rentalStatus = book.getRentalStatus() != null ? book.getRentalStatus() : "";
			System.out.printf("       %-22s", name);
			System.out.printf("     %-24s", member);
			System.out.printf("%-24s", rentalDate);
			System.out.printf("%-20s", returnDate);
			System.out.printf("%-4s\n", rentalStatus);
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");

	}

}
	

