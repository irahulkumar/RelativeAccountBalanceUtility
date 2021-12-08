package in.rahul.util;

import in.rahul.TransactionConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTransactionOperation {

    TransactionOperation transactionOperation;

    @BeforeEach
    void loadCSV() throws IOException {
        transactionOperation = new TransactionOperation(CSVLoader.loadTransactionCSV(TestUtil.getResourcePath("transaction1.csv")));
    }

    @Test
    @DisplayName("Testing getting Reverse Transaction List - Positive Case")
    void testGetReverseTransactionListPositive(){
        String accountId = "ACC334455";
        String from = "20/10/2018 12:00:00";
        String to = "20/10/2018 19:00:00";

        LocalDateTime fromDateTime = LocalDateTime.parse(from, TransactionConstants.DATETIMEFORMATTER);
        LocalDateTime toDateTime = LocalDateTime.parse(to, TransactionConstants.DATETIMEFORMATTER);

        assertEquals(0, transactionOperation.getReversedTransactionList(accountId, fromDateTime, toDateTime).size());
    }

    @Test
    @DisplayName("Testing getting Reverse Transaction List - Negative Case")
    void testGetReverseTransactionListNegative(){
        String accountId = "ACC334455";
        String from = "20/10/2018 12:00:00";
        String to = "21/10/2018 19:00:00";

        LocalDateTime fromDateTime = LocalDateTime.parse(from, TransactionConstants.DATETIMEFORMATTER);
        LocalDateTime toDateTime = LocalDateTime.parse(to, TransactionConstants.DATETIMEFORMATTER);

        assertEquals(1, transactionOperation.getReversedTransactionList(accountId, fromDateTime, toDateTime).size());
    }

    @Test
    @DisplayName("Testing for account that exists in the csv")
    void testGetRelativeInfoBalance(){
        String accountId = "ACC334455";
        String from = "20/10/2018 12:00:00";
        String to = "20/10/2018 19:00:00";

        assertEquals(-30.5, transactionOperation.getRelativeBalanceInfo(accountId, from, to).getRelativeBalance(), "Testing Relative balance");
        assertEquals(3, transactionOperation.getRelativeBalanceInfo(accountId, from, to).getTransactions(), "Testing Transaction");
    }

    @Test
    @DisplayName("Testing for account that does not exists in the csv")
    void testGetRelativeInfoBalanceNotExists(){
        String accountId = "ACC11111";
        String from = "20/10/2018 12:00:00";
        String to = "20/10/2018 19:00:00";

        assertEquals(0, transactionOperation.getRelativeBalanceInfo(accountId, from, to).getRelativeBalance(), "Testing Relative balance");
        assertEquals(0, transactionOperation.getRelativeBalanceInfo(accountId, from, to).getTransactions(), "Testing Transaction");
    }

    @Test
    @DisplayName("Testing for account that has reversal")
    void testGetRelativeInfoBalanceReversal(){
        String accountId = "ACC334455";
        String from = "20/10/2018 12:00:00";
        String to = "20/10/2018 19:50:00";

        assertEquals(-20.0, transactionOperation.getRelativeBalanceInfo(accountId, from, to).getRelativeBalance(), "Testing Relative balance");
        assertEquals(2, transactionOperation.getRelativeBalanceInfo(accountId, from, to).getTransactions(), "Testing Transaction");
    }
}
