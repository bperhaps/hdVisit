package visit;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

public class Util {
    public static BigInteger timeToSec() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return BigInteger.valueOf(calendar.get(Calendar.HOUR) * 60 * 60 +
                calendar.get(Calendar.MINUTE) * 60 +
                calendar.get(Calendar.SECOND));
    }

    public static String secToTime(BigInteger sec) {
        int timeSecond = sec.intValue();
        int hour = timeSecond / (60 * 60);
        int minute = (timeSecond - hour * 60 * 60) / 60;
        int second = timeSecond - hour * 60 * 60 - minute * 60;

        return hour + ":" + minute + ":" + second;
    }
}
