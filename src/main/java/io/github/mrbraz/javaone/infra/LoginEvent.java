package io.github.mrbraz.javaone.infra;

import io.github.mrbraz.javaone.domain.UserCredentials;
import reactivefx.infra.event.Event;

public class LoginEvent implements Event {
  private UserCredentials credentials;

  public LoginEvent(UserCredentials credentials) {
    super();
    this.credentials = credentials;
  }
  
  public UserCredentials credentials() {
    return credentials;
  }
}