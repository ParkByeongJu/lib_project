package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class MemberMainUI extends LibUI {
	
	private int menu() {
		System.out.println("--------------------------");
		System.out.println("\t로그인 창");
		System.out.println("--------------------------");
		System.out.println("1. 로그인");
		System.out.println("2. 관리자 로그인");
		System.out.println("3. ID 및 Password 찾기");
		System.out.println("4. 회원가입");
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
				System.out.println("로그인");
				break;
			case 2:
				System.out.println("관리자 로그인");
				break;
			case 3:
				ui = new IdPasswordSearch();
				break;
			case 4:
				ui = new AddMemberUI();
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
