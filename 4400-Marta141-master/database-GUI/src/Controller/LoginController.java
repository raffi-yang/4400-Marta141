package Controller;

import DAO.DBUtil;
import DAO.UserDAO;
import Model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

	public TextField username;
	public PasswordField password;

	public void login(ActionEvent actionEvent) {
		if (username.getText().equals("") || password.getText().equals("")) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Missing credentials");
			alert.setHeaderText(null);
			alert.setContentText("Please enter username and password.\n\nRegister if you don't have an account.");

			alert.showAndWait();
			return;
		}

		// TODO: FINDUSER, RETURN USER OBJECT OR NULL
		//User currUser = UserDAO.findUserByUsername(username.getText());

		/*
		 * // if (currUser == null) { // Helper.showAlert("Error", "No account found.");
		 * // return; // } else if
		 * (!currUser.getPassword().equals((password.getText()))) { //
		 * Helper.showAlert("Error", "Password incorrect! Please enter again"); //
		 * return; // } TODO: Uncomment this ocne findusername has been completed
		 */
		/* else { */
		if (username.getText().contains("admin")) {
			Helper.changeScene(actionEvent, this.getClass(), Helper.ADMIN);
		} else {
			Helper.changeScene(actionEvent, this.getClass(), Helper.WELCOME);
		}//TODO change to actual admin and nonadmin check
	}

	public void register(ActionEvent actionEvent) throws IOException {
		Helper.changeScene(actionEvent, this.getClass(), Helper.REGISTER);
	}
}
