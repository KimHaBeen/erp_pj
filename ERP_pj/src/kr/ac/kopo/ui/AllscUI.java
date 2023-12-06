package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.vo.BankVO;
import kr.ac.kopo.vo.CardVO;

public class AllscUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		List<BankVO> listb = service.BankAll();
		List<CardVO> listc = service.CardAll();
		
		System.out.println("account_num \tbank_name \tname");
		System.out.println("--------------------------------------");
	
		if(listb.isEmpty()) {
			System.out.println("\t 등록된 계좌가 없습니다.");
		}else {
			for(BankVO bank : listb) {
				System.out.println(bank.getBank() + " \t\t" + bank.getName()  + " \t\t" + bank.getOwner());
			}
		}
		System.out.println("\n");
		System.out.println("card_num \tbank_name \tname");
		System.out.println("--------------------------------------");
	
		if(listc.isEmpty()) {
			System.out.println("\t 등록된 카드가 없습니다.");
		}else {
			for(CardVO card : listc) {
				System.out.println(card.getCard() + " \t\t" + card.getName() + " \t\t" + card.getOwner());
			}
		}		
		
	}

}
