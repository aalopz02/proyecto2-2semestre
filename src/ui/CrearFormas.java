package ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import funciones.Grafo;

public class CrearFormas extends funciones.Formas {
	GC gc = new GC(ui.main.canvas);
	uiController fondo = new uiController();
	
	protected void crearFlechas(Grafo objetoSiguiente, String anterior) {
		Grafo objetoAnterior ;
		if (anterior.equals("a")) {
			objetoAnterior =(Grafo) objetoSiguiente.next();
			
		}
		else {
			objetoAnterior =(Grafo) objetoSiguiente.getPrevio();
			
		}
			int x;
			int y;
			if (objetoAnterior != null) {
				y = objetoAnterior.getContenido().height;
				x = objetoAnterior.getContenido().width - 50;
				gc.setForeground(new Color(ui.main.shell.getDisplay(), 255, 255, 255));
				int[] puntosFlecha = { x - 10, y, x - 15, y - 5, x - 10, y, x - 15, y + 5};
				gc.drawPolyline(puntosFlecha);
			}
			y = objetoSiguiente.getContenido().height;
			x = objetoSiguiente.getContenido().width - 50;
			int[] puntosFlecha = { x - 10, y, x - 15, y - 5, x - 10, y, x - 15, y + 5};
			gc.setForeground(new Color(ui.main.shell.getDisplay(), 0, 0, 0));
			gc.drawPolyline(puntosFlecha);
			
		}
		
	@Override
	protected void condicion(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/condicion.png", objeto);
		crearFlechas(objeto, anterior);
		
		
	}

	@Override
	protected void cicloWhile(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/While.png", objeto);
		crearFlechas(objeto, anterior);
		
	}

	@Override
	protected void cicloFor(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/For.png", objeto);
		crearFlechas(objeto, anterior);
		
	}

	@Override
	protected void definicionVariable(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/declaracion.png", objeto);
		crearFlechas(objeto, anterior);
		
	}

	@Override
	protected void instruccionesVarias(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/metodoExterno.png", objeto);
		crearFlechas(objeto, anterior);
		
	}

}
