package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CreateStationController {

	public TextField StationName;
	public TextField StopID;
	public TextField EntryFare;
	public TextField StationType;

	public ToggleGroup grouping;
	public RadioButton BusStation;
	public RadioButton TrainStation;

	public CheckBox openStation;

	public void back(ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.STATION_LISTING);
	}

	public void createClicked() {
		BusStation.setToggleGroup(grouping);
		TrainStation.setToggleGroup(grouping);

		if (StationName.getText().isEmpty() || StopID.getText().isEmpty() || EntryFare.getText().isEmpty()) {
			Helper.showAlert("Error", "One or more textfields are empty.");
			return;
		} else if (!(grouping.getSelectedToggle() == BusStation) && !(grouping.getSelectedToggle() == TrainStation)) {
			Helper.showAlert("Error", "You need to select whether this is a train or bus station.");
			return;
		} else if ((grouping.getSelectedToggle() == BusStation) && StationType.getText().isEmpty()) {
			Helper.showAlert("Error", "Intersection cannot be empty if bus station is selected.");
			return;
		} else {
			// TODO all that needs to be done now is the addition to the DB...i think...im really tired at this point
		}
	}
}