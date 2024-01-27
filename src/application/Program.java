package application;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program{
    public static void main(String[] args) throws ParseException {
        Scanner get = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("----RESERVATION-----\n");

            System.out.print("ROOM NUMBER:");
            int roomNumber = get.nextInt();
            get.nextLine();

            System.out.print("CheckIn:");
            Date checkInDate = sdf.parse(get.next());

            System.out.print("CheckOut:");
            Date checkOutDate = sdf.parse(get.next());

            Reservation newReservation = new Reservation(roomNumber, checkInDate, checkOutDate);
            System.out.println(newReservation);

            System.out.println("---UPDATE RESERVATION---");
            System.out.print("CheckIn:");
            checkInDate = sdf.parse(get.next());

            System.out.print("CheckOut:");
            checkOutDate = sdf.parse(get.next());

            newReservation.updateDates(checkInDate, checkOutDate);
            System.out.println(newReservation);
        }
        //Tipos de excessão a baixo
        catch (ParseException e){
            System.out.println("Erro: Date Format Invalid.");
        }
        //a excessão abaixo indica uma passagem de argumentos invalida
        catch (DomainExceptions e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Erro: Room Number invalid.");
        }
        catch (RuntimeException e){
            System.out.println("Erro: Runtime Exception");
        }
    }
}