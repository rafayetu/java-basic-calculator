package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class InterfaceController implements Initializable{
    private double result = 0;
    private double firstNumber, secondNumber;
    private char operationChar;
    private boolean calculate = false;
    
    @FXML
    private TextField inputDisplay;

    @FXML
    private Label labelDisplay;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	inputDisplay.setText("0");
    }
        
    @FXML
    private void inputNumber(ActionEvent event) {
     	if (inputDisplay.getText().contentEquals("0")) {    		
    		inputDisplay.setText("");
    	}
    	inputDisplay.appendText(((Button) event.getSource()).getText());
    }
    
    @FXML
    private void addOperation(ActionEvent event) {
    	if (calculate) {
    		this.calculateResult(event);
    	}
    	String inputNumber = inputDisplay.getText();
    	firstNumber = Double.parseDouble(inputNumber);
    	inputDisplay.setText("0");
    	operationChar = ((Button) event.getSource()).getText().charAt(0);
    	labelDisplay.setText(inputNumber + operationChar);
    	calculate = true;
    }
        
    @FXML
    private void positiveToNegative(ActionEvent event) {
		firstNumber = Double.parseDouble(inputDisplay.getText());
		firstNumber = firstNumber * (-1);
		inputDisplay.setText(String.valueOf(firstNumber));
	}

    @FXML
    private void eraseAll(ActionEvent event) {
		firstNumber = 0;
		secondNumber = 0;
		inputDisplay.setText("0");
		labelDisplay.setText("");
		operationChar = 0;
		calculate = false;
    }
    
    @FXML
    private void calculateResult(ActionEvent event) {
		secondNumber = Double.parseDouble(inputDisplay.getText());
		switch (operationChar) {
		case '+':
			result = firstNumber + secondNumber;
			break;
		case '-':
			result = firstNumber - secondNumber;
			break;
		case '*':
			result = firstNumber * secondNumber;
			break;
		case '/':
			result = firstNumber / secondNumber;
			break;
		default:
			inputDisplay.setText("Error");    			
		}
		labelDisplay.setText(labelDisplay.getText() + inputDisplay.getText() + "=");
		inputDisplay.setText(String.valueOf(result));


    	
    }


}
