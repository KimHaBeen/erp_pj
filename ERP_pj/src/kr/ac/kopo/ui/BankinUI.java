package kr.ac.kopo.ui;

import kr.ac.kopo.vo.BankVO;

public class BankinUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		int bank = scanInt("account_number : ");
		String name = scanStr("bank_name : ");
		int money = scanInt("money : ");
		String owner = scanStr("name: ");
		
		BankVO bankvo = new BankVO();
		bankvo.setBank(bank);
		bankvo.setName(name);
		bankvo.setMoney(money);
		bankvo.setOwner(owner);
		
		service.Bankin(bankvo);
		
		System.out.println("등록 완료!");

	}

}
