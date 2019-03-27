package tada.suzu.localtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    private static final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

    public static void main(String... args) {

        var time = LocalTime.now();
        logger.info(time.toString());
        logger.info(time.format(formatter));

        time = LocalTime.of(14,30);
        logger.info(time.toString());
        logger.info(time.format(formatter));

        logger.info("---------------------");

        var datetime = LocalDateTime.now();
        logger.info(datetime.toString());
        logger.info(datetime.format(formatter2));

        datetime = LocalDateTime.of(2018,8,16,10,55);
        logger.info(datetime.toString());
        logger.info(datetime.format(formatter2));
    }
}
