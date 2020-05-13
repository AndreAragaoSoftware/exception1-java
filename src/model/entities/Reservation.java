package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roowNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
		
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation(Integer roowNumber, Date checkIn, Date checkOut) {
		this.roowNumber = roowNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getRoowNumber() {
		return roowNumber;
	}
	public void setRoowNumber(Integer roowNumber) {
		this.roowNumber = roowNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		// Calcula em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		// convertendo milisegundos para dia
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		// testando se a data de check in e out s�o anteriores que agora
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for oudate must be fututre dates";
		}//depois
		if(!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return  "Roow "
				+ roowNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nigths";
				
	}
	
}
