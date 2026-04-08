package Patients;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PatientServices {
  private List<Patient> patientsList;
  private int numberOfNewPatients = 0;
  private int numberOfFollowUPPatients = 0;
  private int newDiagPrice, reDiagPrice;
  
	  public PatientServices(){
		  patientsList = new LinkedList<>();
	  }  // non-parameterized constructor
	  
	  public void addPatient(Patient p) {
		  
		  if (patientsList.add(p) == true) 
		  {
			  if (p.getStatusAsInteger() == 0)
				  numberOfNewPatients++;
			  else 
				  numberOfFollowUPPatients++;
		  }
		  else
			  throw new Error("Error with adding new patient!");
			  
	  }
	  
	  public int getNumberOfNewPatient() {
		  return this.numberOfNewPatients;
	  } 
	  
	  public int getNumberOfFollowUPPatients() {
		  return this.numberOfFollowUPPatients;
	  } 
	  
	  public void setNewDiagnosticPrice(int price) {
			this.newDiagPrice = price;
		}
		
		public void setReDiagnosticPrice(int price) {
			this.reDiagPrice = price;
		}
		
		public int getTotalRevnue() {
		  return ( numberOfNewPatients * newDiagPrice ) + (numberOfFollowUPPatients * reDiagPrice);
		}
	  
	  
	  public Iterable<Patient> getPatients() {
		  ArrayList<Patient> copyList = new ArrayList<>(this.patientsList); 
		  return copyList;
	  }
	  
	  public int getServicePrice(int status) throws Exception{
		  if (status > 1 || status < 0)
			  throw new Exception("status is above bounds > 1 or below bounds < 0");
		  else return status == 0 ? newDiagPrice : reDiagPrice; 
	  }
	  
	  public Patient removeFirstPatient(){
		  return patientsList.remove(0);
		
	  }
	  
	  
	  
  }
