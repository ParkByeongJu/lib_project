package kr.ac.kopo.lib;

import kr.ac.kopo.lib.ui.LibUI;

public class LibMain {
	
	public static void main(String[] args) {
		
		try {
			new LibUI().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
