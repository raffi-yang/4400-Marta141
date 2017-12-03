package Controller;

import java.math.BigDecimal;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class StationDetailsController {
	
	public TextField fare;
	
	public CheckBox openStation;

	public void back (ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.STATION_LISTING);
	}
	
	public void updateFare (ActionEvent actionEvent) {
		
		double newFare;
		
		try {
			newFare = Double.parseDouble(fare.getText());
		} catch (Exception e) {
			Helper.showAlert("Error", "Please add numbers into the fare field.");
			return;
		}
		
		if (newFare > 50 || newFare < 0) {
			Helper.showAlert("Error", "Added value cannot be more than $50 or less than $0");
			return;
		}
		
	    boolean fail = (BigDecimal.valueOf(newFare).scale() > 2);
	    
	    if (fail) {
			Helper.showAlert("Error", "Money cannot have more than 2 decimals places.");
			return;
	    }
		//TODO add statement
	}
	
	public void updateOpen() {
		if (openStation.isSelected()) {
			//TODO Selected means that it is checked
		} else {
			//TODO other query for when is not checked
		}
	}
}
