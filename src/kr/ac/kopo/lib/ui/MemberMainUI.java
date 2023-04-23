package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class MemberMainUI extends LibUI {
	
	
	
	private int menu() {
		System.out.println("\n==============================================");
		System.out.println("\t\t로그인 창\t\t");
		System.out.println("==============================================");
		System.out.print("\n1. 로그인\n\n2. 회원 가입\n\n0.프로그램 종료\n\n");
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

