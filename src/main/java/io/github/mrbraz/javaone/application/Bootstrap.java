package io.github.mrbraz.javaone.application;

import io.github.mrbraz.javaone.intefaces.LoginPresenter;
import javafx.application.Application;
import javafx.stage.Stage;
import reactfx.infra.ioc.ApplicationContext;
import reactfx.interfaces.ViewPane;

public class Bootstrap extends Application {
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    ApplicationContext.init(new ApplicationModule());
    ViewPane viewPane = ViewPane.create(primaryStage);
    ApplicationContext.instanceOf(LoginPresenter.class).go(viewPane);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    Bootstrap.launch(args);
  }
}