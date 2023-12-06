package kr.ac.kopo.ui;

import kr.ac.kopo.service.BankSV;
import kr.ac.kopo.vo.UserVO;

public class SignUpUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		String name = scanStr("user name: ");
		int pw = scanInt("user password: ");
		
		UserVO user = new UserVO();
		user.setName(name);
		user.setPassword(pw);
		
		service.signUp(user);
		
		System.out.println("회원가입 완료!");
		System.out.println();
		
		MainUI ui = new MainUI();
		ui.user();
	}

}
