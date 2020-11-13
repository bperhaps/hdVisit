import network.Web3Connecter;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

public class VisitedContract {
    final static String contractAddress = "0x55F5907541d726Ff36166d067Af0A528d37492f9";

    public String visit(String shopAddress, BigInteger time, Credentials credentials) throws IOException, TransactionException {
        Function function = new Function("visit",
                Arrays.asList(new Address(shopAddress), new Uint(time)),
                Collections.emptyList()
                );

        String txData = FunctionEncoder.encode(function);
        TransactionManager txManager = new RawTransactionManager(Web3Connecter.getInstance(), credentials, 1337);

        String txHash = txManager.sendTransaction(
                BigInteger.valueOf(1),
                BigInteger.valueOf(210000),
                contractAddress,
                txData,
                BigInteger.ZERO).getTransactionHash();

        return txHash;
    }

    public List<Type> find(String myAddress) throws IOException {
        Function function = new Function("find",
                Collections.emptyList(),
                Arrays.asList(new TypeReference<Address>() {}, new TypeReference<Uint>() {}));

        Transaction transaction = Transaction.createEthCallTransaction(
                myAddress,
                contractAddress,
                FunctionEncoder.encode(function));

        EthCall ethCall = Web3Connecter.getInstance().ethCall(transaction, DefaultBlockParameterName.LATEST).send();
        List<Type> decode = FunctionReturnDecoder.decode(ethCall.getResult(),
                function.getOutputParameters());

        return decode;
    }

    public String alarmToPeople(String shopAddress, BigInteger startDate, BigInteger endDate, Credentials credentials) throws IOException {
        Function function = new Function("alarmToPeople",
                Arrays.asList(new Address(shopAddress), new Uint(startDate), new Uint(endDate)),
                Collections.emptyList()
                );

        String txData = FunctionEncoder.encode(function);
        TransactionManager txManager = new RawTransactionManager(Web3Connecter.getInstance(), credentials, 1337);

        String txHash = txManager.sendTransaction(
                BigInteger.valueOf(1),
                BigInteger.valueOf(210000),
                contractAddress,
                txData,
                BigInteger.ZERO).getTransactionHash();

        return txHash;
    }
}
