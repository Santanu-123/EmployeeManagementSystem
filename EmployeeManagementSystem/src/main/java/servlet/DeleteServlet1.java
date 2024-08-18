package servlet;

import java.io.IOException;

import db.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

public class DeleteServlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
        
        if(id != 0) {
        	System.out.println("id is: "+id);
    		
    		int status = EmployeeDao.delete(id);
    		
    		if (status > 0) {
            	System.out.println("Delete successful. Status: " + status);
//                response.sendRedirect("getById?id="+employee.getId());
            	request.getRequestDispatcher("view").include(request, response);
            } else {
            	System.out.println("Delete failed. Status: " + status);
                response.sendRedirect("NotFound.jsp");
            }
        }
        else {
        	System.out.println("Id "+id+"not found");
        }
		
	}
}
