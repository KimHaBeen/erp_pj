package kr.ac.kopo;

import kr.ac.kopo.ui.MainUI;

public class BankMain {

	public static void main(String[] args) {
		MainUI ui = new MainUI();
		try {
			ui.user();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
