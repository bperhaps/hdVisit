package network;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class Web3Connecter {

    private static final String LOCAL = "http://127.0.0.1:8545";
    private static Web3j web3j;

    private Web3Connecter() {}

    public static Web3j getInstance(){
        if(web3j == null){
            web3j = Web3j.build(new HttpService(LOCAL));
        }
        return web3j;
    };
}
