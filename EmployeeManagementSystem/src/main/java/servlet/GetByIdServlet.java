package servlet;

import java.io.IOException;

import db.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

public class GetByIdServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = EmployeeDao.getEmployeeById(id);

        if (employee != null) {
            request.setAttribute("employee", employee);		//explain
            System.out.println("Id: "+employee.getId()+"Name: "+employee.getName()+"Contact: "+employee.getContact());
            request.getRequestDispatcher("Get.jsp").forward(request, response);
        } else {
            response.sendRedirect("NotFound.jsp");
        }
    }
}
