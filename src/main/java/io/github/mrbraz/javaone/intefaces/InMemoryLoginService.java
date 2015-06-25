package io.github.mrbraz.javaone.intefaces;

import io.github.mrbraz.javaone.domain.Permission;
import io.github.mrbraz.javaone.domain.UserCredentials;
import io.github.mrbraz.javaone.domain.UserProfile;
import io.github.mrbraz.javaone.infra.NotificationEvent;

import javax.inject.Inject;

import reactivefx.infra.event.EventBus;

public class InMemoryLoginService implements LoginService {

  @Inject
  private EventBus eventBus;
  
  @Override
  public UserProfile login(UserCredentials credentials) {
    if(!(credentials.username().equals("admin") && credentials.password().equals("admin"))) {
      this.eventBus.dispatch(new NotificationEvent("Invalid credentials"));
      return null;
    }
    
    UserProfile profile = new UserProfile();
    
    for(Permission permission : Permissions.values()){
      profile.add(permission);
    }
    
    return profile;
  }
  
  enum Permissions implements Permission{
    READ("read:*"), WRITE("write:*"), PRINT("print:*");
    
    private String wildcard;
    
    private Permissions(String wildcard) {
      this.wildcard = wildcard;
    }

    @Override
    public String wildcard() {
      return this.wildcard;
    }
  }
}