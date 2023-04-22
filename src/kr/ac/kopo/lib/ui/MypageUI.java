package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class MypageUI extends MemberMainUI {
	
	private int menu() {
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("\t\t\t\t\t\t      %s님의 마이 페이지\t\t\t\t\t\t\t\n", LibUI.loginUser);
		System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.print("\n\t1. Password 변경\t\t2. 도서 검색\t\t3. 도서 대여\t\t4. 도서 반납\t\t5. 회원 탈퇴\t\t0. 로그아웃\n\n");
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
				ui = new delMember();
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
