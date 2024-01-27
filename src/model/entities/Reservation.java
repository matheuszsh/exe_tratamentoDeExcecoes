package model.entities;

import model.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation{

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainExceptions{
        Date now = new Date();

        if (checkout.before(checkin)){
            throw new DomainExceptions("Erro: Checkout Before Checkin");
        }
        if (checkin.before(now) || checkout.before(now)){
            throw new DomainExceptions("Erro: Just checking with now date");
        }

		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

    //para saber o intervalo entre duas datas(dias)
	public long duration(){
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut)throws DomainExceptions{
		Date now = new Date();
		//throw new - indica que está lançando uma chamada de execessão, junto ao tipo da excessão
		if (checkOut.before(checkIn)){
			throw new DomainExceptions("Erro: Checkout Before Checkin");
		}
		if (checkOut.before(now) || checkIn.before(now)){
			throw new DomainExceptions("Erro: Just checking with now date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reservation:" + roomNumber + '\n' +
				"CheckIn:" + sdf.format(checkIn) + '\n' +
				"CheckOut:" + sdf.format(checkOut) + '\n' +
				duration() + " nights";
	}
}