package kr.ac.kopo.ui;

public class MainUI extends BaseUI{
	
	public void user() throws Exception {
		System.out.println("1. Rogin");
		System.out.println("2. SignUp");
		System.out.println("3. Delete User");
		
		int num = sc.nextInt();
		
		switch(num) {
			case 1:
				RoginUI rui = new RoginUI();
				rui.execute();
				break;
			case 2:
				SignUpUI sui = new SignUpUI();
				sui.execute();
				break;
			case 3:
				DeleteUser user = new DeleteUser();
				user.execute();
				break;
		}
		
	}
	
	public void execute() throws Exception {
		while(true) { 
		System.out.println();
		String type = menu();
		IAllUI ui = null;
		switch(type) {
		case "1" :
			ui = new BankUI();
			break;
		case "2" :
			ui = new BankinUI();
			break;
		case "3" :
			ui = new BankdeUI();
			break;
		case "4" :
			ui = new CardUI();
			break;
		case "5" :
			ui = new CardinUI();
			break;
		case "6" :
			ui = new CarddeUI();
			break;
		case "7" :
			ui = new AllscUI();
			break;
		case "8" :
			ui = new BalanceUI();
			break;
		case "0" :
			ui = new ExitUI();
		}
		
		if (ui != null) {
			ui.execute();
		}else System.out.println("잘못 입력하셨습니다.");
	
		}
		
	}

	private String menu() {
		
		System.out.println("=============회계장부============");
		System.out.println("1. 계좌 조회");
		System.out.println("2. 계좌 등록");
		System.out.println("3. 계좌 삭제");
		System.out.println("4. 카드 조회");
		System.out.println("5. 카드 등록");
		System.out.println("6. 카드 삭제");
		System.out.println("7. 전체 목록 조회");
		System.out.println("8. 계정과목 입력하기");
		System.out.println("0. 종료");
		System.out.println("===============================");
		return scanStr("메뉴 선택 : \n");
		
	}

}
