package kr.ac.kopo.ui;

import java.util.List;
import kr.ac.kopo.vo.CardVO;

public class CarddeUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		List<CardVO> list = service.CardAll();
		System.out.println("account_num\tname");
		System.out.println("--------------------------------");
		for(CardVO card : list) {
			System.out.println(card.getCard()+"\t\t"+card.getOwner());
		}
		System.out.println();
		String owner = scanStr("삭제할 name를 입력하세요 : ");
		service.deleteCard(owner);
		
		System.out.println("카드가 삭제 되었습니다.");

	}

}
