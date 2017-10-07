package ui;

import java.util.Iterator;

public class Grafo implements Iterator<Object>{

	private String nombreNodo;
	private Object contenido;
	private Object siguiente = null;
	private Object previo = null;
	
	Grafo(String nombreNodo, Object contenido, Object siguiente, Object previo){
		setNombreNodo(nombreNodo);
		setContenido(contenido);
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
	public Object getContenido() {
		return contenido;
	}
	/**
	 * @param define el contenido 
	 */
	public void setContenido(Object contenido) {
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

}
