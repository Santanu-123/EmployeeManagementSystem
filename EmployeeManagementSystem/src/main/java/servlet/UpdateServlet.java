package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import db.EmployeeDao;

public class UpdateServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = EmployeeDao.getEmployeeById(id);

        if (employee != null) {
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("Update.jsp").forward(request, response);
        } else {
            response.sendRedirect("NotFound.jsp");
        }
    }
}
