import org.bitcoinj.wallet.UnreadableWalletException;
import org.web3j.protocol.exceptions.TransactionException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnreadableWalletException, IOException, TransactionException, InterruptedException {
        String[] shopsPrivKey = {
                "0cac40643dbfe52271792c6d7cfc8cc4cc5443607b20564b80524b7557597996",
                "b2ec472638c3f0760e3e8a433a4894f79f988ff546570e379a6eb262dfabf5d6",
                "0cd423320b3e51d6fcbfa0eaf8912f22ff049c57ea3d805fde46307c5835ef33",
                "e995f5dd5475d5f2ec39f7f188e668c44e1e8cdafb4dc2caba60d553f9583a92",
                "b63f650d082fc280909d791f85938d3b5bdb4ccbda62ceb145ee0c9de95b8758",
                "409364748e50ec1f5aa27143801bfa39c143b3a454c51a7a3e4f1c24829fd0aa",
                "020009542e9cfeebec3b9afa581c903f32d9ed34a84b7a434f877b3313f12556",
                "7cf7263e17c23a557a4961645b150108b396005ce63e0e9c175f55b207250786"
        };

        Costomer costomer = new Costomer();
        Shop[] shops = new Shop[8];
        for(int i=0; i<shopsPrivKey.length; i++) {
            shops[i] = new Shop(shopsPrivKey[i]);
            //System.out.println(shops[i].credentials.getAddress());
        }

        shops[1].visit(costomer.getInfo("2020-11-14", 0));
        Thread.sleep(1000);
        shops[1].visit(costomer.getInfo("2020-11-14", 1));
        Thread.sleep(1000);
        shops[1].visit(costomer.getInfo("2020-11-14", 2));
        Thread.sleep(1000);
        shops[1].visit(costomer.getInfo("2020-11-14", 3));
        Thread.sleep(1000);
        shops[1].visit(costomer.getInfo("2020-11-14", 4));
        Thread.sleep(1000);
        shops[1].visit(costomer.getInfo("2020-11-14", 5));
        Thread.sleep(1000);
        shops[1].visit(costomer.getInfo("2020-11-14", 6));
        Thread.sleep(1000);

        System.out.println("-----------");

        costomer.find("2020-11-14").stream().forEach(x ->
                System.out.println(x.toString())
        );
    }
}

