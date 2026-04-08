package queue;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Patients.Patient;
import Patients.PatientServices;
import Auxiliaries.ConvertToPatint;
/**
 * Servlet implementation class queue
 */
@WebServlet("/queue")
public class queue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// set the main data structure as static to give the capability for all instances to reach and modify coherently.
	private static PatientServices s = new PatientServices();
 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("user") == null) 
			response.sendRedirect("LoginAndDispatch");
		else
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
				
		}
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext context = getServletContext();
		context.setAttribute("PatientServices", s);
		
		// we accept a row requests, So we make a small function which acts as a mapper for patient Datatype . 
		Patient patient = ConvertToPatint.convert(request.getReader());
		
		s.setNewDiagnosticPrice(100);
        s.setReDiagnosticPrice(50);
        
        // Set response content 
        s.addPatient(patient);
        for (Patient p : s.getPatients())
        {
        	System.out.println(p);
        }
        System.out.println(s.getNumberOfFollowUPPatients()+s.getNumberOfNewPatient());
        System.out.println("total Revenue: " + s.getTotalRevnue());
        System.out.print("\n\n");
        response.setContentType("text/plain");
        response.getWriter().print(s.getTotalRevnue());
        
	}

}
