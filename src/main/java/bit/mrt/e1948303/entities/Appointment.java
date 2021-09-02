package bit.mrt.e1948303.entities;

import org.springframework.stereotype.Component;

@Component
public class Appointment {
	
	private int id;
	private int reference_number;
	private String student_index_number;
	private boolean is_canceled;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReference_number() {
		return reference_number;
	}
	public void setReference_number(int reference_number) {
		this.reference_number = reference_number;
	}
	public String getStudent_index_number() {
		return student_index_number;
	}
	public void setStudent_index_number(String student_index_number) {
		this.student_index_number = student_index_number;
	}
	
	public boolean getIs_canceled() {
		return is_canceled;
	}
	public void setIs_canceled(boolean is_canceled) {
		this.is_canceled = is_canceled;
	}
	
	public boolean cancelAppointment() {
		this.is_canceled = true;
		return this.is_canceled;
	}
	
}
