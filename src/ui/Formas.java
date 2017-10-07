package ui;

import java.util.ArrayList;

import org.eclipse.swt.graphics.Image;

public abstract class Formas {
	
	protected abstract Image condicion(ArrayList<String> lista);
	protected abstract Image cicloWhile(ArrayList<String> lista);
	protected abstract Image cicloFor(ArrayList<String> lista);
	protected abstract Image definicionVariable(ArrayList<String> lista);
	protected abstract Image instruccionesVarias(ArrayList<String> lista);
	
}
