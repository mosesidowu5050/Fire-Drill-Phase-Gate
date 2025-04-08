package menstrualWahala;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenstrualAppWorkingPrototype {
    public static void main(String[] args) {


        java.util.Scanner userInput = new java.util.Scanner(System.in);

        System.out.print("Welcome to Menstrual Wahala!\n");


        System.out.print("Enter your start date in this format YYYY-MM-DD: ");
        String startDate = userInput.nextLine();

        System.out.print("Enter your end date in this format YYYY-MM-DD: ");
        String endDate = userInput.nextLine();

        System.out.print("Enter your cycle length: ");
        int cycleLength = userInput.nextInt();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate flowStartDate = LocalDate.parse(startDate, dateFormat);
        LocalDate flowEndDate = LocalDate.parse(endDate, dateFormat);

        MenstrualApp menstrualApp = new MenstrualApp(flowStartDate, flowEndDate, cycleLength);

        System.out.println("Period Start: " + menstrualApp.calculateStartDate());
        System.out.println("Period Ending end date is: " + menstrualApp.calculateEndDate());


    }
}
