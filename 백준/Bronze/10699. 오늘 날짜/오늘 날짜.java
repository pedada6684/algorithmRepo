import java.io.IOException;
import java.time.LocalDate;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(LocalDate.now(TimeZone.getTimeZone("Asia/Seoul").toZoneId()));;
    }
}
