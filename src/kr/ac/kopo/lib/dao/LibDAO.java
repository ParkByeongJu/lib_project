package kr.ac.kopo.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.lib.util.ConnectionFactory;
import kr.ac.kopo.lib.vo.MemberVO;

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
	
	public MemberVO IdSearch(String rrm) {
		
		MemberVO member = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id from t_member where rrm = ?");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
		){
			pstmt.setString(1, rrm);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				
				member = new MemberVO(id);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
}

