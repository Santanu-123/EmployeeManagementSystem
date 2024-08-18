package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import db.EmployeeDao;

public class UpdateServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Long contact = Long.parseLong(request.getParameter("contact"));
        
        // Testing
        System.out.println("Received values - ID: " + id + ", Name: " + name + ", Contact: " + contact);

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setContact(contact);
        
        System.out.println("Employee Object - ID: " + employee.getId() + ", Name: " + employee.getName() + ", Contact: " + employee.getContact());

        int status = EmployeeDao.update(employee);

        if (status > 0) {
        	System.out.println("Update successful. Status: " + status);
            response.sendRedirect("getById?id="+employee.getId());
        } else {
        	System.out.println("Update failed. Status: " + status);
            response.sendRedirect("NotFound.jsp");
        }
    }
}
