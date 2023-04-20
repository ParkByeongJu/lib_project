package kr.ac.kopo.lib.ui;

public class ExitUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("\n\n\n---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|                                                      도서 프로그램을 종료합니다.                                                 |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.exit(0);

	}

}
