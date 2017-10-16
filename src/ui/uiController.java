package ui;

import org.eclipse.swt.graphics.Image;

public class uiController {

	public void cambiarEtiqueta(String archivo) {
		Image image = new Image(ui.main.shell.getDisplay(), archivo);
		ui.main.etiqueta.setBackgroundImage(image);
		
	}
	
}
