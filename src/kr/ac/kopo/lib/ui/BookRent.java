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
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("\t\t\t\t\t\t           책대여\t\t\t\t\t\t\t\n");
		System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		String rentBook = scanStr("대여할 책 이름을 입력해주세요 : ");
		List<RentalBookVO>rentalbook = libService.rentalBook(rentBook);
		
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t       도서 대여가 완료되었습니다.\t\t\t\t\t\t\t|");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t      제목\t\t  대여 날짜\t\t   반납 날짜\t\t");
		System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		for(RentalBookVO rentalBook : rentalbook) {
			System.out.printf("%s\t%s\t%s", rentalBook.getName(), rentalBook.getRentalDate(), rentalBook.getReturnDate());
		}
		
	
	}
}


