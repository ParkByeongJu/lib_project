package kr.ac.kopo.lib.ui;

public class bookSearch extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("-----------------------");
		System.out.println("\t도서 검색\t");
		System.out.println("-----------------------");
		String bookName = scanStr("검색할 도서명을 입력해주세요 : ");
	}

}
