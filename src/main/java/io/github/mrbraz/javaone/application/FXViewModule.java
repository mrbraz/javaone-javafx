package io.github.mrbraz.javaone.application;

import io.github.mrbraz.javaone.intefaces.Login;
import io.github.mrbraz.javaone.intefaces.LoginPresenter.LoginView;
import reactivefx.infra.ioc.ExtendedModule;
import reactivefx.infra.ioc.FXModule;

public class FXViewModule extends ExtendedModule {

  @Override
  protected void configure() {
    this.install(new FXModule());
    this.bind(LoginView.class).to(Login.class);
  }
}