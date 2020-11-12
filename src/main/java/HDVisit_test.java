import org.bitcoinj.wallet.UnreadableWalletException;

public class HDVisit_test {
    public static void main(String[] args) throws UnreadableWalletException {
        HDVisit hdVisit = new HDVisit("please promote sting series horn leave squirrel juice harsh over wash reduce", "");
        System.out.println(hdVisit.createPrivKey("1993-05-26", 0));

    }
}
