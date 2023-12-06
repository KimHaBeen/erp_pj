package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.vo.BalanceVO;
import kr.ac.kopo.vo.BankVO;

public class BankUI extends BaseUI {
	
	@Override
	public void execute() throws Exception {
		String owner = scanStr("조회 할 name 입력: ");
		BankVO bank = service.searchByBNo(owner);
		List<BalanceVO> list = service.balanceAll(owner);
		
		System.out.println();
		if(bank == null) {
			System.out.println("--------------------------------");
			System.out.println("   계좌가 존재하지 않습니다.");
		}else { 
			System.out.println("account_num\tbank\t\tmoney\t\tname");
			System.out.println("-------------------------------------------------------");
			System.out.println(bank.getBank()+"\t\t"+bank.getName()+"\t\t"+bank.getMoney()+"\t\t"+bank.getOwner());
			System.out.println();
			System.out.println("no\tdate\t\taccount\t\tmoney\t\tname");
			System.out.println("---------------------------------------------------------------");
			for(BalanceVO balance : list) {
				System.out.println(balance.getNo()+"\t"+balance.getBalacne_date()+"\t"+balance.getName()+"\t\t"+balance.getMoney()+"\t\t"+balance.getOwner());
			}
		}

	}
}
