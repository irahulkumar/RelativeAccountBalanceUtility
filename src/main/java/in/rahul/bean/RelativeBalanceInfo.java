package in.rahul.bean;

import java.text.NumberFormat;

public class RelativeBalanceInfo {
    private double relativeBalance;
    private int transactions;

    public RelativeBalanceInfo(){
        relativeBalance = 0.0;
        transactions = 0;
    }

    public void addToBalance(Double balance){
        relativeBalance += balance;
        transactions++;
    }

    public void removeFromBalance(Double balance){
        relativeBalance -= balance;
        transactions++;
    }


    public double getRelativeBalance() {
        return relativeBalance;
    }

    public void setRelativeBalance(double relativeBalance) {
        this.relativeBalance = relativeBalance;
    }

    public int getTransactions() {
        return transactions;
    }

    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "RelativeBalanceInfo{" +
                "relativeBalance=" + relativeBalance +
                ", transactions=" + transactions +
                '}';
    }

    public String getFormattedRelativeBalance(){
        return NumberFormat.getCurrencyInstance().format(this.getRelativeBalance());
    }

}
