import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class VisitedContract {


    public String visit(String shopAddress, BigInteger time, Credentials credentials) throws IOException, TransactionException {
        Function function = new Function("visit",
                Arrays.asList(new Address(shopAddress), new Uint(time)),
                Collections.emptyList()
                );

        String txData = FunctionEncoder.encode(function);
        TransactionManager txManager = new RawTransactionManager(Web3Connecter.getWeb3Connecter().getInstance(), credentials, 2831);

        Response.Error txHash = txManager.sendTransaction(
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT,
                contractAddress,
                txData,
                BigInteger.ZERO).getError();
        System.out.println(txHash.getMessage());
        return null;
/*
        TransactionReceiptProcessor receiptProcessor = new PollingTransactionReceiptProcessor(
                Web3Connecter.getWeb3Connecter().getInstance(),
                TransactionManager.DEFAULT_POLLING_FREQUENCY,
                TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

        TransactionReceipt receipt = receiptProcessor.waitForTransactionReceipt(txHash);
        return receipt.toString();*/
    }

    public String find(String myAddress) throws IOException {
        Function function = new Function("find",
                Collections.emptyList(),
                Arrays.asList(new TypeReference<Address>() {}, new TypeReference<Uint>() {}));

        Transaction transaction = Transaction.createEthCallTransaction(
                myAddress,
                contractAddress,
                FunctionEncoder.encode(function));

        EthCall ethCall = Web3Connecter.getWeb3Connecter().getInstance().ethCall(transaction, DefaultBlockParameterName.LATEST).send();
        List<Type> decode = FunctionReturnDecoder.decode(ethCall.getResult(),
                function.getOutputParameters());

        return decode.toString();
    }

    final static String contractAddress = "0xD2C1D462e06ad1903c7C622afdC5dff7F7E9e09c";
}
