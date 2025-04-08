package menstrualWahala;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MenstrualApp {
    private String name;
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
    }

    public LocalDate calculateOvulationPeriod() {
        return cycleEndDate.plusDays(cycleLength/2);
    }

    public int calculateFlowDuration(LocalDate startDate, LocalDate endDate) {
        int daysBetween = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isEqual(endDate)) {
            currentDate = currentDate.plusDays(1);
            daysBetween++;
        }
        return daysBetween;
    }
}

