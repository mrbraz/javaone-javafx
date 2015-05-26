package io.github.mrbraz.javaone.intefaces;

import io.github.mrbraz.framework.infra.FXController;
import io.github.mrbraz.framework.infra.ioc.Container;
import io.github.mrbraz.framework.interfaces.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

import javax.inject.Singleton;

@FXController
@Singleton
public class Login extends Controller {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private ProgressIndicator indicator;
	@FXML
	private Label message;
	
	public static Login create(){
	  return Container.instanceOf(Login.class);
	}
	
	@FXML
	private void initialize(){
	  this.indicator.setVisible(false);
	  this.message.setVisible(false);
	}

	@FXML
	private void handleLogin() {
	  
	}

	@FXML
	private void handleCancel() {
		System.exit(0);
	}
}