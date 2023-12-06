package kr.ac.kopo.vo;

public class BankVO {
	
	private int no;
	private int bank;
	private String name;
	private int money;
	private String owner;
	
	public BankVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BankVO(int no, int bank, String name, int money, String owner) {
		super();
		this.no = no;
		this.bank = bank;
		this.name = name;
		this.money = money;
		this.owner = owner;
	}

	
	public BankVO(int bank, String name, int money, String owner) {
		super();
		this.bank = bank;
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

	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
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
		return "BankVO [no=" + no + ", bank=" + bank + ", name=" + name + ", money=" + money + ", owner=" + owner + "]";
	}



	
	
}