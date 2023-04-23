package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.service.LibService;

public class BookReturn extends MypageUI {
private LibService libService;
	
	public BookReturn() {
		this.libService = new LibService();
	} 
	

	@Override
	public void execute() throws Exception {
		System.out.println("\n==============================================");
		System.out.println("\t\t도서 반납\t\t");
		System.out.println("==============================================");
		String returnBook = scanStr("\n● 반납할 책 이름을 입력해주세요 => ");
		libService.returnBook(returnBook);
		
		LibUI libui = new LibUI();
		super.execute();
	}
}