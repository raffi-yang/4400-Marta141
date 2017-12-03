package Controller;

import javafx.event.ActionEvent;

public class WelcomeController {
	
	public void endTrip (ActionEvent actionEvent) {
		//TODO
	}
	
	public void logout (ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.LOGIN);
	}
	
	public void manageCards (ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.MANAGE_CARDS);
	}
	
	public void viewTripHistory (ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.TRIP_HISTORY);
	}
}
