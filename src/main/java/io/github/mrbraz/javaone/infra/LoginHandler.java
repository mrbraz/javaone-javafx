package io.github.mrbraz.javaone.infra;

import io.github.mrbraz.javaone.domain.UserCredentials;
import io.github.mrbraz.javaone.intefaces.LoginService;

import javax.inject.Inject;

import reactivefx.infra.event.Channel;
import reactivefx.infra.ioc.ApplicationContext;

public class LoginHandler implements Channel<LoginEvent> {

  private @Inject LoginService loginService;
  
  public LoginHandler() {
    ApplicationContext.injectMembers(this);
  }
  
  @Override
  public void dispatch(LoginEvent event) {
    UserCredentials userCredentials = event.credentials();
    this.loginService.login(userCredentials);
  }
  
  @Override
  public Class<? extends LoginEvent> type() {
    return LoginEvent.class;
  }
}