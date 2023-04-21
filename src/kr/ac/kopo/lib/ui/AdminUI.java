package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class AdminUI extends MemberMainUI {

	
	public AdminUI() {
		
	}
	
	private int menu() {
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t   \t관리자 페이지\t\t\t\t\t\t\t|");
		System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.print("\t1. 대여 현황 검색\t");
		System.out.print("\t\t2. 도서 입고\t");
		System.out.print("\t\t3. 도서 삭제\t");
		System.out.print("\t\t0. 로그아웃\t\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
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
