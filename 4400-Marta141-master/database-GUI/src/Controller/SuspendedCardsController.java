package Controller;

import javafx.event.ActionEvent;

public class SuspendedCardsController {
	
	public void assignNew () {
		//TODO
	}
	
	public void assignOld () {
		//TODO
	}

	public void back (ActionEvent actionEvent) {
		Helper.changeScene(actionEvent, this.getClass(), Helper.ADMIN);
	}
}
