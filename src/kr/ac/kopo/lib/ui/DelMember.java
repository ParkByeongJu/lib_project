package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;

public class DelMember extends MypageUI {
	
	private LibService libservice;
	
	public DelMember() {
		this.libservice = new LibService();
	}

	@Override
	public void execute() throws Exception {
		LibDAO libdao = new LibDAO();
		System.out.println("\n==============================================");
		System.out.println("\t\t회원 탈퇴\t\t");
		System.out.println("==============================================");
		String password = scanStr("\n● 회원 탈퇴를 진행하기 위해 password를 입력해주세요 => ");
		while(libdao.equalPassword(password) == 0) {
			System.out.println("\n※ Password가 일치하지 않습니다. 다시 입력하세요. ※");
			new MypageUI().execute();
		}
		
		libservice.delMember(password);
	}

}
