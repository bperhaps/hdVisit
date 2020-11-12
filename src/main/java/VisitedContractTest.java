import org.bitcoinj.crypto.DeterministicHierarchy;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.wallet.UnreadableWalletException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.exceptions.TransactionException;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class VisitedContractTest {
    public static void main(String[] args) throws IOException, TransactionException, UnreadableWalletException, ExecutionException, InterruptedException {
        VisitedContract visitedContract = new VisitedContract();
        HDVisit hdVisit = new HDVisit("please promote sting series horn leave squirrel juice harsh over wash reduce", "");
        DeterministicKey privKey = hdVisit.createPrivKey();

        ECKeyPair keyPair = ECKeyPair.create(privKey.getPrivKeyBytes());
        System.out.println(Keys.toChecksumAddress(Keys.getAddress(keyPair)));
        Credentials c = Credentials.create(privKey.getPrivateKeyAsHex());
        //Credentials c = Credentials.create("0x8fa66635c7f8ca6f60273571fa8841339b4f25ce11a0ca6d337d7d25011c91e2");
        visitedContract.visit("0x89b4b94Bbc0681D211413cB0DEE784222a9cf7Eb",
                BigInteger.valueOf(1234),
                c);
        System.out.println(visitedContract.find("0x76bEF99854a31c7B91791A3c7864313E95CcF3Cc"));
    }
}
