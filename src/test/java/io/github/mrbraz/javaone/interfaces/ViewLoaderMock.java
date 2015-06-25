package io.github.mrbraz.javaone.interfaces;

import reactivefx.interfaces.View;
import reactivefx.interfaces.ViewLoader;

public class ViewLoaderMock implements ViewLoader {

  @Override
  public void load(View view) {
    view.attach();
  }
}
