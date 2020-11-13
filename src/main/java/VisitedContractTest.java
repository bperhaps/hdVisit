import HDVisit.HDVisit;
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


        //Credentials c = Credentials.create("0e804e4d5695de02a4bd99b2aec9d6a24aed7b6e1528f775895debaea06d3882");
        visitedContract.visit("0x445ed7f5f0d0ca0eba2b57542e5cd21348c9e6cd",
                BigInteger.valueOf(1234),
                c);
        System.out.println(visitedContract.find("0x76bEF99854a31c7B91791A3c7864313E95CcF3Cc"));
    }
}
