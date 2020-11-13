import HDVisit.HDVisit;
import network.Web3Connecter;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.wallet.UnreadableWalletException;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class AppController {
    private VisitedContract visitedContract;
    private HDVisit hdVisit;

    //for Test
    final String mnemonic = "please promote sting series horn leave squirrel juice harsh over wash reduce";

    public AppController() throws UnreadableWalletException {
        visitedContract = new VisitedContract();
        hdVisit = new HDVisit(mnemonic, "test");
    }

    public String visit(String shopAddress, BigInteger time) throws IOException, TransactionException {
        Credentials credentials = hdVisit.getCredentials();
        String txHash = EthSender.send(credentials.getAddress());
        System.out.println("eth send fin" + txHash);

        return visitedContract.visit(shopAddress, time, credentials);
    }

    public List<Type> find(String date, int idx) throws IOException {
        DeterministicKey privKey = hdVisit.createPrivKey(date, idx);
        List<Type> decode = visitedContract.find(privKey.getPublicKeyAsHex());
        return decode;
    }
}
