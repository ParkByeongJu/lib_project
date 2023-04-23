package kr.ac.kopo.lib.ui;

import java.util.List;

import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.BookVO;
import kr.ac.kopo.lib.vo.RentalBookVO;

public class BookRent extends MypageUI {
	
	private LibService libService;
	
	public BookRent() {
		this.libService = new LibService();
	}

	@Override
	public void execute() throws Exception {
		System.out.println("\n==============================================");
		System.out.println("\t\t도서 대여\t\t");
		System.out.println("==============================================");
		String rentBook = scanStr("\n● 대여할 도서 이름을 입력해주세요 => ");
		List<RentalBookVO>rentalbook = libService.rentalBook(rentBook);
		
		System.out.println("\n==============================================");
		System.out.println("\t\t도서 대여가 완료되었습니다.\t\t");
		System.out.println("==============================================");
		System.out.print("\t제목\t     대여 날짜      반납 날짜\n");
		System.out.println("==============================================");
		for(RentalBookVO rentalBook : rentalbook) {
			System.out.printf("  %s   %s\t%s", rentalBook.getName(), rentalBook.getRentalDate(), rentalBook.getReturnDate());
		}
		System.out.println();
		System.out.println("==============================================");
	
	}
}


