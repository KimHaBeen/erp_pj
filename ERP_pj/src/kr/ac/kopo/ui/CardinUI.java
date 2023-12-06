package kr.ac.kopo.ui;

import kr.ac.kopo.vo.CardVO;

public class CardinUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		int card = scanInt("card_num: ");
		String name = scanStr("bank_name : ");
		String owner = scanStr("name: ");
		
		CardVO cardvo = new CardVO();
		cardvo.setCard(card);
		cardvo.setName(name);
		cardvo.setOwner(owner);
		
		service.Cardin(cardvo);
		
		System.out.println("등록 완료!");

	}

}
