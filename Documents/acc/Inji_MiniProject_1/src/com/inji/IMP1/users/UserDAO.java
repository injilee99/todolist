package com.inji.IMP1.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Inji.lee.db.manager.InjiDBManager;

public class UserDAO {
	private static final UserDAO UDAO = new UserDAO();
	
	private UserDAO() {
	}
	
	public static UserDAO getUdao() {
		return UDAO;
	}
	
	public ArrayList<User> get() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
			
			String sql = "select * from Users";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<User> users = new ArrayList<User>();
			while (rs.next()) {
				users.add(
						new User(
								rs.getString("user_id"),
								rs.getString("user_name"),
								rs.getDate("user_birth")
								)
						);
			}
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			InjiDBManager.disconnect(con, pstmt, null);
		}
	}
	
	public String reg (User u) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
			
			String sql = "insert into users values(?, ?, to_date(?, 'YYMMDD'))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getId());
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getBirth2());
			
			if (pstmt.executeUpdate() == 1) {
				return "등록 성공";
			}
			return "등록 실패";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "등록 실패";
		} finally {
			InjiDBManager.disconnect(con, pstmt, null);
		}
	}
	
	public String delete (User u) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
			
			String sql = "delete from users where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getId());
			
			if (pstmt.executeUpdate() == 1) {
				return "삭제 성공";
			}
			return "삭제 실패";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "삭제 실패";
		} finally {
			InjiDBManager.disconnect(con, pstmt, null);
		}
	}
	
	public void update (User u) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
			
			String sql = "select * from users where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getId());
			rs = pstmt.executeQuery();
			
			update2(u);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			InjiDBManager.disconnect(con, pstmt, rs);
		}
	}
			
		public String update2(User u) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
				
				String sql = "update users set user_name = ?, user_birth = ? where user_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, u.getName());
				pstmt.setString(2, u.getBirth2());
				pstmt.setString(3, u.getId());
				
				if (pstmt.executeUpdate() >= 1) {
					return "수정 성공";
			}
			return "수정 실패";
		} catch (Exception e) {
			e.printStackTrace();
			return "수정 실패";
		} finally {
			InjiDBManager.disconnect(con, pstmt, null);
		}
	}
	
	
}
