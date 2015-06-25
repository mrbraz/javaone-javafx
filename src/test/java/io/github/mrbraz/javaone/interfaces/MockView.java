package io.github.mrbraz.javaone.interfaces;

import javafx.scene.Parent;
import reactivefx.interfaces.View;

public class MockView implements View {

  @Override
  public void setRoot(Parent root) {
    //Do nothing
  }

  @Override
  public Parent getRoot() {
    return null;
  }

  @Override
  public void attach() {
    //Do nothing
  }

  @Override
  public void detach() {
    //Do nothing
  }
}