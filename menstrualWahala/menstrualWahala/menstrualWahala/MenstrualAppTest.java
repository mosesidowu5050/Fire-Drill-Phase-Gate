package menstrualWahala;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MenstrualAppTest {

    @Test
    public void testThrowExceptionIfCycleLengthLessThanTwentyOneAndGreaterThanThirtyFive(){
        int cycleLengthOne = 20;
        int cycleLengthTwo = 40;
        LocalDate startDate = LocalDate.of(2025, 5, 4);
        LocalDate endDate = LocalDate.of(2025, 5, 9);
        new MenstrualApp(startDate, endDate, cycleLengthOne);
        new MenstrualApp(startDate, endDate, cycleLengthTwo);
    }

    @Test
    public void testCalculateOvulationPeriodIsValid() {
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 5, 4);
        LocalDate endDate = LocalDate.of(2025, 5, 9);

        MenstrualApp menstrualApp = new MenstrualApp(startDate, endDate, cycleLength);

        LocalDate actualOvulationDate = menstrualApp.calculateOvulationPeriod();
        LocalDate expectedOvulationDate = endDate.plusDays(cycleLength / 2);
        assertEquals(expectedOvulationDate, actualOvulationDate);
    }
    @Test
    public void testCalculateFlowDuration() {
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 4, 5);
        LocalDate endDate = LocalDate.of(2025, 4, 9);

        MenstrualApp menstrualApp = new MenstrualApp(startDate, endDate, cycleLength);

        LocalDate cycleStartDate = LocalDate.of(2025, 4, 5);
        LocalDate cycleEndDate = LocalDate.of(2025, 4, 10);

        int expectedFlowDuration = 5;
        int actualFlowDuration = menstrualApp.calculateFlowDuration(cycleStartDate, cycleEndDate);
        System.out.println(actualFlowDuration);
        assertEquals(expectedFlowDuration, actualFlowDuration);
    }
    @Test
    public void testPeriodStartDateIsWorkingProperly() {
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 4, 5);
        LocalDate endDate = LocalDate.of(2025, 4, 9);

        MenstrualApp menstrualApp = new MenstrualApp(startDate, endDate, cycleLength);
        LocalDate expectedStartDate = menstrualApp.calculateStartDate();
        assertEquals(expectedStartDate, startDate);
    }
    @Test
    public void testToCheckPeriodEndDateIsValid() {
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 4, 5);
        LocalDate endDate = LocalDate.of(2025, 4, 9);

        MenstrualApp menstrualApp = new MenstrualApp(startDate, endDate, cycleLength);
        LocalDate expectedDate = menstrualApp.calculateEndDate();
        assertEquals(endDate, expectedDate);
    }
    @Test
    public void testThatChecksIfSafePeriodStartDateIsIsValid(){
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 4, 5);
        LocalDate endDate = LocalDate.of(2025, 4, 9);

        MenstrualApp menstrualApp = new MenstrualApp(startDate, endDate, cycleLength);
        LocalDate SafePeriodStartDate = menstrualApp.calculateSafePeriodDate();
        LocalDate expectedDateForSafePeriod = endDate.plusDays(1);
        assertEquals(SafePeriodStartDate, expectedDateForSafePeriod);
    }
    @Test
    public void testThatChecksSafePeriodEndDateIsValid(){
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 4, 5);
        LocalDate endDate = LocalDate.of(2025, 4, 9);

        MenstrualApp menstrualApp = new MenstrualApp(startDate, endDate, cycleLength);
        LocalDate SafePeriodEndDate = menstrualApp.calculateSafePeriodEndDate();
        LocalDate expectedDateForSafePeriodEndDate = endDate.plusDays(6);
        assertEquals(SafePeriodEndDate, expectedDateForSafePeriodEndDate);
    }
    @Test
    public void testThatCalculateNextPeriodStartDate(){
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 4, 5);
        LocalDate endDate = LocalDate.of(2025, 4, 10);

        MenstrualApp menstrualApp = new MenstrualApp(startDate, endDate, cycleLength);
        LocalDate nextPeriodStartDate = menstrualApp.calculateNextPeriodStartDate();
        LocalDate expectedDateForNextPeriodStartDate = endDate.plusDays(cycleLength);
        assertEquals(nextPeriodStartDate, expectedDateForNextPeriodStartDate);
    }

}

