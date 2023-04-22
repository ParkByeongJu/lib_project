package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;

public class delMember extends MemberMainUI {
	
	private LibService libservice;
	
	public delMember() {
		this.libservice = new LibService();
	}

	@Override
	public void execute() throws Exception {
		LibDAO libdao = new LibDAO();
		System.out.println("\n\n\n-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|                                                         도서 삭제                                                       |");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		String password = scanStr("회원 탈퇴를 진행하기 위해 password를 입력해주세요 : ");
		while(libdao.equalPassword(password) == 0) {
			System.out.println("※ Password가 일치하지 않습니다. 다시 입력하세요. ※");
			new MypageUI().execute();
		}
		
		libservice.delMember(password);
	}

}
