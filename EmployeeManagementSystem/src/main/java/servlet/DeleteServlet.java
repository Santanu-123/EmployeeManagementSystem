package servlet;

import java.io.IOException;

import db.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = EmployeeDao.getEmployeeById(id);
		
		if(employee != null) {
			request.setAttribute("employee", employee);
            request.getRequestDispatcher("Delete.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("NotFound.jsp").include(request, response);
		}
		
		
	}
}
