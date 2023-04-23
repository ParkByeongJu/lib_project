package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class AdminUI extends MemberMainUI {

	
	public AdminUI() {
		
	}
	
	private int menu() {
		System.out.println("\n==============================================");
		System.out.printf("\t\t관리자 페이지\t\t\n");
		System.out.println("==============================================");
		System.out.print("\n1. 대여 현황 검색\n\n2. 도서 입고\n\n3. 도서 삭제\n\n0. 로그 아웃\n");
		System.out.println("==============================================");
		System.out.print("\n● 원하는 항목을 선택해주세요 => ");
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
				ui = new RentalSearch();
				break;
			case 2:
				ui = new AddBook();
				break;
			case 3:
				ui = new DelBook();
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
