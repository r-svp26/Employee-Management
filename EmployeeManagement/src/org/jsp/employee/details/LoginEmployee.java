package org.jsp.employee.details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.employee.validate.ValidateEmployee;

@WebServlet("/LoginEmployee")
public class LoginEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String loginname = req.getParameter("nm");
		String password = req.getParameter("pw");

		if (ValidateEmployee.checkUser(loginname, password)) {
			RequestDispatcher rd = req.getRequestDispatcher("ViewEmployee");
			rd.forward(req, resp);
		} else {
			out.println("Try again! Employee Credential is Invalid.");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
	}

}
