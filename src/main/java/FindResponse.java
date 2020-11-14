import org.jetbrains.annotations.NotNull;
import visit.Util;

import java.math.BigInteger;

public class FindResponse implements Comparable<FindResponse>{
    String address;
    BigInteger time;

    public FindResponse(String address, BigInteger time) {
        this.address = address;
        this.time = time;
    }

    @Override
    public String toString() {
        return address + "," + Util.secToTime(time);
    }

    @Override
    public int compareTo(@NotNull FindResponse o) {
        return Integer.compare(time.intValue(), o.time.intValue());
    }
}
