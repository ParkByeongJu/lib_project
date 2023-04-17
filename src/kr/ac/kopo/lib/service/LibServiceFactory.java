package kr.ac.kopo.lib.service;

public class LibServiceFactory {
	
	private static LibService service = null;

	public static LibService getInstance() {
		
		if(service == null) {
			service = new LibService();
		}
		
		return new LibService();
		
	}

}
