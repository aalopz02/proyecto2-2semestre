package funciones;
/**
 * Clase con metodos abstractos segun cada instruccion
 */
public abstract class Formas {
	
	protected abstract void condicion(funciones.Grafo objeto, String anterior);
	protected abstract void cicloWhile(funciones.Grafo objeto, String anterior);
	protected abstract void cicloFor(funciones.Grafo objeto, String anterior);
	protected abstract void definicionVariable(funciones.Grafo objeto, String anterior);
	protected abstract void instruccionesVarias(funciones.Grafo objeto, String anterior);
	
}
