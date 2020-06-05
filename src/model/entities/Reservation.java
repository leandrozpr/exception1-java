
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {
    
    private Integer roomNumber;
    private Date checkIn;
    private Date checkout;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkout) throws DomainException {
        if(!checkout.after(checkIn)){
            throw new DomainException(" Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
    
    public long duration(){
        long diff = checkout.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        
    }
    
    public void updateDates(Date checkIn, Date checkout)throws DomainException{
        
        Date now = new Date();
        if(checkIn.before(now) || checkout.before(now)){
            throw new DomainException(" Reservation dates for update must be future dates");
        }
        if(!checkout.after(checkIn)){
            throw new DomainException(" Check-out date must be after check-in date");
        }
        
        this.checkIn = checkIn;
        this.checkout = checkout;  
       
    }
    @Override
    public String toString(){
        return "Room "
                + roomNumber
                + ", checkin "
                + sdf.format(checkIn)
                + ", checkout "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";
        
                
    }
}
