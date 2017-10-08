package funciones;

import java.util.ArrayList;

public class ListaOrdenada {
	
	private static ListaOrdenada instance = null;
	ArrayList<String> lista = new ArrayList<String>();
	
	public static ListaOrdenada getInstace() {
		if (instance == null) {
			instance = new ListaOrdenada();
		}
		return instance;
		
	}

	public void agregarValorLista(String valor) {
		this.lista.add(valor);
	}
	
	public ArrayList<String> getLista() {
		return this.lista;
		
	} 
}
