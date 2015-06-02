package io.github.mrbraz.javaone.application;

import java.util.ResourceBundle;

import reactfx.infra.ioc.ExtendedModule;
import reactfx.infra.ioc.FXModule;

public class ApplicationModule extends ExtendedModule {

  @Override
  protected void configure() {
    this.install(new FXModule());
    this.bind(ResourceBundle.class).toInstance(ResourceBundle.getBundle("Application"));
  }
  
}
