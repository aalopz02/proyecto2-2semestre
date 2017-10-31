package ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import funciones.Grafo;

public class CrearFormas extends funciones.Formas {
	GC gc = new GC(ui.main.canvas);
	uiController fondo = new uiController();
	private static int n = 0;
	/**
	 * @Calcula tama�o de algoritmo para graficarlo segun el mismo
	 */	
	public void calcularTamano(){
		Grafo objeto = ui.main.objeto1;
		while ((boolean) objeto.hasNext()){
			n += 2;
			objeto = (Grafo) objeto.next();
		}
		if (n < 1){
			n = 0;
		}
	}
	/**
	 * @dibuja las flechas para guiar en el diagrama, recibe el nodo y un String
	 * para ver si se esta devolviendo o avanzando 
	 */
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
	/**
	 * @llama funcion del uiController para hacer el cambio por una condicion
	 */	
	@Override
	protected void condicion(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/condicion.png", objeto);
		crearFlechas(objeto, anterior);
		
	}
	/**
	 * @llama funcion del uiController para hacer el cambio por un ciclo while
	 */	
	@Override
	protected void cicloWhile(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/While.png", objeto);
		crearFlechas(objeto, anterior);
		
	}
	/**
	 * @llama funcion del uiController para hacer el cambio por un ciclo for
	 */	
	@Override
	protected void cicloFor(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/For.png", objeto);
		crearFlechas(objeto, anterior);
		
	}
	/**
	 * @llama funcion del uiController para hacer el cambio por una 
	 * definicion de variable o una instruccion
	 */	
	@Override
	protected void definicionVariable(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/declaracion.png", objeto);
		crearFlechas(objeto, anterior);
		
	}
	/**
	 * @llama funcion del uiController para hacer el cambio por un metodo externo
	 */	
	@Override
	protected void instruccionesVarias(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( "./src/img/metodoExterno.png", objeto);
		crearFlechas(objeto, anterior);
		
	}

}
