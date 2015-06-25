package io.github.mrbraz.javaone.application;

import io.github.mrbraz.javaone.domain.Credentials;
import io.github.mrbraz.javaone.domain.UserCredentials;
import io.github.mrbraz.javaone.intefaces.InMemoryLoginService;
import io.github.mrbraz.javaone.intefaces.LoginService;

import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import reactivefx.infra.ioc.ExtendedModule;

public class ApplicationModule extends ExtendedModule {

  @Override
  protected void configure() {
    this.bind(ExecutorService.class).toInstance(Executors.newWorkStealingPool());
    this.bind(ResourceBundle.class).toInstance(ResourceBundle.getBundle("Application"));
    this.bind(LoginService.class).to(InMemoryLoginService.class);
    this.bind(Credentials.class).toInstance(new UserCredentials("user", "pwd"));
  }
}