package kr.ac.kopo.lib.service;

import kr.ac.kopo.lib.dao.LibDAO;
import kr.ac.kopo.lib.vo.MemberVO;

public class LibService {
	
	private LibDAO libDao;
	
	public LibService() {
		libDao = new LibDAO();
	}
	
	public void insertMember(MemberVO member) {

		libDao.insertMember(member);

	}
	
	public MemberVO IdSearch(String Id) {
		MemberVO member = libDao.IdSearch(Id);
		return member;
	}

}
