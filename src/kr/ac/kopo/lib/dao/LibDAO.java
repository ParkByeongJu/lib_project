package kr.ac.kopo.lib.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.lib.ui.LibUI;
import kr.ac.kopo.lib.util.ConnectionFactory;
import kr.ac.kopo.lib.vo.BookVO;
import kr.ac.kopo.lib.vo.MemberVO;

public class LibDAO {
	
	public LibDAO() {
		
	}
	
	public void insertMember(MemberVO member) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id, password, name, birth, email, phone) ");
		sql.append(" values(?, ?, ?, ?, ?, ?); ");
		
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
	
	public void bookRent(String bookname) {
	    StringBuilder sql = new StringBuilder();
	    sql.append("INSERT INTO T_Rental (rental_id, book_name, member_id, rental_date, return_date) VALUES (seq_t_rental, ?, ?, to_char(sysdate, 'yyyy-mm-dd'), to_char(sysdate, 'yyyy-mm-dd')+14) ");
	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ){
	        pstmt.setString(1, bookname);
	        pstmt.setString(2, LibUI.loginUser);
	        pstmt.execute();
	        System.out.println("------------------------------------------");
	        System.out.println("\t   책 대여가 완료되었습니다");
	        System.out.println("------------------------------------------");
	        LibUI libui = new LibUI();
	        libui.execute();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
}



