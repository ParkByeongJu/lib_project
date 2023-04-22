package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;

public class ChangeMemberInformation extends MypageUI {
	
	public ChangeMemberInformation() {
		
	}

	@Override
	public void execute() throws Exception {
		
		LibDAO libdao = new LibDAO();
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t\t   Password 변경 \t\t\t\t\t\t\t|");
		System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		String password = scanStr("Password를 입력해주세요 : ");
		while(libdao.equalPassword(password) == 0) {
			System.out.println("※ Password가 일치하지 않습니다. 다시 입력하세요. ※");
			password = scanStr("Password를 입력해주세요 : ");
		}
		String changePassword = scanStr("변경할 Password를 입력해주세요 : ");
		String reChangePassword = scanStr("변경할 Password를 한번더 입력해주세요 : ");
		
		while(!changePassword.equals(reChangePassword)) {
            System.out.println("※ 입력하신 Password가 일치하지 않습니다. 다시 입력하세요. ※");
            changePassword = scanStr("변경할 Password를 입력해주세요 : ");
            reChangePassword = scanStr("변경할 Password를 한번더 입력해주세요 : ");
        }
        
		LibService libService = new LibService();
        libService.changeMemberInformation(changePassword);
		
		
		
	}

}
