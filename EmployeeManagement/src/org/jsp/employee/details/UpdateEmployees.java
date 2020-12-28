package org.jsp.employee.details;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.employee.dao.EmployeeDAO;
import org.jsp.employee.entity.Employee;

@WebServlet("/UpdateEmployees")
public class UpdateEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		String loginname = req.getParameter("name");
		String password = req.getParameter("password");
		String username = req.getParameter("un");
		String country = req.getParameter("country");

		Employee e = new Employee();
		e.setId(id);
		e.setName(loginname);
		e.setPassword(password);
		e.setUsername(username);
		e.setCountry(country);

		int status = EmployeeDAO.update(e);
		if (status > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("ViewEmployee");
			rd.forward(req, resp);
			// resp.sendRedirect("ViewServlet");
		} else {
			out.println("Sorry! Unable to Update Employee Data");
		}
		out.close();
	}

}
