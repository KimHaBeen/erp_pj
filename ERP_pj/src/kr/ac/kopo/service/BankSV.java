package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.Dao;
import kr.ac.kopo.vo.BalanceVO;
import kr.ac.kopo.vo.BankVO;
import kr.ac.kopo.vo.CardVO;
import kr.ac.kopo.vo.UserVO;

public class BankSV {
	
	private Dao dao;
	
	public BankSV() {
		dao = new Dao();
	}
	
	public void Bankin(BankVO bank) {
		dao.insert(bank);
	}
	
	public List<BankVO> BankAll() {
		List<BankVO> listb = dao.BankAll();
		return listb;
	}
	
	public BankVO searchByBNo (String owner) {
		BankVO bank = dao.searchByBNo(owner);
		return bank;
	}
	
	public void deleteBank(String owner) {
		dao.deleteB(owner);
	}
	
	public void Cardin(CardVO card) {
		dao.insert(card);
	}
	
	
	public CardVO searchByCard(String owner) {
		CardVO card = dao.searchByCNo(owner);
		return card;
	}
	
	public void deleteCard(String owner) {
		dao.deleteC(owner);
	}

	public List<CardVO> CardAll() {
		List<CardVO> listc = dao.cardAll();
		return listc;
	}
	
	public void Balancein(BalanceVO balance) {
		}
	
	public BalanceVO searchByBal(String owner) {
		BalanceVO balance = dao.searchByBal(owner);
		return balance;
	}
	
	public void updateBank(BalanceVO balance) {
		// balance 테이블에 거래금액을 삽입
		dao.insert(balance);
		// bank테이블에 잔액을 거래금액을 이용하여 수정
		switch(balance.getName()) {
		case "1" : 
			dao.updateMoney(balance.getMoney(), balance.getOwner());
			break;
		case "2" : 
			dao.updateMoney(-balance.getMoney(), balance.getOwner());
			break;
		case "3" :
			dao.updateMoney(balance.getMoney(), balance.getOwner());
			break;
		case "4" : 
			dao.updateMoney(-balance.getMoney(), balance.getOwner());
			break;
		case "5" :
			dao.updateMoney(-balance.getMoney(), balance.getOwner());
			break;
		case "6" : 
			dao.updateMoney(balance.getMoney(), balance.getOwner());
			break;
		}
	}
	
	public List<BalanceVO> balanceAll (String owner) {
		List<BalanceVO> balanceall = dao.balanceAll(owner);
		return balanceall;
	}
	
	public void signUp(UserVO user) {
		dao.signUp(user);
	}
	
	public void deleteID(String id) {
		dao.deleteID(id);
	}
	
	public List<UserVO> UserAll() {
		List<UserVO> list = dao.UserAll();
		return list;
	}

}
