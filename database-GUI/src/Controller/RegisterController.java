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
    private PasswordField password;
    @FXML
    private PasswordField password2;
    @FXML
    private Button create;
    @FXML
    private Button cancel;

    @FXML
    private void initialize () throws SQLException, ClassNotFoundException{
    }

    /*
     *  The handler for the create button. Check the validity of each field and pass the
     *  new record into the database.
     */
    @FXML
    public void handleCreateClick(ActionEvent ae){

        // Check the validity of all input fields
        if (username.getText().trim().isEmpty()) {
//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Information Dialog");
//            alert.setHeaderText(null);
//            alert.setContentText("Username cannot be empty");

//            alert.showAndWait();
             Helper.showAlert("A", "a");
            return;
        }
        if (email.getText().trim().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Email cannot be empty");

            alert.showAndWait();
            return;
        }
        if (!email.getText().contains("@")) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please use a valid email address");

            alert.showAndWait();
            return;
        }
        if (password.getText().trim().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Password cannot be empty");

            alert.showAndWait();
            return;
        }
        if (password2.getText().trim().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please confirm your password");

            alert.showAndWait();
            return;
        }
        if (!password.getText().equals(password2.getText())) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Passwords do not match. Please double check");

            alert.showAndWait();
            return;
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
    public void handleCancelClick(ActionEvent e) throws SQLException, ClassNotFoundException{
        Helper.changeScene(e, this.getClass(), Helper.LOGIN);
    }
}
