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
		System.out.println("\n==============================================");
		System.out.printf("\t\t도서 삭제\t\t\n");
		System.out.println("==============================================");
		String name = scanStr("\n● 삭제할 책이름을 입력해주세요 : ");
		
		libservice.delBook(name);
	}

}
