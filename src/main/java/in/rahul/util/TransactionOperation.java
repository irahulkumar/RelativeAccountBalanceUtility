package in.rahul.util;

import in.rahul.TransactionConstants;
import in.rahul.bean.RelativeBalanceInfo;
import in.rahul.bean.Transaction;
import in.rahul.bean.TransactionType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TransactionOperation {
    ArrayList<Transaction> transactions;

    public TransactionOperation(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

    public ArrayList<String> getReversedTransactionList(String accountId, LocalDateTime fromDateTime, LocalDateTime toDateTime){
        ArrayList<String> reverseTransactionList = new ArrayList<>();
        transactions.stream().filter(transaction -> transaction.getCreateAt().compareTo(fromDateTime) >=0
                && transaction.getCreateAt().compareTo(toDateTime) <=0
                && (transaction.getFromAccountID().equalsIgnoreCase(accountId) || transaction.getToAccountID().equalsIgnoreCase(accountId))
                && transaction.getTransactionType().equals(TransactionType.REVERSAL))
                .forEach(transaction -> reverseTransactionList.add(transaction.getRelatedTransaction()));
        return reverseTransactionList;
    }

    public RelativeBalanceInfo getRelativeBalanceInfo(String accountId, String from, String to){
        RelativeBalanceInfo relativeBalanceInfo = new RelativeBalanceInfo();

        LocalDateTime fromDateTime = LocalDateTime.parse(from, TransactionConstants.DATETIMEFORMATTER);
        LocalDateTime toDateTime = LocalDateTime.parse(to, TransactionConstants.DATETIMEFORMATTER);

        ArrayList<String> reverseTransactionList = getReversedTransactionList(accountId, fromDateTime, toDateTime);

        transactions.stream()
                .filter(transaction -> transaction.getCreateAt().compareTo(fromDateTime) >=0
                        && transaction.getCreateAt().compareTo(toDateTime) <=0
                        && (transaction.getFromAccountID().equalsIgnoreCase(accountId) || transaction.getToAccountID().equalsIgnoreCase(accountId))
                        && transaction.getTransactionType().equals(TransactionType.PAYMENT)
                        && !reverseTransactionList.contains(transaction.getTransactionID()))
                .forEach(transaction -> {
                        if(transaction.getFromAccountID().equalsIgnoreCase(accountId)){
                            relativeBalanceInfo.removeFromBalance(transaction.getAmount());
                        } else {
                            relativeBalanceInfo.addToBalance(transaction.getAmount());
                        }
                    }
                );

        return relativeBalanceInfo;
    }
}
