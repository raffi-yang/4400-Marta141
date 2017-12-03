package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

	private final static String PATH = "../fxml/";
	public static final String REGISTER = "registration.fxml";
	public static final String LOGIN = "login.fxml";
	public static final String ADMIN = "Administrator.fxml";
	public static final String BREEZE = "breezecardManagement.fxml";
	public static final String CREATE_STATION = "createNewStation.fxml";
	public static final String MANAGE_CARDS = "manageCards.fxml";
	public static final String PASSENGER_REPORT = "PassengerFlowReport.fxml";
	public static final String STATION_DETAILS = "stationDetails.fxml";
	public static final String STATION_LISTING = "stationListing.fxml";
	public static final String SUSPENDED_CARDS = "suspendedCards.fxml";
	public static final String TRIP_HISTORY = "tripHistory.fxml";
	public static final String WELCOME = "welcomeToMarta.fxml";

	private static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static void changeScene(ActionEvent actionEvent, Class c, String view) {
		try {
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

			// FXMLLoader loader = new
			// FXMLLoader(getClass().getResource("fxml/registration.fxml"));
			Parent root = FXMLLoader.load(c.getResource(PATH + view)); // Path

			Scene scene = new Scene(root);

			stageTheEventSourceNodeBelongs.setScene(scene);
			stageTheEventSourceNodeBelongs.show();
		} catch (IOException e) {
			showAlert("Error", "View not found");
		}
	}

	public static void showAlert(String title, String info) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(info);

		alert.showAndWait();

	}

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
