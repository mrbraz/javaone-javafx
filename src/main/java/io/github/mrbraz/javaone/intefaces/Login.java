package io.github.mrbraz.javaone.intefaces;

import io.github.mrbraz.javaone.intefaces.LoginPresenter.LoginView;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

import javax.inject.Singleton;

import reactfx.infra.FXView;
import reactfx.infra.ioc.ApplicationContext;
import reactfx.interfaces.ViewBase;

@Singleton
@FXView
class Login extends ViewBase implements LoginView {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private ProgressIndicator indicator;
	@FXML
	private Label message;
	
	public static Login create(){
	  return ApplicationContext.instanceOf(Login.class);
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
	
	@Override
	public StringProperty username() {
	  return this.username.textProperty();
	}
	
	@Override
	public StringProperty password() {
	  return this.password.textProperty();
	}
}