package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class BookSearch extends MypageUI {

	private int menu() {
		System.out.println("\n\n\n---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|                                                            도서 검색                                                      |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%16s", "1. 전체 도서 검색");
		System.out.printf("%23s", "2. 제목으로 검색");
		System.out.printf("%22s", "3. 저자로 검색");
		System.out.printf("%22s", "4. 출판사로 검색");
		System.out.printf("%26s\n", "0. 이전 페이지로 돌아가기");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.print("원하는 항목을 선택해주세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}
	
	@Override
	public void execute() throws Exception {
		while (true) {
			int type = menu();
			ILibUI ui = null;
			switch (type) {
			case 1:
				ui = new BookAllSearch();
				break;
			case 2:
				ui = new BookNameSearch();
				break;
			case 3:
				ui = new BookWriterSearch();
				break;
			case 4:
				ui = new BookPublisherSearch();
				break;
			case 0:
				super.execute();
				break;
			}

			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("\n잘못 입력하셨습니다.\n");
				
			}
		}
	}

}
