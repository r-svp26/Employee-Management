package org.jsp.employee.validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jsp.employee.dao.EmployeeDAO;

public class ValidateEmployee {

	static Connection conn = null;
	static PreparedStatement pstmt = null;

	public static boolean checkUser(String name, String pwd) {
		boolean st = false;
		conn = EmployeeDAO.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from employee where loginname=? and password=?");
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);

			ResultSet rs = pstmt.executeQuery();
			st = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

}
