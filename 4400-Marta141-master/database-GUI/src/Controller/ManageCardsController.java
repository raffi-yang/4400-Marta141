package Controller;

import java.math.BigDecimal;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ManageCardsController {
	
	@FXML
	private TextField addedCard;
	@FXML
	private TextField creditCard;
	@FXML
	private TextField value;
	
	public void addCard (ActionEvent actionEvent) {
		String regex = "\\d+";
		
		if (!(addedCard.getText().length() == 16)) {
			Helper.showAlert("Error", "Invalid breeze card number length. (Remove spaces)");
			return;
		} else if (!(addedCard.getText().matches(regex))) {
			Helper.showAlert("Error", "Breeze card numbers can only have numbers.");
			return;
		}
		
		//TODO
	}
	
	public void addValue (ActionEvent actionEvent) {
		String regex = "\\d+";
		double addedValue = 0;
		
		if (!(addedCard.getText().length() == 16)) {
			Helper.showAlert("Error", "Invalid credit card number length. (Remove spaces)");
			return;
		} else if (!(addedCard.getText().matches(regex))) {
			Helper.showAlert("Error", "Credit card numbers can only have numbers.");
			return;
		}
		
		try {
			addedValue = Double.parseDouble(value.getText());
		} catch (Exception e) {
			Helper.showAlert("Error", "Please add numbers into the value field.");
			return;
		}
		
		if (addedValue > 1000) {
			Helper.showAlert("Error", "Added value cannot be more than $1000");
			return;
		}
		
	    boolean fail = (BigDecimal.valueOf(addedValue).scale() > 2);
	    
	    if (fail) {
			Helper.showAlert("Error", "Money cannot have more than 2 decimals places.");
			return;
	    }
		
		//TODO
	}
	
	public void back (ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.WELCOME);
	}
}
