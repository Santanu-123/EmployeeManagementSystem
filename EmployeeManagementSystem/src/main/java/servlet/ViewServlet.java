package servlet;
import java.io.IOException;
import java.util.List;

import db.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

public class ViewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	    
	    List<Employee> employees = EmployeeDao.findAllEmployee();
	    
	    // Set the number of employees as an attribute
	    request.setAttribute("employeeCount", employees.size());
	    for (int i = 0; i < employees.size(); i++) {
	        Employee e = employees.get(i);
	        request.setAttribute("eId" + i, e.getId());
	        request.setAttribute("eName" + i, e.getName());
	        request.setAttribute("eContact" + i, e.getContact());
	    }
	    
	    request.getRequestDispatcher("All.jsp").forward(request, response);
	}

}