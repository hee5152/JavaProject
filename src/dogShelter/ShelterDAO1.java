package dogShelter;

import java.sql.*;

public class ShelterDAO1 {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void connect() {
		conn = DBcon.DBConnect();
	}
	
	public void conClose() {
		try {
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public void dogMenu() {
		
		
	}

	public void memberJoin(ShelterDTO shelter) {
		
		
	}

	public boolean idCheck(String sId, String sPw) {
		String sql = "SELECT SID FROM SHELTER WHERE SID=? AND SPW=?";
		boolean checkResult = false;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, sId);
			pstmt.setNString(2, sPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				checkResult = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
		
		return checkResult;
	}

	public void donation(int money) {
		
	}

	public void dogListByBreed(String breed) {
		String sql = "SELECT * FROM SHELTER WHERE BREED = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, breed);
			rs = pstmt.executeQuery(); 
			
			int i=0;
			while(rs.next()) {	
				
				System.out.println(i+"踰덉㎏ 媛뺤븘吏� �젙蹂�");
				System.out.println("怨듦퀬踰덊샇 : " + rs.getString(1));
				System.out.println("�씠由� : " + rs.getString(2));
				System.out.println("異붿젙�굹�씠 : " + rs.getString(3));
				System.out.println("�뭹醫� : " + rs.getString(4));
				System.out.println("�꽦蹂� : " + rs.getString(5));
				System.out.println("�젒�닔�씪�옄 : " + rs.getString(6));
				System.out.println();
				i++;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
		
	}

	public void dogList() {
		String sql = "SELECT * FROM SHELTER";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			
			int i=0;
			while(rs.next()) {	
				
				System.out.println(i+"踰덉㎏ 媛뺤븘吏� �젙蹂�");
				System.out.println("怨듦퀬踰덊샇 : " + rs.getString(1));
				System.out.println("�씠由� : " + rs.getString(2));
				System.out.println("異붿젙�굹�씠 : " + rs.getString(3));
				System.out.println("�뭹醫� : " + rs.getString(4));
				System.out.println("�꽦蹂� : " + rs.getString(5));
				System.out.println("�젒�닔�씪�옄 : " + rs.getString(6));
				System.out.println();
				i++;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
		
	}
}