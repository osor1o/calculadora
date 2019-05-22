package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

import expr.Expr;
import expr.Parser;
import expr.SyntaxException;

public class IndexController implements Initializable {
	
	@FXML
    private TextField calculation;

    @FXML
    private Button comeBack;

    @FXML
    private Label historic;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	calculation.requestFocus();	
	}
	
	@FXML
	private void write(ActionEvent event) {
		String buttonValue = ((Labeled) event.getSource()).getText();
		calculation.appendText(buttonValue);
		this.focus(event);
	}
	
	@FXML
	private void clear(ActionEvent event) {
		calculation.setText("");
		this.focus(event);
	}
	
	@FXML
	private void equals(ActionEvent event) {
		try {
			Expr expr;
			String data = calculation.getText().toString();
		    expr = Parser.parse(data);
			Double result = expr.value();
			
			historic.setText(calculation.getText()+" = "+result.toString());
			calculation.setText(result.toString());
		} catch (SyntaxException e) {
			calculation.setText("ERRO!");
		}
		this.focus(event);
	}
	
	@FXML
	private void comeBack(ActionEvent event) {
		String[] string = historic.getText().split("=");
		calculation.setText(string[0].trim());
		this.focus(event);
	}
	
	@FXML
	private void focus(ActionEvent event) {
		calculation.requestFocus();
		calculation.end();
	}

}
