package in.rahul.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import in.rahul.bean.RelativeBalanceInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestRelativeBalanceInfo {

    RelativeBalanceInfo relativeBalanceInfo;

    @BeforeEach
    void setUp(){
        relativeBalanceInfo = new RelativeBalanceInfo();
    }

    @Test
    @DisplayName("Testing Positive Formatted Value")
    void testGetFormattedRelativeBalancePositive(){
        relativeBalanceInfo.setRelativeBalance(45.50);
        relativeBalanceInfo.setTransactions(5);

        assertEquals("$45.50", relativeBalanceInfo.getFormattedRelativeBalance() ,"Should return positive value with dollar sign");
        assertEquals(5, relativeBalanceInfo.getTransactions());
    }

    @Test
    @DisplayName("Testing Negative Formatted Value")
    void testGetFormattedRelativeBalanceNegative(){
        relativeBalanceInfo.setRelativeBalance(-35.50);
        relativeBalanceInfo.setTransactions(4);

        assertEquals("-$35.50", relativeBalanceInfo.getFormattedRelativeBalance() ,"Should return negative value with dollar sign");
        assertEquals(4, relativeBalanceInfo.getTransactions());
    }
}
