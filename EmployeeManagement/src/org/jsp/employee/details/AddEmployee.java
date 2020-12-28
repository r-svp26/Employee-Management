package org.jsp.employee.details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.employee.dao.EmployeeDAO;
import org.jsp.employee.entity.Employee;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String username = req.getParameter("un");
		String eid = req.getParameter("id");
		int id = Integer.parseInt(eid);
		String country = req.getParameter("country");

		Employee emp = new Employee();
		emp.setName(name);
		emp.setPassword(password);
		emp.setUsername(username);
		emp.setId(id);
		emp.setCountry(country);

		int status = EmployeeDAO.save(emp);
		if (status > 0) {
			out.print("<h1>Employee Registration successfull</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			out.println("Sorry! Employee Registration is Failed.");
		}

		out.close();

	}

}
