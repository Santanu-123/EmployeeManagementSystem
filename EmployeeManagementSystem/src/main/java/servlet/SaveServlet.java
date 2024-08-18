package servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import db.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

public class SaveServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		int status = 0;
		Employee employee = new Employee();
		
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		
		employee.setName(name);
		long contactDetails = Long.parseLong(contact);
		employee.setContact(contactDetails);
		
		status = EmployeeDao.save(employee);
		
		if(status > 0) {
			System.out.println("Employee saved");
			request.setAttribute("name", employee.getName());
			request.setAttribute("contact", employee.getContact());
			request.getRequestDispatcher("Success.jsp").include(request, response);
		}else {
			System.out.println("Cannot save employee");
			request.getRequestDispatcher("Fail.jsp").include(request, response);
		}
		
//		pw.close();
	}

}
