package io.github.mrbraz.framework.infra.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Container {
	private static Injector injector;
	
	private Container() {
		super();
	}
	
	public static void init(Module... modules){
		Container.injector = Guice.createInjector(modules);
	}

	public static <T> T instanceOf(Class<T> clazz) {
		return Container.injector.getInstance(clazz);
	}

	public static void injectMembers(Object object) {
		Container.injector.injectMembers(object);
	}
}