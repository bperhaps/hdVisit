import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class Web3Connecter {

    private static Web3Connecter web3Connecter;
    private final String LOCAL = "http://127.0.0.1:8545";
    private Web3j web3j;

    private Web3Connecter() {
        web3j = Web3j.build(new HttpService(LOCAL));
    }

    public static Web3Connecter getWeb3Connecter() {
        if(web3Connecter == null){
            web3Connecter = new Web3Connecter();
        }
        return web3Connecter;
    }

    public Web3j getInstance(){
        return web3j;
    };

}
