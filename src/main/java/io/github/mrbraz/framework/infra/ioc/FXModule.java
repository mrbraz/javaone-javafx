package io.github.mrbraz.framework.infra.ioc;

import javafx.fxml.FXMLLoader;

import com.google.inject.AbstractModule;

public class FXModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(FXMLLoader.class).toProvider(FXMLLoaderProvider.class);
		new FXControllerMatcher().bindTo(this.binder());;
	}
}