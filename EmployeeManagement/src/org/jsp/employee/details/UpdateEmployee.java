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

@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<body bgcolor='#6495ed'>" + "<h1>Update Employee</h1>");
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);

		Employee e = EmployeeDAO.getEmployeeId(id);

		out.print("<form action='UpdateEmployees' method='post'>");

		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td><td>");
		out.print("<tr><td>LoginName:</td><td>");
		out.print("<input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
		out.print("<tr><td>Password:</td><td>");
		out.print("<input type='password' name='password' value='" + e.getPassword() + "'/></td></tr>");
		out.print("<tr><td>UserName:</td><td>");
		out.print("<input type='text' name='un' value='" + e.getUsername() + "'/></td></tr>");

		// out.print("</td></tr>");

		out.print("<tr><td>Country:</td><td>");
		out.print("<select name='country' style='width:150px'>");
		out.print("<option>Select Country</option>");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>Uk</option>");
		out.print("<option>Others</option>");

		out.print("</select>");
		out.print("</td></tr>");

		out.print("<tr><td colspan='2'><input type='submit' value='Edit & apply; save'/></td></tr>");
		out.print("</table>");
		out.print("</form></body>");
		out.close();

     }

}
