package dogShelter;

import java.sql.*;

public class ShelterDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void connect() {
		conn = DBC.DBConnect();
	}
	
	public void conClose() {
		try {
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public void logIn(String sId, String sPw) {
		
		
	}

	public void dogMenu() {
		
		
	}

	public void memberJoin(ShelterDTO shelter) {
		
		
	}

	public boolean idCheck(String sId, String sPw) {
		// TODO Auto-generated method stub
		return false;
	}

	public void dogList() {
		// TODO Auto-generated method stub
		
	}

	public void dogListByBreed(String breed) {
		// TODO Auto-generated method stub
		
		
	}

	public void donation(int money) {
		// TODO Auto-generated method stub
		
	}
}