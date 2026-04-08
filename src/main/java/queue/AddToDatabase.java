package queue;

import java.io.BufferedReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Patients.Patient;
import Patients.PatientServices;
/**
 * Servlet implementation class AddToDatabase
 */
@WebServlet("/AddToDatabase")
public class AddToDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToDatabase() {
        super();
        // TODO Auto-generated constructor stub E:\Java Projects\mysql-connector-j-9.1.0\mysql-connector-j-9.1.0.jarcom.mysql.cj.jdbc.Driver
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServletContext context = getServletContext();
		PatientServices s =(PatientServices) context.getAttribute("PatientServices");
		Patient p = s.removeFirstPatient();
		
		
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				
				
				// try to add database configuration to external XML file to separate it from the compiled code hence its change will be smooth 
				
				Connection connect = DriverManager.getConnection(context.getInitParameter("DB_URL"), context.getInitParameter("DB_Username"), context.getInitParameter("DB_Password"));
								
				String query = "INSERT INTO patients_data (name, status, price) VALUES (?, ?, ?)";

				String name = p.getPatientName();
				String status = p.getPatientStatus();
				int price = s.getServicePrice(p.getStatusAsInteger());
				
				PreparedStatement ps = connect.prepareStatement(query);
				ps.setString(1, name);  
			    ps.setString(2, status);  
			    ps.setInt(3, price);  
			    
				int executed = ps.executeUpdate();
				System.out.print("Row Affected: "+ executed);
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader r = request.getReader();
		for (String res = r.readLine(); res != null; res = r.readLine())
		     System.out.print(res);
	}

}
