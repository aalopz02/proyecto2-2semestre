package funciones;

import java.util.ArrayList;

public class ListaOrdenada {
	
	private static ListaOrdenada instance = null;
	ArrayList<String> lista = new ArrayList<String>();
	/**
	 * @Constructor ListaOrdenada
	 */
	public static ListaOrdenada getInstace() {
		if (instance == null) {
			instance = new ListaOrdenada();
		}
		return instance;
	}
	/**
	 * @param valor se agrega a la lista
	 */
	public void agregarValorLista(String valor) {
		this.lista.add(valor);
	}
	/**
	 * @return lista
	 */
	public ArrayList<String> getLista() {
		return this.lista;	
	} 
}