package queue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Auxiliaries.PatientRepository;
import Patients.Patient;
import Patients.PatientServices;

/**
 * Servlet implementation class AddToDatabase
 */
@WebServlet("/AddToDatabase")
public class AddToDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToDatabase() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED,
				"Use PUT to add patient data to the database.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED,
				"Use PUT to add patient data to the database.");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		addPatientToDatabase();
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().append("Patient added to database.");
	}

	private void addPatientToDatabase() {
		PatientServices s = (PatientServices) getServletContext().getAttribute("PatientServices");
		Patient p = s.removeFirstPatient();

		int price = s.getServicePrice(p.getStatusAsInteger());
		PatientRepository repository = PatientRepository.from(getServletContext());
		int executed = repository.insertPatient(p.getPatientName(), p.getPatientStatus(), price);
		System.out.print("Row Affected: " + executed);
	}

}
