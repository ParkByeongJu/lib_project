package kr.ac.kopo.lib.ui;

import java.util.Scanner;

public class LibUI extends BaseUI {

	private int menu() {
		System.out.println("----------------------------------");
		System.out.println("\t게시판 관리 프로그램\t");
		System.out.println("----------------------------------");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 도서 전체 검색");
		System.out.println("4. 도서 검색");
		System.out.println("5. 도서 대여");
		System.out.println("6. 도서 반납");
		System.out.println("0.프로그램 종료");
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
				ui = new AddMemberUI();
				break;
			case 2:
				ui = new LoginUI();
				break;
			case 3:
				ui = new bookAllSearch();
				break;
			case 4:
				ui = new bookSearch();
				break;
			case 5:
				ui = new BookRent();
				break;
			case 6:
				ui = new BookReturn();
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
