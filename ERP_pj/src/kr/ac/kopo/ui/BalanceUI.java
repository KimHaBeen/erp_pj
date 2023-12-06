package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.vo.BalanceVO;
import kr.ac.kopo.vo.BankVO;

public class BalanceUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		List<BankVO> listb = service.BankAll();
		System.out.println("account list");
		System.out.println("------------------------------------------------");
		System.out.println("1.입금  2.출금  3.미지급금  4.미수금  5.외상매출금  6.외상매입금 \n");
		System.out.println("계좌 list");
		System.out.println("--------------------------------");
		System.out.println("name \t account_number");
		for(BankVO bank : listb) {
			System.out.println(bank.getOwner()+ " \t " + bank.getBank());
		}
		System.out.println("--------------------------------");
		String owner = scanStr("name : ");
		String name = scanStr("account : ");
		String date = scanStr("date : ");
		int money = scanInt("money : ");
		
		BalanceVO balance = new BalanceVO(date, name, money, owner);
		service.updateBank(balance);
		System.out.println("완료....");
		
	}

}
