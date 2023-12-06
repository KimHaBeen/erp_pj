package kr.ac.kopo.ui;

public class ExitUI implements IAllUI {

	@Override
	public void execute() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);

	}

}
