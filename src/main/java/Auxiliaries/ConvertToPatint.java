package Auxiliaries;

import java.io.BufferedReader;
import java.io.IOException;

import Patients.Patient;

public class ConvertToPatint {
	public static Patient convert(BufferedReader bf) throws IOException {
		String patientName = (String) bf.readLine();
        String status = (String) bf.readLine();
        Patient p = new Patient(patientName, Integer.parseInt(status));
        
		return p;
		}

}
