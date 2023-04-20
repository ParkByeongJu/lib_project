package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;

public class DelBook extends AdminUI {
	
	private LibService libservice;
	
	public DelBook() {
		this.libservice = new LibService();
	}
	
	@Override
	public void execute() throws Exception {
		LibDAO libdao = new LibDAO();
		System.out.println("\n\n\n---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|                                                              도서 삭제                                                     |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		String name = scanStr("삭제할 책이름을 입력해주세요 : ");
		
		libservice.delBook(name);
	}

}
