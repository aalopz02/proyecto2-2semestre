package ui;

import java.util.ArrayList;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

import funciones.Grafo;

public class CrearFormas extends Formas {
	GC gc = new GC(ui.main.canvas);
	
	protected void crearFlechas() {
		gc.setForeground(new Color(ui.main.shell.getDisplay(), 255, 255, 200));
		gc.drawRectangle(5,5,45,45);
		gc.setForeground(new Color(ui.main.shell.getDisplay(), 0, 0, 0));
		gc.drawRectangle(50,50,45,45);
	    gc.dispose();
		
	}

	@Override
	protected void condicion(Grafo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void cicloWhile(Grafo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void cicloFor(Grafo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void definicionVariable(Grafo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void instruccionesVarias(Grafo objeto) {
		// TODO Auto-generated method stub
		
	}

}
