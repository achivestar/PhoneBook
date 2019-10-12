package PhoneBookVer08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneInfoDAO {
	
	Connection con;

	public PhoneInfoDAO(Connection con) {
		this.con = con;
	}

	public int insertPhoneInfo(PhoneInfo info, int choice) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		if(choice==1) {
			String sql = "INSERT INTO phoneBook (name,phoneNum,mayer,year,company,type) VALUES (?,?,?,?,?)";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, info.name);
				pstmt.setString(2, info.phoneNumber);
				pstmt.setString(3, null);
				pstmt.setInt(4,0);
				pstmt.setString(5, null);
				insertCount = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(choice==2) {
			String sql = "INSERT INTO phoneBook (name,phoneNum,mayer,year,company,type) VALUES (?,?,?,?,?)";
			PhoneUnivInfo uni = (PhoneUnivInfo) info;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, info.name);
				pstmt.setString(2, info.phoneNumber);
				pstmt.setString(3, uni.major);
				pstmt.setInt(4,uni.year);
				pstmt.setString(5, null);
				insertCount = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(choice==3) {
			String sql = "INSERT INTO phoneBook (name,phoneNum,mayer,year,company,type) VALUES (?,?,?,?,?)";
			PhoneCompanyInfo comp = (PhoneCompanyInfo) info;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, info.name);
				pstmt.setString(2, info.phoneNumber);
				pstmt.setString(3, null);
				pstmt.setInt(4,0);
				pstmt.setString(5, comp.company);
				insertCount = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return insertCount;
	}


	public boolean isPhoneNum(String phoneNumber) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM phonebook WHERE phoneNum = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneNumber);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch  (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<PhoneBookMember> selectMemberList() {
		
		ArrayList<PhoneBookMember> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM phonebook";
		try {
			pstmt = con.prepareStatement(sql);
			PhoneBookMember member = null;
			memberList = new ArrayList<PhoneBookMember>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new PhoneBookMember(
					rs.getString("name"),
					rs.getString("phoneNum"),
					rs.getString("mayer"),
					rs.getInt("year"),
					rs.getString("company")
				);
				memberList.add(member);
			}
			
			
		} catch  (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	public ArrayList<PhoneBookMember> searchMemberList(String sname) {
		
		ArrayList<PhoneBookMember> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM phonebook where name =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sname);
			PhoneBookMember member = null;
			memberList = new ArrayList<PhoneBookMember>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new PhoneBookMember(
					rs.getString("name"),
					rs.getString("phoneNum"),
					rs.getString("mayer"),
					rs.getInt("year"),
					rs.getString("company")
				);
				memberList.add(member);
			}
			
			
		} catch  (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	public PhoneBookMember selectOldMember(String uNum) {
		PhoneBookMember oldMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM phonebook where phoneNum = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				oldMember = new PhoneBookMember(
						rs.getString("name"),
						rs.getString("phoneNum"),
						rs.getString("mayer"),
						rs.getInt("year"),
						rs.getString("company")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oldMember;
	}

	public int updateMember(PhoneBookMember updateMember) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE phonebook set name=?,phoneNum=?,mayer=?,year=?,company=? where phoneNum = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateMember.getName());
			pstmt.setString(2, updateMember.getPhoneNum());
			pstmt.setString(3, updateMember.getMayer());
			pstmt.setInt(4, updateMember.getYear());
			pstmt.setString(5, updateMember.getCompany());
			pstmt.setString(6, updateMember.getPhoneNum());
			
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateCount;
	}

	public int deleteMember(String dNum) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM phonebook where phoneNum = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dNum);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteCount;
	}



	
}
