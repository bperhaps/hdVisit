package HDVisit;

import org.bitcoinj.crypto.*;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.UnreadableWalletException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HDVisit {

    private static final String Korea = "0";
    private static final byte[] SEED = null;
    private static final String PASSPHRASE = "";
    private static final Long CREATIONTIMESECONDS = 0L;
    private final String standardDate = "1970-01-01";

    DeterministicHierarchy root;
    private int visitedIndex = 0;

    public HDVisit(final String mnemonic, String passphrase) throws UnreadableWalletException {
        DeterministicSeed deterministicSeed = new DeterministicSeed(mnemonic, SEED, passphrase, CREATIONTIMESECONDS);
        root = new DeterministicHierarchy(HDKeyDerivation.createMasterPrivateKey(deterministicSeed.getSeedBytes()));
    }

    public Credentials getCredentials() {
        DeterministicKey privKey = createPrivKey();
        return Credentials.create(privKey.getPrivateKeyAsHex());
    }

    public DeterministicKey createPrivKey() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return createPrivKey(sdf.format(new Date()), visitedIndex++);
    }

    public DeterministicKey createPrivKey(String date, int idx) {
        List<ChildNumber> parsePath = HDUtils.parsePath(makePath(Korea, date, idx));
        return root.get(parsePath, true, true);
    }

    private String makePath(String country, String date, int idx) {
        return String.join("/",
                country+"H",
                calcDateDiff(date)+"H",
                String.valueOf(idx)
        );
        // {m/Contry'/date'/visited}
    }

    private String calcDateDiff(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        Date firstDate = null;
        Date secondDate = null;
        try {
            firstDate = sdf.parse(standardDate);
            secondDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return String.valueOf(diff);
    }

}
