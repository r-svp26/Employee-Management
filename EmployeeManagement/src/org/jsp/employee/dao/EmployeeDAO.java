package org.jsp.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsp.employee.entity.Employee;

public class EmployeeDAO {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspiders?user=root&password=admin");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static int save(Employee emp) {
		int status = 0;
		try {
			Connection conn = EmployeeDAO.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into employee (id,loginname,password,username,country) values(?,?,?,?,?)");
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getPassword());
			pstmt.setString(4, emp.getUsername());
			pstmt.setString(5, emp.getCountry());
			status = pstmt.executeUpdate();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	public static int update(Employee emp) {
		int status = 0;
		try {
			Connection conn = EmployeeDAO.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("update employee set loginname=?,password=?,username=?,country=? where id=?");
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getPassword());
			pstmt.setString(3, emp.getUsername());
			pstmt.setString(4, emp.getCountry());
			pstmt.setInt(5, emp.getId());
			status = pstmt.executeUpdate();
			conn.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection conn = EmployeeDAO.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("delete from employee where id=?");
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	public static Employee getEmployeeId(int id) {
		Employee emp = new Employee();
		try {
			Connection conn = EmployeeDAO.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from employee where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setUsername(rs.getString(4));
				emp.setCountry(rs.getString(5));
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return emp;
	}

	public static List<Employee> getAllEmployee() {
		List<Employee> lst = new ArrayList<Employee>();
		try {
			Connection conn = EmployeeDAO.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from employee");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setUsername(rs.getString(4));
				emp.setCountry(rs.getString(5));
				lst.add(emp);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return lst;
	}

}
