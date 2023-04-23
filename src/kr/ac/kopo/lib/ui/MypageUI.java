package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class MypageUI extends LoginUI {
	
	private int menu() {
		System.out.println("\n==============================================");
		System.out.printf("\t\t%s님의 마이 페이지\t\t\n", LibUI.loginUser);
		System.out.println("==============================================");
		System.out.print("\n1. 회원정보변경\n\n2. 도서검색\n\n3. 도서 대여\n\n4. 도서 반납\n\n5. 회원탈퇴\n\n0. 로그아웃\n\n");
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
				ui = new ChangeMemberInformation();
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
				ui = new DelMember();
				break;
			case 0:
				LibUI libui = new LibUI();
				libui.execute();
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
