package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;

public class AdminController {
	public void StationManagement(ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.STATION_LISTING);
	}

	public void SuspendedCards(ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.SUSPENDED_CARDS);
	}

	public void BreezeCardManagement(ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.BREEZE);
	}

	public void PassengerFlowReport(ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.PASSENGER_REPORT);
	}

	public void logout(ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.LOGIN);
	}
}
