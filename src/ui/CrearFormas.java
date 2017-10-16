package ui;

import java.util.ArrayList;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

import funciones.Grafo;

public class CrearFormas extends Formas {
	GC gc = new GC(ui.main.canvas);
	uiController fondo = new uiController();
	
	protected void crearFlechas(Grafo objeto) {
		int y = objeto.getContenido().height;
		int x = objeto.getContenido().width - 50;
		System.out.println(x);
		System.out.println(y);
		//gc.setForeground(new Color(ui.main.shell.getDisplay(), 255, 255, 200));
		int[] puntosFlecha = { x - 10, y, x - 15, y - 5, x - 10, y, x - 15, y + 5};
		gc.setForeground(new Color(ui.main.shell.getDisplay(), 0, 0, 0));
		gc.drawPolyline(puntosFlecha);
		
	}

	@Override
	protected void condicion(Grafo objeto) {
		fondo.cambiarEtiqueta( "./src/img/condicion.png");
		crearFlechas(objeto);
		
		
	}

	@Override
	protected void cicloWhile(Grafo objeto) {
		fondo.cambiarEtiqueta( "./src/img/While.png");
		crearFlechas(objeto);
		
	}

	@Override
	protected void cicloFor(Grafo objeto) {
		fondo.cambiarEtiqueta( "./src/img/For.png");
		crearFlechas(objeto);
		
	}

	@Override
	protected void definicionVariable(Grafo objeto) {
		fondo.cambiarEtiqueta( "./src/img/declaracion.png");
		crearFlechas(objeto);
		
	}

	@Override
	protected void instruccionesVarias(Grafo objeto) {
		fondo.cambiarEtiqueta( "./src/img/metodoExterno.png");
		crearFlechas(objeto);
		
	}

}
