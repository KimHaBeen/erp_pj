package kr.ac.kopo.vo;

public class CardVO {
	
	private int card;
	private String name;
	private String owner;
	
	public CardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardVO(int card, String name, String owner) {
		super();
		this.card = card;
		this.name = name;
		this.owner = owner;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "CardVO [card=" + card + ", name=" + name + ", owner=" + owner + "]";
	}


	
}