package Controller;

import java.sql.SQLException;

import javafx.event.ActionEvent;

public class StationListingsController {
	
	public void viewStation (ActionEvent actionEvent) {
		//TODO select the correct station, then go to station details
		Helper.changeScene(actionEvent, this.getClass(), Helper.STATION_DETAILS);
	}
	
    public void createNewStation (ActionEvent e) {
        Helper.changeScene(e, this.getClass(), Helper.CREATE_STATION);
    }
    
	public void back (ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.ADMIN);
	}
}
