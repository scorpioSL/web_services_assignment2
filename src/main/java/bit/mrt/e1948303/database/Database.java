package bit.mrt.e1948303.database;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import bit.mrt.e1948303.entities.Appointment;

@Component
public class Database {
	private List<Appointment> appointmentList = new ArrayList<Appointment>();

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> memory) {
		this.appointmentList = memory;
	}
	
	public void addAppointment(Appointment appointment) {
		this.appointmentList.add(appointment);
	}
	
	public int getNextId() {
		return (this.appointmentList.size() + 1);
	}
	
	public int generateReferenceNumber() {
        return (int) (new Date().getTime()/1000);
    }
	
	public Appointment findById(int id) {
		Appointment find = this.appointmentList.stream().filter(appointment->appointment.getId() == id).findFirst().orElse(null);
		return find;
	}
	
	public Appointment findByIndexNumber(String index) {
		Appointment find = this.appointmentList.stream().filter(appointment->appointment.getStudent_index_number().equals(index)).findFirst().orElse(null);
		return find;
	}
	
	public Appointment findByReference_number(int reference_number) {
		Appointment find = this.appointmentList.stream().filter(appointment->appointment.getReference_number() == reference_number).findFirst().orElse(null);
		return find;
	}
	
	public boolean cancelAppointment(int reference_number) {
		Appointment find = this.findByReference_number(reference_number);
		if(find != null) {
			find.setIs_canceled(true);
			return find.getIs_canceled();
		}
		return false;
	}
	
	public boolean removeAppointmentById(int id) {
		Appointment find = this.findById(id);
		if(find != null) {
			this.appointmentList.remove(find);
			return true;
		}
		return false;
	}
	
	public boolean removeAppointmentByReferenceNumber(int reference_number) {
		Appointment find = this.findByReference_number(reference_number);
		if(find != null) {
			this.appointmentList.remove(find);
			return true;
		}
		return false;
	}
	
	
}
