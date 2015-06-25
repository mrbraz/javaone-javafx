package io.github.mrbraz.javaone.infra;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import reactivefx.infra.event.Channel;

public class TerminationHandler implements Channel<TerminationEvent> {

  @Override
  public void dispatch(TerminationEvent event) {
    Alert alert = new Alert(AlertType.CONFIRMATION, "This action will stop the application, are you sure?");
    alert.showAndWait()
      .filter(response -> response == ButtonType.OK)
      .ifPresent(response -> System.exit(0));
  }

  @Override
  public Class<? extends TerminationEvent> type() {
    return TerminationEvent.class;
  }
}