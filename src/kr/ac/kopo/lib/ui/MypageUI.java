package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class MypageUI extends MemberMainUI {
	
	private int menu() {
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("|                                        %s님의 마이 페이지                                    |\n", LibUI.loginUser);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("%16s", "1. 회원 정보 변경");
		System.out.printf("%15s", "2. 도서 검색");
		System.out.printf("%15s", "3. 도서 대여");
		System.out.printf("%15s", "3. 도서 반납");
		System.out.printf("%20s\n", "0. 로그아웃");
		System.out.println("-----------------------------------------------------------------------------------------------");
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
				ui = new BookReturn();
				break;
			case 5:
				ui = new BookReturn();
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
