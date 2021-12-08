package in.rahul.util;

import in.rahul.bean.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class CSVLoader {
    static final Logger logger = LoggerFactory.getLogger(CSVLoader.class);

    public static ArrayList<Transaction> loadTransactionCSV(String path) throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try(Stream<String> lines = Files.lines(Paths.get(path))){
            lines.forEach(line -> {
                try{
                    transactions.add(new Transaction(line));
                } catch (DateTimeParseException de){
                    logger.error("invalid Date in record");
                } catch (NumberFormatException ne){
                    logger.error("invalid Amount in record");
                }
            });

        }

        return transactions;
    }
}