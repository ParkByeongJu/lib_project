package kr.ac.kopo.lib.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.lib.ui.AdminUI;
import kr.ac.kopo.lib.ui.LibUI;
import kr.ac.kopo.lib.ui.MypageUI;
import kr.ac.kopo.lib.util.ConnectionFactory;
import kr.ac.kopo.lib.vo.BookVO;
import kr.ac.kopo.lib.vo.MemberVO;
import kr.ac.kopo.lib.vo.RentalBookVO;

public class LibDAO {
	
	public LibDAO() {
		
	}
	
	public void insertMember(MemberVO member) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id, password, name, birth, email, phone) ");
		sql.append(" values(?, ?, ?, ?, ?, ?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int equalID(String Id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt from t_member where id = ? ");
		int cnt = 0;
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, Id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("cnt");
				if(cnt > 0) {
					return 1;
				}
			}
			
		} catch (Exception e) {
		}
		return 0;
	}
	
	public int LoginMember(String id, String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt from t_member where id = ? and password = ? ");
		int cnt = 0;
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("cnt");
				if(cnt > 0) {
					return 1;
				}
			}
			
		} catch (Exception e) {
		}
		return 0;
	}


	public List<BookVO> searchAll() {
		
		List<BookVO> bookList = new ArrayList<>();
		
		BookVO book = null;
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT * FROM t_book");

	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	        ResultSet rs = pstmt.executeQuery();
	    ) {
	        while (rs.next()) {
	            String name = rs.getString("name");
	            String writer = rs.getString("writer");
	            String publisher = rs.getString("publisher");
	            Date store = rs.getDate("store");
	            
	            book = new BookVO(name, writer, publisher, store);
	            bookList.add(book);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return bookList;
	}

	public List<BookVO> searchName(String Name) {
			
		List<BookVO> bookList = new ArrayList<>();
					
		BookVO book = null;
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT * FROM t_book where instr(name, ?) != 0" );

	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	    	pstmt.setString(1, Name);
	    	ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            String name = rs.getString("name");
	            String writer = rs.getString("writer");
	            String publisher = rs.getString("publisher");
	            Date store = rs.getDate("store");
	            
	            book = new BookVO(name, writer, publisher, store);
	            bookList.add(book);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return bookList;
	}
	
	public List<BookVO> searchWriter(String Writer) {
		
		List<BookVO> bookList = new ArrayList<>();
					
		BookVO book = null;
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT * FROM t_book where instr(writer, ?) != 0" );

	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	    	pstmt.setString(1, Writer);
	    	ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            String name = rs.getString("name");
	            String writer = rs.getString("writer");
	            String publisher = rs.getString("publisher");
	            Date store = rs.getDate("store");
	            
	            book = new BookVO(name, writer, publisher, store);
	            bookList.add(book);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return bookList;
	}
	
	public List<BookVO> searchPublisher(String Publisher) {
		
		List<BookVO> bookList = new ArrayList<>();
					
		BookVO book = null;
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT * FROM t_book where instr(publisher, ?) != 0" );

	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	    	pstmt.setString(1, Publisher);
	    	ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            String name = rs.getString("name");
	            String writer = rs.getString("writer");
	            String publisher = rs.getString("publisher");
	            Date store = rs.getDate("store");
	            
	            book = new BookVO(name, writer, publisher, store);
	            bookList.add(book);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return bookList;
	}
	
	public List<RentalBookVO> bookRent(String bookname) throws Exception {
		List<RentalBookVO> rentalBook = new ArrayList<>();
		RentalBookVO rentBook = null;
		
	    StringBuilder sql = new StringBuilder();
	    sql.append("INSERT INTO T_Rental (rental_id, book_name, member_id, rental_date, return_date) ");
	    sql.append("VALUES (seq_t_rental.nextval, ?, ?, to_char(sysdate, 'yyyy-mm-dd'), to_char(sysdate + 14, 'yyyy-mm-dd'))");
	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	    	pstmt.setString(1, bookname);
	        pstmt.setString(2, LibUI.loginUser);
	        pstmt.executeUpdate();
	        
	        String updateSql = "UPDATE T_RENTAL SET rental_status = '대여 중' WHERE book_name = ?";
	        try (PreparedStatement updatePstmt = conn.prepareStatement(updateSql)) {
	            updatePstmt.setString(1, bookname);
	            int rowsUpdated = updatePstmt.executeUpdate();
	            if (rowsUpdated == 0) {
	            	System.out.println("\n==============================================");
	                System.out.println("\t   책 대여에 실패하였습니다. 다시 시도해주세요.");
	                System.out.println("==============================================\n");
	                new MypageUI().execute();
	            } else {
	                String selectSql = "SELECT book_name, member_id, rental_date, return_date, rental_status FROM T_RENTAL WHERE book_name = ?";
	                try (PreparedStatement selectPstmt = conn.prepareStatement(selectSql)) {
	                    selectPstmt.setString(1, bookname);
	                    ResultSet rs = selectPstmt.executeQuery();
	                    while (rs.next()) {
	                        String book_name = rs.getString("book_name");
	                        String member = rs.getString("member_id");
	                        Date rentalDate = rs.getDate("rental_date");
	                        Date returnDate = rs.getDate("return_date");
	                        String rentalStatus = rs.getString("rental_status");
	                        
	                        rentBook = new RentalBookVO(book_name, member, rentalDate, returnDate, rentalStatus);
	                        
	                        rentalBook.add(rentBook);
	                    }
	                   }
	                }
	        }	        
	        
	    } catch (SQLException e) {
	        if (e.getErrorCode() == 2291) {
	        	System.out.println("\n==============================================");
	            System.out.println("\t   존재하지 않는 책입니다. 확인 후 입력해주세요.");
	            System.out.println("==============================================\n");
	        } else if (e.getErrorCode() == 1 && (e.getMessage().contains("SYS_C008377") || e.getMessage().contains("SYS_C008402") || e.getMessage().contains("SYS_C008405"))) {
	        	System.out.println("\n==============================================");
	            System.out.println("\t   대여 중 입니다. 다른 책을 선택해주세요.");
	            System.out.println("==============================================\n");
	        } else {
	            e.printStackTrace();
	        }
	        MypageUI mypage = new MypageUI();
	        mypage.execute();
	    }
		
	    return rentalBook;
	}


	public void bookReturn(String bookname) throws Exception {
	    StringBuilder sql = new StringBuilder();
	    sql.append("DELETE FROM T_Rental WHERE book_name = ? AND member_id = ?");

	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	        pstmt.setString(1, bookname);
	        pstmt.setString(2, LibUI.loginUser);
	        int rowCount = pstmt.executeUpdate();
	        if (rowCount > 0) {
	        	System.out.println("\n==============================================");
	    		System.out.println("\t    도서 반납이 완료되었습니다.\t\t");
	    		System.out.println("==============================================\n");
	        } else {
	        	System.out.println("\n==============================================");
	            System.out.println("\t   해당 책은 대여 중이 아닙니다.");
	            System.out.println("==============================================\n");
	        }
	        new MypageUI().execute();
	    } catch (SQLException e) {
	        if (e.getErrorCode() == 2291) {
	        	System.out.println("\n==============================================");
	            System.out.println("\t존재하지 않는 책입니다. 확인 후 입력해주세요.");
	            System.out.println("==============================================");
	        } else if (e.getErrorCode() == 1 && (e.getMessage().contains("SYS_C008377") || e.getMessage().contains("SYS_C008402"))) {
	        	System.out.println("\n==============================================");
	            System.out.println("\t\t대여 중 입니다. 다른 책을 선택해주세요.");
	            System.out.println("==============================================\n");
	        } else {
	            e.printStackTrace();
	        }
	    }
	}
	
	public List<RentalBookVO> rentalBookList() {
	    List<RentalBookVO> rentalBookList = new ArrayList<>();
	    RentalBookVO book = null;
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT a.name as name ,b.MEMBER_ID as member ,b.RENTAL_DATE as rentalDate ,b.return_date as returnDate ");
	    sql.append(" ,CASE WHEN b.rental_status = '대여 중' THEN '대여 중' ELSE '대여 가능' END AS rentalStatus ");
	    sql.append(" FROM t_book a ");
	    sql.append(" left JOIN t_rental b ");
	    sql.append(" ON b.book_name = a.name ");

	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	        ResultSet rs = pstmt.executeQuery();
	    ) {
	        while (rs.next()) {
	            String name = rs.getString("name");
	            String member = rs.getString("member");
	            Date rentalDate = rs.getDate("rentalDate");  
	            Date returnDate = rs.getDate("returnDate");  
	            String rentalStatus = rs.getString("rentalStatus");

	            book = new RentalBookVO(name, member, rentalDate, returnDate, rentalStatus);
	            rentalBookList.add(book);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return rentalBookList;
	}
	
	public int equalBookName(String name) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt from T_BOOK where name = ? ");
		int cnt = 0;
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("cnt");
				if(cnt > 0) {
					return 1;
				}
			}
			
		} catch (Exception e) {
		}
		return 0; 
	}
	
	public void addBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_book(name, writer, publisher, store) ");
		sql.append(" values(?, ?, ?, to_char(sysdate, 'yyyy-mm-dd')) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delBook(String bookname) throws Exception {
	    StringBuilder sql = new StringBuilder();
	    sql.append("DELETE FROM t_book  ");
	    sql.append(" WHERE name = ? ");
	    sql.append(" AND name not IN (SELECT book_name FROM t_rental) ");

	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	        pstmt.setString(1, bookname);
	        int rowCount = pstmt.executeUpdate();
	        if (rowCount > 0) {
	        	System.out.println("\n==============================================");
	    		System.out.println("\t    도서 삭제가 완료되었습니다.\t\t");
	    		System.out.println("==============================================\n");
	        } else {
	            String checkSql = "SELECT COUNT(*) FROM t_book WHERE name = ?";
	            PreparedStatement checkPstmt = conn.prepareStatement(checkSql);
	            checkPstmt.setString(1, bookname);
	            ResultSet rs = checkPstmt.executeQuery();
	            rs.next();
	            int count = rs.getInt(1);
	            if (count == 0) {
	            	System.out.println("\n==============================================");
	                System.out.println("\t존재하지 않는 책입니다. 확인 후 입력해주세요.");
	                System.out.println("==============================================\n");
	            } else {
	            	System.out.println("\n==============================================");
	                System.out.println("\t해당 책은 대여 중이므로 삭제가 불가합니다.");
	                System.out.println("==============================================\n");
	            }
	            return; 
	        }
	        new AdminUI().execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public int equalPassword(String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt from t_member where password = ? ");
		int cnt = 0;
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("cnt");
				if(cnt > 0) {
					return 1;
				}
			}
			
		} catch (Exception e) {
		}
		return 0;
	}
	
	public void changePassword(String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE T_MEMBER SET password = ? where id = ?");
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, password);
			pstmt.setString(2, LibUI.loginUser);
			pstmt.executeUpdate();
			System.out.println("\n*** Password변경이 완료 되었습니다. ***");
		}catch(Exception e) {
			
		}
	
		
	}

	public void delMember(String password) {
	    StringBuilder sql = new StringBuilder();
	    sql.append("DELETE FROM t_member  ");
	    sql.append(" WHERE id = ? ");
	    sql.append(" AND password = ?");
	    sql.append(" AND id not IN (SELECT member_id FROM t_rental) ");
	    try(
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ){
	        pstmt.setString(1, LibUI.loginUser);
	        pstmt.setString(2, password);
	        int rowCount = pstmt.executeUpdate();
	        if (rowCount > 0) {
	        	System.out.println("\n==============================================");
	    		System.out.println("\t\t회원 탈퇴가 완료되었습니다.\t\t");
	    		System.out.println("==============================================\n");
	        } else {
	        	System.out.println("\n==============================================");
	            System.out.println("   대여 중인 도서가 있습니다. 반납 후 탈퇴를 진행해주세요");
	            System.out.println("==============================================\n");
	            return; 
	        }
	        new LibUI().execute();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}


