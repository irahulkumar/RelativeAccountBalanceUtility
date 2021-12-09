package in.rahul;

import in.rahul.bean.RelativeBalanceInfo;
import in.rahul.util.CSVLoader;
import in.rahul.util.TransactionOperation;

import java.io.IOException;

public class TransactionRunner {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Project\\AnalyseFinancialTransaction\\src\\main\\resources\\transaction.csv";
        String accountId = "ACC778899";
        String from = "20/10/2018 12:00:00";
        String to = "21/10/2018 20:00:00";

        if(args.length == 4){
            path = args[0];
            accountId = args[1];
            from = args[2];
            to = args[3];
        }


        RelativeBalanceInfo relativeBalanceInfo = new TransactionOperation(CSVLoader.loadTransactionCSV(path)).getRelativeBalanceInfo(accountId, from, to);

        System.out.println("Relative balance for the period is: " + relativeBalanceInfo.getFormattedRelativeBalance());
        System.out.println("Number of transaction included is:" + relativeBalanceInfo.getTransactions());
    }
}
