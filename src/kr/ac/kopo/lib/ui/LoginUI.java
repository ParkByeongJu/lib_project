package kr.ac.kopo.lib.ui;

public class LoginUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		System.out.println("-----------------------");
		System.out.println("\t로그인\t");
		System.out.println("-----------------------");
		String Id = scanStr("ID를 입력해주세요 : ");
		String Password = scanStr("Password를 입력해주세요 : ");

	}

}
