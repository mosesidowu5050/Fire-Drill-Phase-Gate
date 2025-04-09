package menstrualWahala;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenstrualAppWorkingPrototype {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate cycleStartDate = null;
        LocalDate cycleEndDate = null;
        int cycleLength;

        while (cycleStartDate == null) {
            System.out.print("Enter your cycle start date (YYYY-MM-DD): ");
            String startDate = userInput.nextLine();
            try {
                cycleStartDate = LocalDate.parse(startDate, dateFormat);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. try again.");
            }
        }

        while (cycleEndDate == null) {
            System.out.print("Enter your cycle end date (YYYY-MM-DD): ");
            String endDate = userInput.nextLine();
            try {
                cycleEndDate = LocalDate.parse(endDate, dateFormat);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. try again.");
            }
        }

        while (true) {
            System.out.print("Enter your cycle length: ");
            if (userInput.hasNextInt()) {
                cycleLength = userInput.nextInt();
                if (cycleLength < 21 || cycleLength > 35) {
                    System.out.println("Irregular cycle length.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid input. enter a valid number.");
                userInput.next();
            }
        }

        MenstrualApp menstrualApp = new MenstrualApp(cycleStartDate, cycleEndDate, cycleLength);

        System.out.println("\nResults: ");

        int flowDuration = menstrualApp.calculateFlowDuration(cycleStartDate, cycleEndDate);
        System.out.println("Flow Duration: " + flowDuration + " days");

        System.out.println("Start Date: " + menstrualApp.calculateStartDate());
        System.out.println("End Date: " + menstrualApp.calculateEndDate());
        System.out.println("Ovulation Period: " + menstrualApp.calculateOvulationPeriod());
        System.out.println("Safe Period Start Date: " + menstrualApp.calculateSafePeriodDate());
        System.out.println("Safe Period End Date: " + menstrualApp.calculateSafePeriodEndDate());
        System.out.println("Next Period Start Date: " + menstrualApp.calculateNextPeriodStartDate());
        System.out.println("Safe Period After Ovulation Period: " + menstrualApp.calculateSafePeriodAfterOvulation());
        System.out.println("Safe Period Before Next Period: " + menstrualApp.calculateSafePeriodBeforeNextPeriod());
    }
}
