import HDVisit.HDVisit;
import org.bitcoinj.wallet.UnreadableWalletException;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import visit.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Costomer {

    private final String mnemonic = "please promote sting series horn leave squirrel juice harsh over wash reduce";
    private VisitedContract visitedContract;
    HDVisit hdVisit;

    public Costomer() throws UnreadableWalletException {
        visitedContract = new VisitedContract();
        hdVisit = new HDVisit(mnemonic, "ms");
    }

    public CostomerInfo getInfo(String date, int idx) throws UnreadableWalletException {
        Credentials credentials = hdVisit.getCredentials(date, idx);
        System.out.println(credentials.getAddress());
        return new CostomerInfo(
                credentials.getAddress(),
                Util.timeToSec()
        );
    }

    public List<FindResponse> find(String date) throws IOException {
        List<FindResponse> list = new ArrayList<>();

        for(int i=0;; i++) {
            Credentials credentials =  hdVisit.getCredentials(date, i);
            List<Type> response =  visitedContract.find(credentials.getAddress());
            if (((BigInteger) response.get(1).getValue()).compareTo(BigInteger.ZERO) == 0) break;
            list.add(new FindResponse(
                    (String)response.get(0).getValue(),
                    (BigInteger) response.get(1).getValue())
            );
        }

        Collections.sort(list);

        return list;
    }
}
