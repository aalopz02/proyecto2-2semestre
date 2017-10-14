package funciones;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.swt.graphics.Rectangle;

public class Grafo implements Iterator<Object>{

	private String nombreNodo;
	private Rectangle contenido;
	private ArrayList<String> instrucciones;
	private Object siguiente = null;
	private Object previo = null;
	
	public Grafo(String nombreNodo, Object contenido, ArrayList<String> instrucciones, Object siguiente, Object previo){
		setNombreNodo(nombreNodo);
		setContenido((Rectangle) contenido);
		setInstrucciones(instrucciones);
		setNext(siguiente);
		setPrevio(previo);
	}
	/**
	 * @return si tiene un elemento siguiente
	 */
	@Override
	public boolean hasNext() {
		if (this.siguiente == null) {
			return false;
		}
		return true;
	}
	/**
	 * @return el siguiente
	 */
	@Override
	public Object next() {
		if (hasNext()) {
			return this.siguiente;
		}
		return null;
	}
	/**
	 * @param define el nodo siguiente
	 */
	public void setNext(Object siguiente) {
		this.siguiente = siguiente;
	}	
	/**
	 * @return contenido
	 */
	public Rectangle getContenido() {
		return contenido;
	}
	/**
	 * @param define el contenido 
	 */
	public void setContenido(Rectangle contenido) {
		this.contenido = contenido;
	}

	/**
	 * @return nombreNodo
	 */
	public String getNombreNodo() {
		return nombreNodo;
	}

	/**
	 * @param define el nombre del nodo
	 */
	public void setNombreNodo(String nombreNodo) {
		this.nombreNodo = nombreNodo;
	}
	/**
	 * @return previo
	 */
	public Object getPrevio() {
		return previo;
	}
	/**
	 * @param define el nodo previo del nodo actual
	 */
	public void setPrevio(Object previo) {
		this.previo = previo;
	}
	/**
	 * @return the instrucciones
	 */
	public ArrayList<String> getInstrucciones() {
		return instrucciones;
	}
	/**
	 * @param instrucciones the instrucciones to set
	 */
	public void setInstrucciones(ArrayList<String> instrucciones) {
		this.instrucciones = instrucciones;
	}

}
