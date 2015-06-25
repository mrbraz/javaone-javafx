package io.github.mrbraz.javaone.intefaces;

import io.github.mrbraz.javaone.domain.UserCredentials;
import io.github.mrbraz.javaone.domain.UserProfile;

public interface LoginService {
  UserProfile login(UserCredentials credentials);
}
