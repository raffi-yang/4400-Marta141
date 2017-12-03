package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class PassengerReportController {
	
	public TextField start;
	public TextField end;
	
	public void back (ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.ADMIN);
	}
	
	public void update() {
		String regex = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
		
		if (!(start.getText().matches(regex)) || !(end.getText().matches(regex))) {
			Helper.showAlert("Error", "Please enter a valid time in 24 hour format.");
			return;
		}
		//TODO
	}
	
	public void reset() {
		//TODO
	}
}
