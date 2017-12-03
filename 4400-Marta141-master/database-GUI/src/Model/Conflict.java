package Model;

import javafx.beans.property.*;

import java.sql.Timestamp;
import java.sql.Date;
import java.sql.SQLData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import sun.util.resources.LocaleData;

import java.util.List;

public class Conflict {
	
    private final SimpleStringProperty userName;
    private final SimpleStringProperty cardNum;
    private final SimpleObjectProperty<Timestamp> dateTime;

    public Conflict(String name, String num, Timestamp time) {
    	this.userName = new SimpleStringProperty(name);
    	this.cardNum = new SimpleStringProperty(num);
    	this.dateTime = new SimpleObjectProperty<>(time);
    }
    
    public String getUserName() {
    	return userName.get();
    }
 
    public String getCardNum() {
    	return cardNum.get();
    }
 
    public Timestamp getDateTime() {
    	return dateTime.get();
    }

    public String toString() {
        String out = this.getUserName() + ", " + this.getCardNum() + ", " + this.getDateTime() + ", ";
        return out;
    }
}
