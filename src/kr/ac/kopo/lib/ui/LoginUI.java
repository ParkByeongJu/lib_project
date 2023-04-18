package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.dao.LibDAO;
public class LoginUI extends MemberMainUI {
	
	
	
	public LoginUI() {
	}

	@Override
	public void execute() throws Exception {
		
		
		LibDAO libdao = new LibDAO();
		System.out.println("-----------------------");
		System.out.println("\t로그인\t");
		System.out.println("-----------------------");
		String Id = scanStr("ID를 입력해주세요 : ");
		String Password = scanStr("Password를 입력해주세요 : ");
		while(libdao.LoginMember(Id, Password) == 0) {
			System.out.println("\n-------------------------");
			System.out.println("일치하지 않습니다.\n확인후 다시 입력해주세요.");
			System.out.println("-------------------------");
			Id = scanStr("ID를 입력해주세요 : ");
			Password = scanStr("Password를 입력해주세요 : ");
		}
		
		System.out.println("\n*** 로그인이 완료되었습니다. ***\n");
		LibUI.loginUser1 = true;
		LibUI.loginUser = Id;
//		System.out.println(LibUI.loginUser);
		MypageUI mypage = new MypageUI();
		mypage.execute();
	}
	

}
