package Controller;

import java.sql.SQLException;
import java.util.*;

import DAO.DBUtil;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import Model.User;

import DAO.UserDAO;

import javax.swing.*;


public class RegisterController {
    @FXML
    private Pane registration;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField cardNum;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;
    @FXML
    private Button create;
    @FXML
    private Button cancel;
    @FXML
    private RadioButton existing;
    @FXML
    private RadioButton newCard;
    @FXML
    private ToggleGroup group;

    @FXML
    private void initialize () throws SQLException, ClassNotFoundException{
    }

    /*
     *  The handler for the create button. Check the validity of each field and pass the
     *  new record into the database.
     */
    @FXML
    public void handleCreateClick(ActionEvent ae){
    	boolean emptyField = false;
        // Check the validity of all input fields
        if (username.getText().trim().isEmpty()) {
            Helper.showAlert("Error", "Username cannot be empty.");
            return;
        }
        if (email.getText().trim().isEmpty()) {
            Helper.showAlert("Error","Email cannot be empty");
            return;
        }
        if (Helper.validateEmail(email.getText())) {
            Helper.showAlert("Error","Please use a valid email address.");
            return;
        }
        if (password.getText().trim().isEmpty()) {
            Helper.showAlert("Error","Password cannot be empty.");
            return;
        }
        if (password.getText().length() < 8) {
            Helper.showAlert("Error","Password need to be greater than 7 characters.");
            return;
        }
        if (password2.getText().trim().isEmpty()) {
            Helper.showAlert("Error","Please confirm your password.");
            return;
        }
        if (!password.getText().equals(password2.getText())) {
            Helper.showAlert("Error","Passwords do not match.");
            return;
        }
        
		existing.setToggleGroup(group);
		newCard.setToggleGroup(group);
        
		if (!(group.getSelectedToggle() == existing) && !(group.getSelectedToggle() == newCard)) {
			Helper.showAlert("Error", "You need to select whether this is a train or bus station.");
			return;
		} else if ((group.getSelectedToggle() == existing) && cardNum.getText().isEmpty()) {
			Helper.showAlert("Error", "Intersection cannot be empty if bus station is selected.");
			return;
		} else {
			// TODO all that needs to be done now is the addition to the DB...i think...im really tired at this point
		}
//        System.out.println(city.getSelectionModel().getSelectedItem().getClass());


        User temp = new User(username.getText(), password.getText(), false);


        // Insert the new user to database, return the result of the insertion
//        try {
////            Helper.showAlert("Error", "B");
//            UserDAO.insertUser(temp);
//        } catch (Exception e) {
//            System.out.println("~~~");
//            Helper.showAlert("Error", "A");
//
//        }
        try {
            UserDAO.insertUser(temp);
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
            Helper.showAlert("Error", e.getMessage());
            return;

        } catch (SQLException e) {
//            e.printStackTrace();
            Helper.showAlert("Database Error", e.getMessage());
            return;

        }

        Helper.changeScene(ae, this.getClass(), Helper.LOGIN);


    }

    /*
     *  The handler for the cancel button. Simply close the window.
     */
    @FXML
    public void handleCancelClick(ActionEvent e) throws SQLException, ClassNotFoundException {
        Helper.changeScene(e, this.getClass(), Helper.LOGIN);
    }
}
