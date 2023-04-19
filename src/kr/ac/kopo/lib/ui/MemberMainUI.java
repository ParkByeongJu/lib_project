package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class MemberMainUI extends LibUI {
	
	
	
	private int menu() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------");
		System.out.println("|                                            로그인 창                                          |");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("%15s", "1. 로그인");
		System.out.printf("%20s", "2. 회원가입");
		System.out.printf("%24s\n", "0. 프로그램 종료");
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
				ui = new LoginUI();
				break;
			case 2:
				ui = new AddMemberUI();
				break;
			case 0:
				ui = new ExitUI();
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
