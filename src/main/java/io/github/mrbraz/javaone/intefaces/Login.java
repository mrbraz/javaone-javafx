package io.github.mrbraz.javaone.intefaces;

import io.github.mrbraz.javaone.infra.TerminationEvent;
import io.github.mrbraz.javaone.intefaces.LoginPresenter.LoginCallback;
import io.github.mrbraz.javaone.intefaces.LoginPresenter.LoginView;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

import javax.inject.Inject;
import javax.inject.Singleton;

import reactivefx.infra.FXView;
import reactivefx.infra.event.EventBus;
import reactivefx.interfaces.ViewBase;

@Singleton @FXView
public class Login extends ViewBase implements LoginView {
	private @FXML TextField username;
	private @FXML PasswordField password;
	private @FXML ProgressIndicator indicator;
	private @FXML Label message;
	private @Inject EventBus eventBus;
	private LoginCallback callback;
	
	@FXML private void initialize(){
	  this.switchMessageVisibility();
	}
	@FXML private void handleLogin() {
	  this.switchMessageVisibility();
	  this.message.setText("Login in progress");
	  this.callback.onLogin();
	}
	@FXML private void handleCancel() {
		this.eventBus.dispatch(new TerminationEvent());
	}
	public StringProperty username() {
	  return this.username.textProperty();
	}
	public StringProperty password() {
	  return this.password.textProperty();
	}
	private void switchMessageVisibility(){
	  this.indicator.setVisible(!this.indicator.isVisible());
    this.message.setVisible(!this.message.isVisible());
	}
  public void onLogin(LoginCallback callback) {
    this.callback = callback;
  }
}