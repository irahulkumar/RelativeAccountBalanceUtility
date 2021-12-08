package in.rahul.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCSVLoader {

    @Test
    @DisplayName("Testing Number of Records")
    public void testLoadTransactionCSVCount() throws IOException {
       assertEquals(5,CSVLoader.loadTransactionCSV(TestUtil.getResourcePath("transaction1.csv")).size(), "Record Count should match the csv line count");
    }

    @Test
    @DisplayName("Testing Invalid date in Records")
    public void testLoadTransactionCSVInvalidDate() throws IOException {
        assertEquals(4,CSVLoader.loadTransactionCSV(TestUtil.getResourcePath("transaction2.csv")).size(), "Records with invalid date should not be included in the count");
    }

    @Test
    @DisplayName("Testing Invalid amount in Records")
    public void testLoadTransactionCSVInvalidAmount() throws IOException {
        assertEquals(4,CSVLoader.loadTransactionCSV(TestUtil.getResourcePath("transaction3.csv")).size(), "Records with invalid amount should not be included in the count");
    }
}
