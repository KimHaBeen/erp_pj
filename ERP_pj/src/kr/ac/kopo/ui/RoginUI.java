package kr.ac.kopo.ui;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.dao.Dao;
import kr.ac.kopo.vo.UserVO;

public class RoginUI extends BaseUI{
	
	String name;
	public void execute() throws Exception {
		
		while(true) {
		name = scanStr("name: ");
		int pw = scanInt("password: ");
		
		Dao dao = new Dao();
		UserVO user = new UserVO(name, pw);
		String id = dao.id(user);
		int pwd = dao.pw(user);
		
		if(id == null) {
			System.out.println("ID가 없습니다.");
			System.out.println("다시 로그인 하세요. \n");
			MainUI ui = new MainUI();
			ui.user();
		}else if(pwd == 0) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("다시 로그인 하세요. \n");
			MainUI ui = new MainUI();
			ui.user();
		}else {
			MainUI ui = new MainUI();
			ui.execute();
		}
			
		}
		
		
		//System.out.println(owner);
		
		
		
	}

}
