package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class LibUI extends BaseUI {
	
	public static String loginUser = "";

	private int menu() {
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t\t도서 관리 프로그램 \t\t\t\t\t\t\t|");
		System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.print("\n\t\t   1. 로그인\t\t\t\t\t\t\t\t0. 프로그램 종료\n\n");
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
				ui = new MemberMainUI();
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
