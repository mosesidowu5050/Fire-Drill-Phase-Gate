package menstrualWahala;

import java.time.LocalDate;

public class MenstrualApp {
    private LocalDate cycleStartDate;
    private LocalDate cycleEndDate;
    private int cycleLength;
    private int flowDuration;

    public MenstrualApp(LocalDate cycleStartDate, LocalDate cycleEndDate, int cycleLength) {
         if (cycleLength < 21 || cycleLength > 35 ) {
             System.out.println("This indicates irregular cycle length.");
        }
        this.cycleStartDate = cycleStartDate;
        this.cycleEndDate = cycleEndDate;
        this.cycleLength = cycleLength;
        this.flowDuration = 0;
    }

    public LocalDate calculateOvulationPeriod() {
        return cycleEndDate.plusDays(cycleLength/2);
    }

    public int calculateFlowDuration(LocalDate startDate, LocalDate endDate) {
        LocalDate currentDate = startDate;

        while (!currentDate.isEqual(endDate)) {
            currentDate = currentDate.plusDays(1);
            flowDuration++;
        }
        return flowDuration;
    }

    public LocalDate calculateStartDate() {
        return cycleStartDate;
    }

    public LocalDate calculateEndDate() {
        return cycleEndDate;
    }

    public LocalDate calculateSafePeriodDate() {
        return cycleEndDate.plusDays(1);
    }

    public LocalDate calculateSafePeriodEndDate() {
        return cycleEndDate.plusDays(6);
    }

    public LocalDate calculateNextPeriodStartDate() {
        return cycleEndDate.plusDays(cycleLength);
    }
}

