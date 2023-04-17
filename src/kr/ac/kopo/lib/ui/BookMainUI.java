package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class BookMainUI extends LibUI{
	
	private int menu() {
		System.out.println("--------------------------");
		System.out.println("\t도서 창");
		System.out.println("--------------------------");
		System.out.println("1. 전체 도서 검색");
		System.out.println("2. 도서 대여");
		System.out.println("3. 도서 반납");
		System.out.println("0. 이전 페이지로 돌아가기");
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
				System.out.println("1. 전체 도서 검색");
				break;
			case 2:
				System.out.println("2. 도서 대여");
				break;
			case 3:
				System.out.println("3. 도서 반납");
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
