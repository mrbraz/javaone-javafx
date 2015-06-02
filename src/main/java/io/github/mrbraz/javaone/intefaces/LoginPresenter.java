package io.github.mrbraz.javaone.intefaces;

import com.google.inject.Singleton;

import javafx.beans.property.StringProperty;
import reactfx.interfaces.Presenter;
import reactfx.interfaces.View;

@Singleton
public class LoginPresenter extends Presenter<Login>{

  protected LoginPresenter() {
    super(Login.create());
  }
  
  public static interface LoginView extends View {
    StringProperty username();
    
    StringProperty password();
  }
}