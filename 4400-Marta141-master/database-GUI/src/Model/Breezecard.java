package Model;

import javafx.beans.property.*;
import sun.util.resources.LocaleData;

import java.sql.Date;
import java.sql.SQLData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Breezecard {

    private final SimpleStringProperty cardNum;
    private final SimpleStringProperty cardOwner;
    private final SimpleDoubleProperty cardValue;

    public Breezecard(String num, double value, String owner) {
        this.cardNum = new SimpleStringProperty(num);
        this.cardValue = new SimpleDoubleProperty(value);
        this.cardOwner = new SimpleStringProperty(owner);
    }

    public String getCardNum() {
        return cardNum.get();
    }

    public String getCardOwner() {
        return cardOwner.get();
    }

    public double getCardValue() {
        return cardValue.get();
    }

    public void setCardValue(double newValue) {
        this.cardValue.set(newValue);
    }
    
    public void setCardOwner(String newOwner) {
        this.cardOwner.set(newOwner);
    }

}
