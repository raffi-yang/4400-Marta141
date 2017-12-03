package Model;

import javafx.beans.property.*;
import sun.util.resources.LocaleData;

import java.sql.Date;
import java.sql.SQLData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Station {

    private final SimpleStringProperty stationID;
    private final SimpleStringProperty stationName;
    private final SimpleDoubleProperty fare;
    private final SimpleBooleanProperty closedStatus;
    private final SimpleBooleanProperty isTrain;

    public Station(String stationID, String stationName, double fare, boolean closedStatus, boolean isTrain ) {
        this.stationID = new SimpleStringProperty(stationID);
        this.stationName = new SimpleStringProperty(stationName);
        this.fare = new SimpleDoubleProperty(fare);
        this.closedStatus = new SimpleBooleanProperty(closedStatus);
        this.isTrain = new SimpleBooleanProperty(isTrain);
    }

    public String getStationID() {
        return stationID.get();
    }

    public String getStationName() {
        return stationName.get();
    }

    public double getFare() {
        return fare.get();
    }

    public boolean getClosedStatus() {
        return closedStatus.get();
    }
    
    public boolean isTrain() {
    	return isTrain.get();
    }
    
    public void setFare(double newFare) {
    	this.fare.set(newFare);
    }
    
    public void setClosedStatus(boolean status) {
    	this.closedStatus.set(status);
    }
}

