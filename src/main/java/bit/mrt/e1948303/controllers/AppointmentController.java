package bit.mrt.e1948303.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.mrt.e1948303.entities.Appointment;
import bit.mrt.e1948303.services.AppointmentService;


@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
//	End point for Booking appointment for the default user
	@GetMapping("bookappointmente1948303")
	public String bookAppointmentE1948303() {
		return this.service.bookDefaultAppointment();
	}
	
//	End point for Booking appointment for the dynamic user
	@GetMapping("bookappointment")
	public String bookAppointment(@RequestParam("index_number") String index_number) {
		return this.service.bookAppointment(index_number);
	}
	
//	End point for querying all the appointments
	@GetMapping("query")
	public List<Appointment> query(){
		return this.service.getAllAppointments();
	}
	
//	End point for canceling an appointment using reference number
	@GetMapping("cancelappointment")
	public boolean cancelAppointment(@RequestParam(value = "reference_number",required = true) int reference_number) {
		return this.service.cancelAppointment(reference_number);
	}
	
//	End point for removing an appointment using reference number
	@GetMapping("removeappointment")
	public boolean removeAppointment(@RequestParam(value = "reference_number",required = true) int reference_number) {
		return this.service.cancelAppointment(reference_number);
	}
	
}
