package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BalanceVO;
import kr.ac.kopo.vo.BankVO;
import kr.ac.kopo.vo.CardVO;
import kr.ac.kopo.vo.UserVO;

public class Dao {
	
	public List<BankVO> BankAll() {
		
		List<BankVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append(" from bank ");
		
		try(
				Connection conn 
					= new ConnectionFactory().getConnection();
				PreparedStatement pstmt 
					= conn.prepareStatement(sql.toString());
			) {
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					int bank = rs.getInt("bank");
					String name = rs.getString("name");
					int money = rs.getInt("money");
					String owner = rs.getString("owner");
					
					BankVO bankvo = new BankVO(bank, name, money, owner);
					list.add(bankvo);
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
	
	public List<CardVO> cardAll() {
			
			List<CardVO> list = new ArrayList<>();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append(" from card ");
			
			try(
					Connection conn 
						= new ConnectionFactory().getConnection();
					PreparedStatement pstmt 
						= conn.prepareStatement(sql.toString());
				) {
					
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						int bank = rs.getInt("card");
						String name = rs.getString("name");
						String owner = rs.getString("owner");
						
						CardVO cardlist = new CardVO(bank, name, owner);
						list.add(cardlist);
					}
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				return list;
			}
	
	public void insert(BankVO bankIN) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into bank(bank, name, money, owner) ");
		sql.append(" values(?, ?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, bankIN.getBank());
			pstmt.setString(2, bankIN.getName());
			pstmt.setInt(3, bankIN.getMoney());
			pstmt.setString(4, bankIN.getOwner());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void insert(CardVO cardIN) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into card(card, name, owner) ");
		sql.append(" values(?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, cardIN.getCard());
			pstmt.setString(2, cardIN.getName());
			pstmt.setString(3, cardIN.getOwner());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public BankVO searchByBNo(String owner) {
		StringBuilder sql = new StringBuilder();
		sql.append("select bank, name, money, owner ");
		sql.append("  from bank ");
		sql.append(" where owner = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, owner);
				
				ResultSet rs= pstmt.executeQuery();
				if(rs.next()) {
					int bank = rs.getInt("bank");
					String name = rs.getString("name");
					int money = rs.getInt("money");
					String ownerB = rs.getString("owner");
					BankVO bankvo = new BankVO(bank, name, money, ownerB);
					return bankvo;
				}
				
			}catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
	
	public CardVO searchByCNo(String owner) {
		StringBuilder sql = new StringBuilder();
		sql.append("select card, name, owner");
		sql.append("  from card ");
		sql.append(" where owner = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, owner);
				
				ResultSet rs= pstmt.executeQuery();
				if(rs.next()) {
					int card = rs.getInt("card");
					String name = rs.getString("name");
					String ownerC = rs.getString("owner");
					CardVO cardvo = new CardVO(card, name, ownerC);
					return cardvo;
				}
				
			}catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
	
	public void deleteB(String owner) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from bank ");
		sql.append(" where owner = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setString(1, owner);
				pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteC(String owner) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from card ");		
		sql.append(" where owner = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setString(1, owner);
				pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(BalanceVO balance) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into balance(owner, name, balance_date, money, no ) ");
		sql.append(" values(?,?,to_date(?,'yy/mm/dd'), ?, seq_balance_no.nextval)");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, balance.getOwner());
				pstmt.setString(2, balance.getName());
				pstmt.setString(3, balance.getBalacne_date());
				pstmt.setInt(4, balance.getMoney());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public BalanceVO searchByBal(String owner) {
		StringBuilder sql = new StringBuilder();
		sql.append("select to_char(balance.balance_date, 'yy/mm/dd') as balance_date, balance.name, balance.money, balance.owner ");
		sql.append(" from balance join bank on balance.owner = bank.owner ");
		sql.append(" where balance.owner =  ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, owner);
				
				ResultSet rs= pstmt.executeQuery();
				if(rs.next()) {
					String date = rs.getString("balance_date");
					String name = rs.getString("name");
					int money = rs.getInt("money");
					String ownerB = rs.getString("owner");
					BalanceVO balance = new BalanceVO(date, name, money, ownerB);
					return balance;
				}
				
			}catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * bank테이블의 잔액을 거래금액에 따라 수정하는 기능
	 */
	public void updateMoney(int money, String owner) {
		StringBuilder sql = new StringBuilder();
		sql.append("update bank ");
		sql.append("   set money = money + ? ");
		sql.append(" where owner = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setInt(1, money);
			pstmt.setString(2, owner);
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//insert된 balance 금액 모두 출력
	public List<BalanceVO> balanceAll(String owner) {
		
		List<BalanceVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, to_char(balance_date, 'yy/mm/dd') as balance_date, name, money, owner ");
		sql.append(" from balance ");
		sql.append(" where owner = ? ");
		sql.append(" order by no ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, owner);
				
				ResultSet rs= pstmt.executeQuery();
				while(rs.next()) {
					int no = rs.getInt("no");
					String date = rs.getString("balance_date");
					String name = rs.getString("name");
					int money = rs.getInt("money");
					String ownerB = rs.getString("owner");
					BalanceVO balance = new BalanceVO(no, date, name, money, ownerB);
					list.add(balance); 
					}
				
			}catch (Exception e) {
				e.printStackTrace();
		}
		
		return list;
		
	}
	
	public void signUp(UserVO user) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into id(name, password) ");
		sql.append(" values(?, ?)");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, user.getName());
				pstmt.setInt(2, user.getPassword());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static String id(UserVO user) {
		List<UserVO> list = new ArrayList<UserVO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select name, password ");
		sql.append(" from id ");
		sql.append(" where name = ?");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, user.getName());
			
			
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				
				String owner = rs.getString("name");
				return owner;
				
			} catch (Exception e) {
			}
		return null;
	}
	public static int pw(UserVO user) {
		StringBuilder sql = new StringBuilder();
		sql.append("select name, password ");
		sql.append(" from id ");
		sql.append(" where password = ?");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setInt(1, user.getPassword());
			
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				
				int pw = rs.getInt("password");

				return pw;
				
			} catch (Exception e) {
			}
		return 0;
	}
	
	public void deleteUP(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("declare; ");
		sql.append(" deleted_value varchar2(100); ");
		
		sql.append(" begin");
		sql.append("delete from balance where no = ? ; ");		
		sql.append(" set deleted_value = ( select no from balance where no = ? ); ");
		sql.append(" update balance set no = deleted_value where no = ? ; ");
		sql.append(" end; ");
		
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setInt(1, no);
				pstmt.setInt(2, no);
				pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteID(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from id where name = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setString(1, id);
				pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public List<UserVO> UserAll() {
			
			List<UserVO> list = new ArrayList<>();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append(" from id ");
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
					
					ResultSet rs= pstmt.executeQuery();
					while(rs.next()) {
						
						String name = rs.getString("name");
						int pw = rs.getInt("password");
						
						UserVO user = new UserVO(name, pw);
						list.add(user); 
						}
					
				}catch (Exception e) {
					e.printStackTrace();
			}
			
			return list;
			
		}
	
	}

