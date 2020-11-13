
import network.Web3Connecter;

import org.bitcoinj.wallet.UnreadableWalletException;
import org.web3j.crypto.Credentials;

import org.web3j.protocol.Web3j;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
import java.math.BigInteger;;

public class EthSender {
    //for Test
    private static String moneySlavePriveKey = "4ff9767a92dadfa7f9d2bebd807ddfb78a4940ee776571ee08cbd8d05b658405";

    public static String send(String address) throws IOException {
        TransactionManager txManager = new RawTransactionManager(Web3Connecter.getInstance(),
                Credentials.create(moneySlavePriveKey)
                , 1337);

        return txManager.sendTransaction(
                BigInteger.valueOf(1),
                BigInteger.valueOf(21000),
                address,
                new String(),
                BigInteger.valueOf(1)
        ).getTransactionHash();
    }

    /*//0xd54aab16dad0af67368d99330b9de27c49b945d0
        //0x62b2921cae5f15dfd42359f5ad0f4a26e5b3aca3
        String key1 = "0e804e4d5695de02a4bd99b2aec9d6a24aed7b6e1528f775895debaea06d3882";
        //0x445ed7f5f0d0ca0eba2b57542e5cd21348c9e6cd
        String key2 = "dcf2ac940a6cb89e8923341c72b1ab9d970df2daddce93aca1c1e86be9f83c7c";*/

}
