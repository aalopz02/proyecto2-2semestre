package ui;

import java.io.InputStream;
import java.util.ArrayList;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import funciones.Grafo;
import funciones.ListaOrdenada;

public class uiController {
	/**
	 * Cambia etiqueta que muestra la figura del diagrama
	 */
	public void cambiarEtiqueta(InputStream archivo, Grafo objeto) {
		Image image = new Image(ui.main.shell.getDisplay(), archivo);
		if (objeto == null) {
			ui.main.etiqueta.setBackgroundImage(image);
			return;			
		}
		dibujarImagen(objeto, image);
		ui.main.etiqueta.setBackgroundImage(image);	
	}
	/**
	 * Dibuja el texto de las instrucciones en la imagen a cambiar
	 */
	public void dibujarImagen(Grafo objeto, Image imagen) {
		ArrayList<Object> instrucciones = objeto.getInstrucciones(); 
		GC gc = new GC(imagen);
		if( objeto.getNombreNodo().equals("condicion")) {
			gc.drawText((String) instrucciones.get(0), 80, 50);
			gc.drawText((String) instrucciones.get(1), 30, 240);
			gc.drawText((String) instrucciones.get(2), 180, 240);			
		}
		if( objeto.getNombreNodo().equals("while")) {
			gc.drawText((String) instrucciones.get(0), 100, 50);
			gc.drawText((String) instrucciones.get(1), 90, 190);	
		}
		if( objeto.getNombreNodo().equals("for")) {
			gc.drawText((String) instrucciones.get(0), 60, 30);
			gc.drawText((String) instrucciones.get(1), 80, 170);	
		}
		if( objeto.getNombreNodo().equals("declaracion")) {
			gc.drawText((String) instrucciones.get(0), 70, 40);		
		}
		if( objeto.getNombreNodo().equals("metodo")) {
			gc.drawText((String) instrucciones.get(0), 70, 40);		
		}	
	}
	/**
	 * Crea el grafo utilizando la clase ListaOrdenada
	 */
	public void hacerGrafo(){
		ListaOrdenada lista = new ListaOrdenada();
		Grafo inicio = ui.main.objeto1;
		int posicionY = ui.main.posicionY;
		int posicionX = ui.main.posicionX;
		ui.main.tiempo = System.currentTimeMillis();
		ArrayList<Object> contenido = new ArrayList<Object>();
		for (int i = 0; i < lista.getLista().size(); i ++){
			if (lista.getLista().get(i).equals("condicion")){
				posicionY += 125;
				contenido.add(lista.getLista().get(i));
				}
			if (lista.getLista().get(i).equals("while")){
				posicionY += 120;
				contenido.add(lista.getLista().get(i));
				}
			if (lista.getLista().get(i).equals("metodo")){
				posicionY += 55;
				contenido.add(lista.getLista().get(i));
				}
			if(lista.getLista().get(i).equals("metodoExterno")){
				posicionY += 55;
				contenido.add(lista.getLista().get(i));
				contenido.add(hacerGrafoAux(contenido,i));
				}
			if (lista.getLista().get(i).equals("declaracion")){
				posicionY += 55;
				contenido.add(lista.getLista().get(i));
				}
			if (lista.getLista().get(i).equals("for")){
				posicionY += 120;
				contenido.add(lista.getLista().get(i));
				}
			Grafo objeto2 = new Grafo(lista.getLista().get(i), new Rectangle(0, 0,posicionX, posicionY),(ArrayList<Object>)contenido, null, inicio);
			inicio.setNext(objeto2);
			inicio = objeto2;	
		}
		ui.main.tiempo = System.currentTimeMillis() - ui.main.tiempo;
	}
	/**
	 * Crea el grafo utilizando la clase ListaOrdenada de metodos externos
	 */
	public Grafo hacerGrafoAux(ArrayList<Object> lista, int indice) {
		Grafo inicio = new Grafo("inicio",new Rectangle(0,0,0,0),new ArrayList<Object>(),null,null);
		Grafo objeto2 = inicio;
		int posicionY = 0;
		int posicionX = 200;
		ArrayList<Object> contenido = new ArrayList<Object>();
		for (int i = indice; i < lista.size(); i ++){
			if (lista.get(i).equals("condicion")){
				posicionY += 125;
				contenido.add(lista.get(i));
				}
			if (lista.get(i).equals("while")){
				posicionY += 120;
				contenido.add(lista.get(i));
				}
			if (lista.get(i).equals("metodo")){
				posicionY += 55;
				contenido.add(lista.get(i));
				}
			if(lista.get(i).equals("metodoExterno")){
				posicionY += 55;
				contenido.add(lista.get(i));
				contenido.add(hacerGrafoAux(contenido, i));
				}
			if (lista.get(i).equals("declaracion")){
				posicionY += 55;
				contenido.add(lista.get(i));
				}
			if (lista.get(i).equals("for")){
				posicionY += 120;
				contenido.add(lista.get(i));
				}
			
			Grafo objeto3 = new Grafo((String) lista.get(i), new Rectangle(0, 0,posicionX, posicionY),(ArrayList<Object>)contenido, null, inicio);
			objeto2.setNext(objeto3);
			objeto2 = objeto3;
		}
		while(objeto2.getPrevio() == null) {
			inicio = (Grafo) objeto2.getPrevio();
			objeto2 = inicio;
		}
		return inicio;		
	}
}