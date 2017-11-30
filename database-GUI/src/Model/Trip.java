package Model;

import javafx.beans.property.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Trip {

    private final SimpleDoubleProperty fare;
    private final SimpleObjectProperty<Timestamp> dateTime;
    private final SimpleStringProperty cardNum;
    private final SimpleStringProperty startStationID;
    private final SimpleStringProperty endStationID;

    public Trip(double fare, Timestamp dateTime, String cardNum, String startStationID, String endStationID) {
        this.fare = new SimpleDoubleProperty(fare);
        this.dateTime = new SimpleObjectProperty<>(dateTime);
        this.cardNum = new SimpleStringProperty(cardNum);
        this.startStationID = new SimpleStringProperty(startStationID);
        this.endStationID = new SimpleStringProperty(endStationID);
    }

    public Double getTripFare() {
        return fare.get();
    }

    public Timestamp getTripTime() {
        return dateTime.get();
    }
    
    public String getCardNum() {
    	return cardNum.get();
    }

    public String getTripStartStationID () {
        return startStationID.get();
    }

    public String getTripEndStationID() {
        return endStationID.get();
    }
    
    public void setTripFare(double newFare) {
    	fare.set(newFare);
    }
    
    public void setTripTime(Timestamp time) {
    	dateTime.set(time);
    }
    
    public void setTripCardNum(String num) {
    	cardNum.set(num);
    }
    
    public void setTripStartStationID(String stationID) {
    	startStationID.set(stationID);
    }
    
    public void setTripEndStationID(String stationID) {
    	endStationID.set(stationID);
    }


    public String toString() {
        String out = this.getTripFare() + ", " + this.getTripTime() + ", " + this.getTripStartStationID() + ", "
                + this.getTripEndStationID();
        return out;
    }


}
