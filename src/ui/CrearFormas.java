package ui;

import java.util.ArrayList;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class CrearFormas extends Formas {
	
	@Override
	protected Image condicion(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/condicion.png");
		return imagen;
	}

	@Override
	protected Image cicloWhile(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/While.png");
		return imagen;
		
	}

	@Override
	protected Image cicloFor(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/For.png");
		return imagen;
	
	}

	@Override
	protected Image definicionVariable(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/declaracion.png");
		return imagen;

	}

	@Override
	protected Image instruccionesVarias(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/metodoExterno.png");
		return imagen;
	
	}

}
