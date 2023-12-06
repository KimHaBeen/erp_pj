package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.service.BankSV;

public abstract class BaseUI implements IAllUI{
	protected Scanner sc;
	protected BankSV service;

	
	public BaseUI () {
		sc      = new Scanner(System.in);
		service = new BankSV();
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	protected int scanInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
}