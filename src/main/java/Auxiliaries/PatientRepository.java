package Auxiliaries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;

public class PatientRepository {

	private static final String INSERT_PATIENT =
			"INSERT INTO patients_data (name, status, price) VALUES (?, ?, ?)";

	private final String url;
	private final String username;
	private final String password;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public PatientRepository(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static PatientRepository from(ServletContext context) {
		return new PatientRepository(
				context.getInitParameter("DB_URL"),
				context.getInitParameter("DB_Username"),
				context.getInitParameter("DB_Password"));
	}

	public int insertPatient(String name, String status, int price) {
		try (Connection connect = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = connect.prepareStatement(INSERT_PATIENT)) {
			ps.setString(1, name);
			ps.setString(2, status);
			ps.setInt(3, price);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
