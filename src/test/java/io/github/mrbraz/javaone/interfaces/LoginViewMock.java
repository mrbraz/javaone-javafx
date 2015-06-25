package io.github.mrbraz.javaone.interfaces;

import javax.inject.Inject;

import io.github.mrbraz.javaone.intefaces.LoginPresenter.LoginCallback;
import io.github.mrbraz.javaone.intefaces.LoginPresenter.LoginView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewMock extends MockView implements LoginView {
  private LoginCallback callback;
  
  @Override
  public StringProperty username() {
    return new SimpleStringProperty();
  }

  @Override
  public StringProperty password() {
    return new SimpleStringProperty();
  }

  @Override
  public void onLogin(LoginCallback callback) {
    this.callback = callback;
  }
  
  public void login(){
    this.callback.onLogin();
  }
}