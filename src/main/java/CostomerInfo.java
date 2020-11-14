import org.web3j.crypto.Credentials;

import java.math.BigInteger;

public class CostomerInfo {
    String costomerAddress;
    BigInteger time;

    public CostomerInfo(String costomerAddress, BigInteger time) {
        this.costomerAddress = costomerAddress;
        this.time = time;
    }
}
