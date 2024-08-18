package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class EmployeeDao {
	
	public static String driverName = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/employee_management";
	public static String userName = "root";
	public static String password = "Arijit@123";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static int save(Employee employee) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into employee "
					+ "(name, contact) values (?, ?)");
			
			ps.setString(1, employee.getName());
			ps.setLong(2, employee.getContact());
			
			status = ps.executeUpdate();
			con.close();
			
            // Only for testing purposes
//            System.out.println("Employee saved: " + employee.getName() + ", " + employee.getContact());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public static int update(Employee employee) {
		int status = 0;
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement("update employee set name=?,"
					+ "contact=? where id=?");
			
			ps.setString(1, employee.getName());
			ps.setLong(2, employee.getContact());
			ps.setInt(3, employee.getId());
			
			status = ps.executeUpdate();		
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public static int delete(int id) {
		int status = 0;
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from employee where id=?");
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
			con.close();
			
			System.out.println("Delete Status: " + status+" "+id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public static Employee getEmployeeById(int id) {
		Employee employee = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getInt("id");
                String name = rs.getString("name");
                long contact = rs.getLong("contact");
				
				employee = new Employee(id, name, contact);
				
				//Print data for testing
//				System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getContact());
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return employee;
	}
	
	public static List<Employee> findAllEmployee() {
		List<Employee> emp = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
//				Employee employee = new Employee();
//				employee.setId(rs.getInt("id"));
//				employee.setName(rs.getString("name"));
//				employee.setContact(rs.getLong("contact"));
//				
				int id = rs.getInt("id");
                String name = rs.getString("name");
                long contact = rs.getLong("contact");
				
				Employee employee = new Employee(id, name, contact);
				emp.add(employee);
			}
            // Print data for testing
//            for (Employee empl : emp) {
//                System.out.println("Employee ID: " + empl.getId() + ", Name: " + empl.getName() + ", Contact: " + empl.getContact());
//            }
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return emp;
	}
}
