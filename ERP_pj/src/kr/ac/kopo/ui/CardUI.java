package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.vo.CardVO;

public class CardUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		String owner = scanStr("조회 할 name 입력: ");
		List<CardVO> list = service.CardAll();
		CardVO card = service.searchByCard(owner);
		
		System.out.println();
		if(card == null) {
			System.out.println("--------------------------------");
			System.out.println("   카드가 존재하지 않습니다.");
		}else {
			System.out.println("card_num\tbank_name\tname");
			System.out.println("--------------------------------------");
			System.out.println(card.getCard()+"\t\t"+card.getName()+"\t\t"+card.getOwner());
		}
	}
}
