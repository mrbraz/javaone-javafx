package io.github.mrbraz.javaone.application;

import io.github.mrbraz.javaone.intefaces.LoginPresenter.LoginView;
import io.github.mrbraz.javaone.interfaces.LoginViewMock;
import reactivefx.infra.ioc.ExtendedModule;

public class TestViewModule extends ExtendedModule {

  @Override
  protected void configure() {
    this.bind(LoginView.class).to(LoginViewMock.class);
  }
}