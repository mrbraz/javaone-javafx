package io.github.mrbraz.javaone.interfaces;

import io.github.mrbraz.javaone.application.ApplicationModule;
import io.github.mrbraz.javaone.application.TestViewModule;
import io.github.mrbraz.javaone.intefaces.LoginPresenter;
import io.github.mrbraz.javaone.intefaces.LoginPresenter.LoginCallback;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import reactivefx.infra.ioc.ApplicationContext;

public class LoginPresenterTest {
  @Before public void setup(){
    ApplicationContext.init(new ApplicationModule(), new TestViewModule());
  }
  
  boolean passed = false;
  
  @Test public void loginTest(){
    LoginPresenter presenter = ApplicationContext.instanceOf(LoginPresenter.class);
    ViewLoaderMock viewLoader = ApplicationContext.instanceOf(ViewLoaderMock.class);
    presenter.go(viewLoader);
    
    LoginViewMock mock = (LoginViewMock) presenter.view();
    mock.onLogin(new LoginCallback() {
      @Override
      public void onLogin() {
        passed = true;
      }
    });
    mock.login();
    Assert.assertTrue(passed);
  }
}
