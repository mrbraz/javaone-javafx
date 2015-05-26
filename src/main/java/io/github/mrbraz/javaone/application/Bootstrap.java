package io.github.mrbraz.javaone.application;

import io.github.mrbraz.framework.infra.ioc.Container;
import io.github.mrbraz.javaone.intefaces.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Bootstrap extends Application {
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    Container.init(new ApplicationModule());
    Login login = Login.create();
    Scene scene = new Scene(login.getRoot());
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    Bootstrap.launch(args);
  }
}