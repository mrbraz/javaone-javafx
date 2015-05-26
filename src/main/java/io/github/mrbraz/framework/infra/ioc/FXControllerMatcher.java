package io.github.mrbraz.framework.infra.ioc;

import io.github.mrbraz.framework.infra.FXController;
import io.github.mrbraz.framework.interfaces.Controller;

import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import com.google.inject.Inject;
import com.google.inject.ProvisionException;
import com.google.inject.TypeLiteral;

public class FXControllerMatcher extends Listener<Object> {

	public boolean matches(TypeLiteral<?> type) {
		return type.getRawType().isAnnotationPresent(FXController.class);
	}
	
	@Override
	protected Class<? extends PostInjection<Object>> observer() {
		return FXControllerPostInjection.class;
	}
	
	static class FXControllerPostInjection implements PostInjection<Object> {
		@Inject
		private FXMLLoader loader;
		
		public void visit(Object instance) {
			Class<?> clazz = instance.getClass();
			String fxmlFilePath = "/" + this.toFileNotation(clazz.getName()) + ".fxml";
			InputStream input = clazz.getResourceAsStream(fxmlFilePath);
			
			if(!(instance instanceof Controller)){
			  throw new ProvisionException("Your FXController must derive " + Controller.class.toString());
			}
			
			this.loader.setController(instance);
			
			try {
        ((Controller)instance).setRoot((Parent) this.loader.load(input));
      } catch (IOException e) {
        throw new ProvisionException("An internal error has been occurred.", e);
      }
		}
		
		private String toFileNotation(String javaNotation){
			return javaNotation.replace(".", "/");
		}
	}
}