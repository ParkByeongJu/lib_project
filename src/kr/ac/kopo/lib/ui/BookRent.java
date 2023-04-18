package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.service.LibService;

public class BookRent extends BaseUI {
	
	private LibService libService;
	
	public BookRent() {
		this.libService = new LibService();
	}

	@Override
	public void execute() throws Exception {
		System.out.println("-----------------------");
		System.out.println("\t책 대여\t");
		System.out.println("-----------------------");
		String rentbook = scanStr("대여할 책 이름을 입력해주세요 : ");
		
		 libService.rentalBook(rentbook);
		
		
	}

}
