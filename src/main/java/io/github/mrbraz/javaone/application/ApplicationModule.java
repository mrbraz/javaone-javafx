package io.github.mrbraz.javaone.application;

import io.github.mrbraz.framework.infra.ioc.ExtendedModule;
import io.github.mrbraz.framework.infra.ioc.FXModule;

import java.util.ResourceBundle;

public class ApplicationModule extends ExtendedModule {

  @Override
  protected void configure() {
    this.install(new FXModule());
    this.bind(ResourceBundle.class).toInstance(ResourceBundle.getBundle("Application"));
  }
  
}
