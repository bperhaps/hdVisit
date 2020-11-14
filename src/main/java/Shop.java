
import org.web3j.crypto.Credentials;
import org.web3j.protocol.exceptions.TransactionException;


import java.io.IOException;
import java.math.BigInteger;


public class Shop {
    private VisitedContract visitedContract;
    Credentials credentials;
    //for Test
    public Shop(String privKey) {
        visitedContract = new VisitedContract();
        credentials = Credentials.create(privKey);
    }

    public String visit(CostomerInfo costomerInfo) throws IOException, TransactionException {
        return visitedContract.visit(costomerInfo.costomerAddress, costomerInfo.time, credentials);
    }
}
