package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SampleController {
	
	@FXML private Button butBaseCase; 
	@FXML private Button butOwnCase;
	@FXML private Button butSolution;
	
	@FXML private TextArea txtSolution;																					
	@FXML private TextArea txtCase;
	
	public SampleController() {
		
	}
	
	public void initialize() {
		butBaseCase.setOnAction(e->{
			baseCaseMethod();
		});
		butOwnCase.setOnAction(e->{
			ownCaseMethod();
		});
		butSolution.setOnAction(e->{
			showSolution();
		});
	}
	
	public void baseCaseMethod() {
		
	}
	
	public void ownCaseMethod() {
		
	}
	
	public void showSolution() {
		
	}
	
}
