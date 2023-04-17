package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.MemberVO;

public class AddMemberUI extends BaseUI {
	
	private LibService libservice;

	
	public AddMemberUI() {
		libservice = new LibService();
	}


	@Override
	public void execute() throws Exception {
		
		System.out.println("-------------------------");
		System.out.println("\t회원가입\t");
		System.out.println("-------------------------");
		String Id = scanStr("ID를 입력해주세요 : ");
		String Password = scanStr("Password를 입력해주세요 : ");
		String Password2 = scanStr("Password를 다시 입력해주세요 : ");
		while(!Password.equals(Password2)) {
			Password = null;
			Password2 = null;
			Password = scanStr("Password를 입력해주세요 : ");
			Password2 = scanStr("Password를 다시 입력해주세요 : ");
			
		}
		String name = scanStr("이름을 입력해주세요 : ");
		String birth = scanStr("생년월일 (기호없이 숫자)을 입력해주세요 : ");
		String email = scanStr("이메일을 입력해주세요 : ");
		String phone = scanStr("휴대폰번호(-없이 숫자)를 입력해주세요 : ");
		
		MemberVO member = new MemberVO();
		member.setId(Id);
		member.setPassword(Password);
		member.setName(name);
		member.setEmail(email);
		member.setPhone(phone);
		member.setBirth(birth);
		
		libservice.insertMember(member);
		System.out.println("\n회원가입이 완료되었습니다.\n");
		
		
		
		

	}

}