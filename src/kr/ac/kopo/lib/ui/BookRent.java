package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.service.LibService;

public class BookRent extends MypageUI {
	
	private LibService libService;
	
	public BookRent() {
		this.libService = new LibService();
	}

	@Override
	public void execute() throws Exception {
		System.out.println("\n\n\n---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|                                                            책 대여                                                        |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		String rentbook = scanStr("대여할 책 이름을 입력해주세요 : ");
		libService.rentalBook(rentbook);
		
		LibUI libui = new LibUI();
		super.execute();
	}
}
