package tada.suzu.localtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.lastInMonth;

public class LastFriday {

    private static final Logger logger = LoggerFactory.getLogger(LastFriday.class);

    public static void main(String... args) {

        var lastFriday = LocalDate.of(2017,2,24);
        logger.info(lastFriday.toString() + " " + lastFriday.getDayOfWeek());
        for(int i = 0; i < 99; i++) {
            lastFriday = lastFriday.plusMonths(1).with(lastInMonth(DayOfWeek.FRIDAY));
            logger.info(lastFriday.toString() + " " + lastFriday.getDayOfWeek());
        }

    }

}
