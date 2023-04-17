package kr.ac.kopo.lib.ui;

import kr.ac.kopo.lib.service.LibService;
import kr.ac.kopo.lib.vo.MemberVO;

public class IdSearchUI extends BaseUI {
	
	private LibService service;
	
	public IdSearchUI() {
		service = new LibService();
	}

	@Override
	public void execute() throws Exception {
		String Id = scanStr("\n 찾을 ID를 입력해주세요 : ");
		MemberVO member = service.IdSearch(Id);
		
		
		System.out.println("--------------------------------");
		if(member != null) {
		
		} 
		System.out.println("--------------------------------");
	}

}
