package io.github.mrbraz.javaone.domain;

public class UserCredentials implements Credentials {
  private final String username;
  
  private final String password;

  public UserCredentials(String username, String password) {
    super();
    this.username = username;
    this.password = password;
  }
  
  public String password() {
    return password;
  }
  
  public String username() {
    return username;
  }
}