package com.inji.IMP1.tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Inji.lee.db.manager.InjiDBManager;

public class TaskDAO {
	private static final TaskDAO TDAO = new TaskDAO();
	
	private TaskDAO() {
	}
	
	public static TaskDAO getTdao() {
		return TDAO;
	}
	
	public ArrayList<Task> get() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
			
			String sql = "select * from Tasks";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Task> tasks = new ArrayList<Task>();
			while (rs.next()) {
				tasks.add(
						new Task(
								rs.getString("t_user_id"),
								rs.getInt("t_no"),
								rs.getString("t_title"),
								rs.getString("t_description"),
								rs.getString("t_status"),
								rs.getString("t_priority"),
								rs.getDate("t_startdate"),
								rs.getDate("t_duedate")
								)
						);
			}
			return tasks;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			InjiDBManager.disconnect(con, pstmt, rs);
		}
	}
	
	public String reg (Task t) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
			
			String sql = "Insert into tasks values(tasks_seq.nextval, ?, ?, ?, ?, to_date(?, 'YYMMDD'), to_date(?, 'YYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getTitle());
			pstmt.setString(2, t.getDescription());
			pstmt.setString(3, t.getStatus());
			pstmt.setString(4, t.getPriority());
			pstmt.setString(5, t.getStartdate2());
			pstmt.setString(6, t.getDuedate2());
			pstmt.setString(7, t.getUser_id());
			
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
	
	public String delete (Task t) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
			
			String sql = "delete from tasks where t_user_id = ? and t_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getUser_id());
			pstmt.setInt(2, t.getNo());
			
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
	
	public void update (Task t) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
			
			String sql = "select * from tasks where t_user_id = ? and t_no =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getUser_id());
			pstmt.setInt(2, t.getNo());
			rs = pstmt.executeQuery();
			
			update2(t);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			InjiDBManager.disconnect(con, pstmt, rs);
		}
	}
			
		public String update2(Task t) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
				
				String sql = "update tasks set t_title = ?, t_description = ?, t_priority = ?, t_startdate = ?, t_duedate = ? where t_user_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, t.getTitle());
				pstmt.setString(2, t.getDescription());
				pstmt.setString(3, t.getPriority());
				pstmt.setString(4, t.getStartdate2());
				pstmt.setString(5, t.getDuedate2());
				pstmt.setString(6, t.getUser_id());
				
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
		
		public void status (Task t) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
				
				String sql = "select * from tasks where t_user_id = ? and t_no =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, t.getUser_id());
				pstmt.setInt(2, t.getNo());
				rs = pstmt.executeQuery();
				
				status2(t);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				InjiDBManager.disconnect(con, pstmt, rs);
			}
		}
				
		public String status2(Task t) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = InjiDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "inji", "0000");
				
				String sql = "update tasks set t_status = ? where t_no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, t.getStatus());
				pstmt.setInt(2, t.getNo());
				
				if (pstmt.executeUpdate() == 1) {
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
