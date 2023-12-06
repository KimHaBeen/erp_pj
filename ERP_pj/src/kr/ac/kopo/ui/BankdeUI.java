package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.vo.BankVO;

public class BankdeUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		List<BankVO> list = service.BankAll();
		System.out.println("account_num\tname");
		System.out.println("--------------------------------------");
		for(BankVO bank : list) {
			System.out.println(bank.getBank()+"\t\t"+bank.getOwner());
		}
		System.out.println();
		String owner = scanStr("삭제할 name를 입력하세요 : ");
		service.deleteBank(owner);
		
		System.out.println("계좌가 삭제 되었습니다.");
		

	}

}
