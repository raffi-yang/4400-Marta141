package Controller;

import java.math.BigDecimal;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class BreezeCardController {

	@FXML
    	private TextField cardNum;
	@FXML
	private TextField owner;
	@FXML
	private TextField setValue;
	@FXML
	private TextField transferValue;
	@FXML
	private TextField value1;
	@FXML
	private TextField value2;
	
	@FXML
	private CheckBox suspended;

	public void back(ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.ADMIN);
	}

	public void reset() {
		// TODO
	}

	public void setValueOfCard() {
		// TODO
	}

	public void transfer() {
		// TODO
	}

	public void updateFilter() {
		double lowerMoney = 0;
		double uppermoney = 1000;
		String cardNumber = null;
		String ownerSearch = null;
		boolean suspendedCards = suspended.isSelected();

		String regex = "\\d+";
		
		if (!(value1.getText().isEmpty())) {
			try {
				lowerMoney = Double.parseDouble(value1.getText());
			} catch (Exception e) {
				Helper.showAlert("Error", "Please add numbers into the value field.");
				return;
			}
			
			if (lowerMoney > 1000) {
				Helper.showAlert("Error", "Added value cannot be more than $1000");
				return;
			} else if (lowerMoney < 0) {
				Helper.showAlert("Error", "Added value cannot be less than $0");
				return;
			}
			
		    boolean fail = (BigDecimal.valueOf(lowerMoney).scale() > 2);
		    
		    if (fail) {
				Helper.showAlert("Error", "Money cannot have more than 2 decimals places.");
				return;
		    }
		}
		
		if (!(value2.getText().isEmpty())) {
			try {
				uppermoney = Double.parseDouble(value2.getText());
			} catch (Exception e) {
				Helper.showAlert("Error", "Please add numbers into the value field.");
				return;
			}
			
			if (uppermoney > 1000) {
				Helper.showAlert("Error", "Added value cannot be more than $1000");
				return;
			} else if (uppermoney < 0) {
				Helper.showAlert("Error", "Added value cannot be less than $0");
				return;
			}
			
		    boolean fail = (BigDecimal.valueOf(uppermoney).scale() > 2);
		    
		    if (fail) {
				Helper.showAlert("Error", "Money cannot have more than 2 decimals places.");
				return;
		    }
		}
		if (lowerMoney > uppermoney) {
			Helper.showAlert("Error", "Lower value cannot be higher than higher value.");
			return;
		}
		
		if (!cardNum.getText().isEmpty()) {
			if (!(cardNum.getText().length() == 16)) {
				Helper.showAlert("Error", "Invalid credit card number length. (Remove spaces)");
				return;
			} else if (!(cardNum.getText().matches(regex))) {
				Helper.showAlert("Error", "Credit card numbers can only have numbers.");
				return;
			} else {
				cardNumber = cardNum.getText();
			}
		}
		
		if (!owner.getText().isEmpty()) {
			ownerSearch = owner.getText();
		}
		
	}
}
