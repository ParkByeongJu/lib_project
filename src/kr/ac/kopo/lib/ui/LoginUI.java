package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.dao.LibDAO;
public class LoginUI extends MemberMainUI {
	
	
	
	public LoginUI() {
	}

	@Override
	public void execute() throws Exception {
		
		
		LibDAO libdao = new LibDAO();
		System.out.println("\n==============================================");
		System.out.println("\t\t\t로그인\t\t");
		System.out.println("==============================================");
		String Id = scanStr("\n● ID를 입력해주세요 : ");
		String Password = scanStr("\n● Password를 입력해주세요 : ");
		while(libdao.LoginMember(Id, Password) == 0) {
			System.out.println("\n");
			System.out.println("***********************");
			System.out.println("    일치하지 않습니다.");
			System.out.println("  확인 후 다시 입력해주세요.");
			System.out.println("***********************");
			System.out.println("\n");
			Id = scanStr("\n● ID를 입력해주세요 : ");
			Password = scanStr("\n● Password를 입력해주세요 : ");
		}
		
		LibUI.loginUser = Id;
		System.out.println("\n\n==============================================");
		System.out.printf("\t   *** %s님 환영합니다. ***\t\t\n", Id);
		System.out.println("==============================================");
		ILibUI ui = null;
		if(Id.equals("admin")) {
		    AdminUI adminUI = new AdminUI();
		    adminUI.execute();
		} else {
		    MypageUI mypage = new MypageUI();
		    mypage.execute();
		}
	
	}
}
