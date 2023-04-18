package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class MypageUI extends MemberMainUI {
	
	private int menu() {
		System.out.println("--------------------------");
		System.out.println("\t마이 페이지");
		System.out.println("--------------------------");
		System.out.println("1. 회원정보 변경");
		System.out.println("2. 도서 검색");
		System.out.println("3. 도서 대출");
		System.out.println("4. 도서 반납");
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
				System.out.println("회원정보변경 변경");
				break;
			case 2:
				ui = new BookSearch();
				break;
			case 3:
				ui = new BookRent();
				break;
			case 4:
				System.out.println("도서 반납");
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
