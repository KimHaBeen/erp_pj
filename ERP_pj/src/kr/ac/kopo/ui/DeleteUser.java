package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.vo.UserVO;


public class DeleteUser extends BaseUI{

	@Override
	public void execute() throws Exception {
		List<UserVO> list = service.UserAll();
		
		if (list.isEmpty()) {
			System.out.println("계정이 없습니다.");
			System.out.println();
			MainUI ui = new MainUI();
			ui.user();
		}else
			System.out.println("name");
			System.out.println("---------");
			for(UserVO user : list) {
				System.out.println(user.getName());
			}
			System.out.println();
			String owner = scanStr("삭제할 name를 입력하세요 : ");
			service.deleteID(owner);
			
			System.out.println("계정이 삭제 되었습니다.");
			System.out.println();
			
			MainUI ui = new MainUI();
			ui.user();
	
	}

}
