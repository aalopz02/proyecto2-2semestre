package funciones;

import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.swt.graphics.Rectangle;

/**
 * Clase Grafo que define cada nodo del grafo
 */
public class Grafo implements Iterator<Object>{

	private String nombreNodo;
	private Rectangle contenido;
	private ArrayList<Object> instrucciones;
	private Object siguiente = null;
	private Object previo = null;
	/**
	 * @Constructor Grafo
	 */
	public Grafo(String nombreNodo, Object contenido, ArrayList<Object> instrucciones, Object siguiente, Object previo){
		setNombreNodo(nombreNodo);
		setContenido((Rectangle) contenido);
		setInstrucciones(instrucciones);
		setNext(siguiente);
		setPrevio(previo);
	}
	/**
	 * @return boolean tiene un elemento siguiente
	 */
	@Override
	public boolean hasNext() {
		if (this.siguiente == null) {
			return false;
		}
		return true;
	}
	/**
	 * @return Grafo siguiente
	 */
	@Override
	public Object next() {
		if (hasNext()) {
			return this.siguiente;
		}
		return null;
	}
	/**
	 * @param Nodo siguiente el nodo siguiente
	 */
	public void setNext(Object siguiente) {
		this.siguiente = siguiente;
	}	
	/**
	 * @return Rectangle contenido que contiene la posicion
	 */
	public Rectangle getContenido() {
		return contenido;
	}
	/**
	 * @param Contenido para definir la posicion del nodo en canvas
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
	 * @param nombreNodo define el nombre del nodo 
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
	 * @param Grafo previo para definir el nodo anterior
	 */
	public void setPrevio(Object previo) {
		this.previo = previo;
	}
	/**
	 * @return instrucciones
	 */
	public ArrayList<Object> getInstrucciones() {
		return instrucciones;
	}
	/**
	 * @param instrucciones contiene los datos de las instrucciones
	 */
	public void setInstrucciones(ArrayList<Object> instrucciones) {
		this.instrucciones = instrucciones;
	}
	/**
	 * @return boolean tiene objeto anterior
	 */
	public boolean hasPrev() {
		if (this.previo == null) {
			return false;
		}
		return true;
	}
}
