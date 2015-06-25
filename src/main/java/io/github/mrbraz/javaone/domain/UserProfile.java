package io.github.mrbraz.javaone.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserProfile implements Profile {
  private final List<Permission> permissions;

  public UserProfile() {
    this.permissions = new ArrayList<Permission>();
  }
  
  public void add(Permission permission){
    this.permissions.add(permission);
  }
  
  @Override
  public Collection<Permission> permissions() {
    return Collections.unmodifiableCollection(this.permissions);
  }
}

