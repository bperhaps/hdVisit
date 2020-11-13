import HDVisit.HDVisit;
import org.bitcoinj.wallet.UnreadableWalletException;

public class AppController {
    private VisitedContract visitedContract;
    private HDVisit hdVisit;

    final String mnemonic = "";
    public AppController() throws UnreadableWalletException {
        visitedContract = new VisitedContract();
        hdVisit = new HDVisit(mnemonic, "");
    }

    public String visit() {
        //visitedContract.visit()
        return null;
    }

    public String find() {
        //visitedContract.find()
        return null;
    }
}
