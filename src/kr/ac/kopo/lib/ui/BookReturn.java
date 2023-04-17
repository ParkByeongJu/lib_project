package kr.ac.kopo.lib.ui;

public class BookReturn extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("-----------------------");
		System.out.println("\t책 반납\t");
		System.out.println("-----------------------");
		String returnbook = scanStr("반납할 책이름을 입력해주세요 : ");
	}

}
