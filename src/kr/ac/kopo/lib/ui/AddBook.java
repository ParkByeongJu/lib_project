package kr.ac.kopo.lib.ui;


import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.BookVO;

public class AddBook extends AdminUI {
	
	private LibService libservice;
	
	public AddBook() {
		this.libservice = new LibService();
	}

	@Override
	public void execute() throws Exception {
		LibDAO libdao = new LibDAO();
		System.out.println("\n==============================================");
		System.out.printf("\t\t도서 입고\t\t\n");
		System.out.println("==============================================");
		String name = scanStr("\n● 입고할 책이름을 입력해주세요 : ");
		while(libdao.equalBookName(name) == 1) {
			System.out.println("\n※ 입력한 책이 존재합니다. 다른 책 입력해주세요. ※");
			name = scanStr("\n● 제목을 입력해주세요 : ");
		}
		String writer = scanStr("\n● 저자를 입력해주세요 : ");
		String publisher = scanStr("\n● 출판사를 입력해주세요 : ");
		
		BookVO book = new BookVO();
		book.setName(name);
		book.setWriter(writer);
		book.setPublisher(publisher);
		
		libservice.addBook(book);
		System.out.println("\n==============================================");
		System.out.println("\t*** 도서 입고가 완료되었습니다. ***\n");
		System.out.println("==============================================");
	}

}
