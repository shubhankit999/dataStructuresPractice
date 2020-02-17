import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class SampleDateExamplr {

    public static void main(String[] args) {
        ZonedDateTime zoneTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0); //("2019-12-23 07:00:39");
        Duration d = Duration.between(zonedDateTime, zoneTime);
        System.out.println(d.toMinutes());
        if(d.toMinutes()>=30) {
            System.out.println(zoneTime.toEpochSecond());
            System.out.println(zonedDateTime.toEpochSecond());
        }
        System.out.println("Not equals");
    }
}
