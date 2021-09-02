package bit.mrt.e1948303.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.mrt.e1948303.database.Database;
import bit.mrt.e1948303.entities.Appointment;
import java.util.List;

@Service
public class AppointmentService {

	@Autowired
	private Database database;

//	Adding appointment for the default student
	public String bookDefaultAppointment() {
		Appointment existing = this.database.findByIndexNumber("e1948303");
		if (existing == null) {
			Appointment newAppointment = new Appointment();
			newAppointment.setId(database.getNextId());
			newAppointment.setReference_number(database.generateReferenceNumber());
			newAppointment.setStudent_index_number("e1948303");
			newAppointment.setIs_canceled(false);
			this.database.addAppointment(newAppointment);
			return "Your appointment is successful. Reference number is " + newAppointment.getReference_number();
		}

		return "You already have an appointment. Reference number is " + existing.getReference_number();
	}
	
//	Adding appointment for the dynamic student
	public String bookAppointment(String index_number) {
		
		Appointment existing = this.database.findByIndexNumber(index_number);
		if (existing == null) {
			Appointment newAppointment = new Appointment();
			newAppointment.setId(database.getNextId());
			newAppointment.setReference_number(database.generateReferenceNumber());
			newAppointment.setStudent_index_number(index_number);
			newAppointment.setIs_canceled(false);
			this.database.addAppointment(newAppointment);
			return "Your appointment is successful. Reference number is " + newAppointment.getReference_number();
		}

		return "You already have an appointment. Reference number is " + existing.getReference_number();
	}

//	Retrieving all the appointments
	public List<Appointment> getAllAppointments() {
		return this.database.getAppointmentList();
	}

//	Cancel an appointment by reference number
	public boolean cancelAppointment(int reference_number) {
		return this.database.cancelAppointment(reference_number);
	}
	
//	Remove an appointment by reference number
	public boolean removeAppointmentByReferenceNumber(int reference_number) {
		return this.database.removeAppointmentByReferenceNumber(reference_number);
	}
	
//	Remove an appointment by id
	public boolean removeAppointmentById(int id) {
		return this.database.removeAppointmentById(id);
	}
}
