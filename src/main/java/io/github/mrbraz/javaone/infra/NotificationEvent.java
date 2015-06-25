package io.github.mrbraz.javaone.infra;

import reactivefx.infra.event.Event;

public class NotificationEvent implements Event {
  private String message;

  public NotificationEvent(String message) {
    super();
    this.message = message;
  }
  
  public String message() {
    return message;
  }
}