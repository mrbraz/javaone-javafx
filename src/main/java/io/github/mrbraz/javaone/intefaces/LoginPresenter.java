package io.github.mrbraz.javaone.intefaces;

import io.github.mrbraz.javaone.domain.Credentials;
import io.github.mrbraz.javaone.domain.UserCredentials;
import io.github.mrbraz.javaone.infra.LoginEvent;
import io.github.mrbraz.javaone.infra.LoginHandler;
import io.github.mrbraz.javaone.intefaces.LoginPresenter.LoginView;
import javafx.beans.property.StringProperty;

import javax.inject.Inject;

import reactivefx.infra.event.EventBus;
import reactivefx.interfaces.Presenter;
import reactivefx.interfaces.View;

import com.google.inject.Singleton;

@Singleton
public class LoginPresenter extends Presenter<LoginView> {
  private @Inject EventBus eventBus;
  private @Inject LoginView view;
  private @Inject Credentials remembered;

  @Inject void init() {
    this.eventBus.register(new LoginHandler());
    this.set(this.view);
    this.view.onLogin(new LoginCallback() {
      @Override
      public void onLogin() {
        UserCredentials credentials = new UserCredentials(view.username().get(), view.password().get());
        eventBus.asyncDispatch(new LoginEvent(credentials));
      }
    });
    this.view.username().set(this.remembered.username());
    this.view.password().set(this.remembered.password());
  }

  public static interface LoginView extends View {
    StringProperty username();

    StringProperty password();

    void onLogin(LoginCallback callback);
  }

  public static interface LoginCallback {
    void onLogin();
  }
}