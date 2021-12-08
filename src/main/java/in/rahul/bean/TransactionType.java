package in.rahul.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public enum TransactionType {
    PAYMENT("PAYMENT"),
    REVERSAL("REVERSAL");

    private String text;

    TransactionType(String text){
        this.text = text;
    }

    public static TransactionType fromText(String text){
        return Arrays.stream(values())
                .filter(t -> t.text.equalsIgnoreCase(text))
                .findFirst().orElse(null);
    }
}
