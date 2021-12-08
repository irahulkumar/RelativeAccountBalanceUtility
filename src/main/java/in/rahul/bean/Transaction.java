package in.rahul.bean;

import in.rahul.TransactionConstants;

import java.time.LocalDateTime;


public class Transaction {
    private String transactionID;
    private String fromAccountID;
    private String toAccountID;
    private LocalDateTime createAt;
    private Double amount;
    private TransactionType transactionType;
    private String relatedTransaction;

    public Transaction(String csvLine){
       String [] csvArray =  csvLine.split(",");
       if(csvArray.length >= 6){
           transactionID = csvArray[0];
           fromAccountID = csvArray[1];
           toAccountID = csvArray[2];
           createAt = LocalDateTime.parse(csvArray[3], TransactionConstants.DATETIMEFORMATTER);
           amount =Double.parseDouble(csvArray[4]);
           transactionType = TransactionType.fromText(csvArray[5]);
           if(csvArray.length == 7){
               relatedTransaction = csvArray[6];
           }
       }
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getFromAccountID() {
        return fromAccountID;
    }

    public void setFromAccountID(String fromAccountID) {
        this.fromAccountID = fromAccountID;
    }

    public String getToAccountID() {
        return toAccountID;
    }

    public void setToAccountID(String toAccountID) {
        this.toAccountID = toAccountID;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getRelatedTransaction() {
        return relatedTransaction;
    }

    public void setRelatedTransaction(String relatedTransaction) {
        this.relatedTransaction = relatedTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID='" + transactionID + '\'' +
                ", fromAccountID='" + fromAccountID + '\'' +
                ", toAccountID='" + toAccountID + '\'' +
                ", createAt=" + createAt +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", relatedTransaction=" + relatedTransaction +
                '}';
    }
}
