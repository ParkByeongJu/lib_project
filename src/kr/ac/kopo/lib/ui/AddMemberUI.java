package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.MemberVO;

public class AddMemberUI extends BaseUI {
	
	private LibService libservice;

	
	public AddMemberUI() {
		libservice = new LibService();
	}


	@Override
	public void execute() throws Exception {
		
		LibDAO libdao = new LibDAO();
		System.out.println("\n==============================================");
		System.out.println("\t\t회원 가입 \t\t");
		System.out.println("==============================================");
		String Id = scanStr("\n● ID를 입력해주세요 => ");
		while(libdao.equalID(Id) == 1) {
			System.out.println("\n※입력한 ID가 중복입니다. 다른 ID를 입력해주세요.※\n");
			Id = scanStr("\n● ID를 입력해주세요 => ");
		}
		String Password = scanStr("\n● Password를 입력해주세요 => ");
		String Password2 = scanStr("\n● Password를 다시 입력해주세요 => ");
		while(!Password.equals(Password2)) {
			Password = null;
			Password2 = null;
			System.out.println("\n※ Password를 잘못입력하셨습니다. ※\n");
			Password = scanStr("\n● Password를 입력해주세요 => ");
			Password2 = scanStr("\n● Password를 다시 입력해주세요 => ");
			
		}
		String name = scanStr("\n● 이름을 입력해주세요 => ");
		String birth = scanStr("\n● 생년월일 (기호없이 숫자)을 입력해주세요 => ");
		String email = scanStr("\n● Email을 입력해주세요 => ");
		String phone = scanStr("\n● 휴대폰번호(-없이 숫자)를 입력해주세요 => ");
		System.out.println("==============================================");
		
		MemberVO member = new MemberVO();
		member.setId(Id);
		member.setPassword(Password);
		member.setName(name);
		member.setEmail(email);
		member.setPhone(phone);
		member.setBirth(birth);
		
		libservice.insertMember(member);
		System.out.println("\n*** 회원가입이 완료되었습니다. ***\n");
		
		
		
		

	}

}
