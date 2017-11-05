package ui;

import funciones.Grafo;

public class CrearFormas extends funciones.Formas {
	
	uiController fondo = new uiController();

	Object aux() {
		return getClass().getResourceAsStream("inicioFin.png");
	}
	/**
	 * Llama funcion del uiController para hacer el cambio por una condicion
	 */	
	@Override
	protected void condicion(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta(getClass().getResourceAsStream("condicion.png"), objeto);		
	}
	/**
	 * Llama funcion del uiController para hacer el cambio por un ciclo while
	 */	
	@Override
	protected void cicloWhile(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta(getClass().getResourceAsStream("While.png"), objeto);
	}
	/**
	 * Llama funcion del uiController para hacer el cambio por un ciclo for
	 */	
	@Override
	protected void cicloFor(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta( getClass().getResourceAsStream("For.png"), objeto);
	}
	/**
	 * Llama funcion del uiController para hacer el cambio por una 
	 * definicion de variable o una instruccion
	 */	
	@Override
	protected void definicionVariable(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta(getClass().getResourceAsStream("declaracion.png"), objeto);
	}
	/**
	 * Llama funcion del uiController para hacer el cambio por un metodo externo
	 */	
	@Override
	protected void instruccionesVarias(Grafo objeto, String anterior) {
		fondo.cambiarEtiqueta(getClass().getResourceAsStream("metodoExterno.png"), objeto);
	}
}
