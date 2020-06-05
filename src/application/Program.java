
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Sistemas de Reservas:");
        
        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Checkin date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Checkout date (dd/MM/yyyy): ");
        Date checkoout = sdf.parse(sc.next());
        
        if(!checkoout.after(checkin)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            Reservation res = new Reservation(number, checkin, checkoout);
            System.out.println("Reservation: " + res);
        
        System.out.println("");
        System.out.println("Update the reservation:");
        
        System.out.print("Checkin date (dd/MM/yyyy): ");
        checkin = sdf.parse(sc.next());
        System.out.print("Checkout date (dd/MM/yyyy): ");
        checkoout = sdf.parse(sc.next());
        
        res.updateDates(checkin, checkoout);
            System.out.println("Reservation: " + res);
        
        }
        }   

}
