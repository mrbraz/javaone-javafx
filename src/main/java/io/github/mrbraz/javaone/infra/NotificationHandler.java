package io.github.mrbraz.javaone.infra;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import reactivefx.application.FXRunner;
import reactivefx.infra.event.Channel;

public class NotificationHandler implements Channel<NotificationEvent> {

  @Override
  public void dispatch(NotificationEvent event) {
    FXRunner.run(new Runnable() {
      @Override
      public void run() {
        Alert alert = new Alert(AlertType.ERROR, event.message());
        alert.show();
      }
    });
  }

  @Override
  public Class<? extends NotificationEvent> type() {
    return NotificationEvent.class;
  }
}
