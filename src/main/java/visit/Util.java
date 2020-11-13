package visit;

import java.util.Calendar;
import java.util.Date;

public class Util {
    private int timeToSec() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR) * 60 * 60 +
                calendar.get(Calendar.MINUTE) * 60 +
                calendar.get(Calendar.SECOND);
    }
}
