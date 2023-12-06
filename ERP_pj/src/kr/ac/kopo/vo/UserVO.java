package kr.ac.kopo.vo;

public class UserVO {
	
	private String owner;
	private int password;
	
	
	public UserVO() {
		super();
	}

	public UserVO(String owner, int password) {
		super();
		this.owner = owner;
		this.password = password;
	}

	public String getName() {
		return owner;
	}

	public void setName(String owner) {
		this.owner = owner;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserVO [owner=" + owner + ", password=" + password + "]";
	}
	
	
	

}
