
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Sistemas de Reservas:");
    try{  
        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Checkin date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Checkout date (dd/MM/yyyy): ");
        Date checkoout = sdf.parse(sc.next());

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
    catch(ParseException e){
        System.out.println("Invalid date format");
    }
    catch(DomainException e){
        System.out.println("Error in reservation: " + e.getMessage());
    }

        
        }   
    
}
