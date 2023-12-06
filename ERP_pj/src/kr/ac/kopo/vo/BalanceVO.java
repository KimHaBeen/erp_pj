package kr.ac.kopo.vo;

public class BalanceVO {
	
	private int no;
	private String balacne_date;
	private String name;
	private int money;
	private String owner;
	
	public BalanceVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BalanceVO(String balacne_date, String name, int money, String owner) {
		super();
		this.balacne_date = balacne_date;
		this.name = name;
		this.money = money;
		this.owner = owner;
	}
	
	public BalanceVO(int no, String balacne_date, String name, int money, String owner) {
		super();
		this.no = no;
		this.balacne_date = balacne_date;
		this.name = name;
		this.money = money;
		this.owner = owner;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBalacne_date() {
		return balacne_date;
	}

	public void setBalacne_date(String balacne_date) {
		this.balacne_date = balacne_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "BalanceVO [no=" + no + ", balacne_date=" + balacne_date + ", name=" + name + ", money=" + money
				+ ", owner=" + owner + "]";
	}

	
}