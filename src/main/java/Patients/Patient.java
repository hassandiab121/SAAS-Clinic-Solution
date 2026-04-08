package Patients;

public class Patient {
	private String name;
	private int status;
	
	
	public Patient(String name, int status){
		this.name = name;
		this.status = status;
	}
	
	public String getPatientName(){
		return name.toString();
	}
	
	public String getPatientStatus() {
		if (this.status == 0)
			return "كشف جديد";
		else
			return "إعادة";
	}
	
	public int getStatusAsInteger() {
		return this.status;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append("\t");
		sb.append(this.getPatientStatus());
		
		return sb.toString();
	}
	
	

}
