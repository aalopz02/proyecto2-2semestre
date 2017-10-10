package ui;

import java.util.ArrayList;
import org.eclipse.swt.custom.CLabel:
import org.eclipse.swt.graphics.Image;

public class CrearFormas extends Formas {
	
	@Override
	protected CLabel condicion(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/condicion.png");
		CLabel label = new CLabel(ui.main.shell(), SWT.BORDER);
		label.setImage(imagen);
		return label;
	}

	@Override
	protected CLabel cicloWhile(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/While.png");
		CLabel label = new CLabel(ui.main.shell(), SWT.BORDER);
		label.setImage(imagen);
		return label;
		
	}

	@Override
	protected CLabel cicloFor(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/For.png");
		CLabel label = new CLabel(ui.main.shell(), SWT.BORDER);
		label.setImage(imagen);
		return label;
	
	}

	@Override
	protected CLabel definicionVariable(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/declaracion.png");
		CLabel label = new CLabel(ui.main.shell(), SWT.BORDER);
		label.setImage(imagen);
		return label;

	}

	@Override
	protected CLabel instruccionesVarias(ArrayList<String> lista) {
		Image imagen = new Image(ui.main.display(),"./src/img/metodoExterno.png");
		CLabel label = new CLabel(ui.main.shell(), SWT.BORDER);
		label.setImage(imagen);
		return label;
	
	}

}
