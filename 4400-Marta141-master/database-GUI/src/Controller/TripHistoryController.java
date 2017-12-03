package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class TripHistoryController {
	
	@FXML
	private TextField startTime;
	@FXML
	private TextField endTime;
	
	public void back (ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.WELCOME);
	}
	
	public void reset (ActionEvent actionEvent) {
		//TODO
	}
	
	public void update (ActionEvent actionEvent) {
		String regex = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
		
		if (!(startTime.getText().matches(regex)) || !(endTime.getText().matches(regex))) {
			Helper.showAlert("Error", "One of the fields does not have a valid time in 24 hour format.");
			return;
		}
		//TODO
	}
}
