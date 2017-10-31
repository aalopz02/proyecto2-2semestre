package ui;

import java.util.ArrayList;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import funciones.Grafo;

public class uiController {
	/**
	 * @cambia etiqueta que muestra la figura del diagrama
	 */
	public void cambiarEtiqueta(String archivo, Grafo objeto) {
		Image image = new Image(ui.main.shell.getDisplay(), archivo);
		if (objeto == null) {
			ui.main.etiqueta.setBackgroundImage(image);
			return;
			
		}
		dibujarImagen(objeto, image);
		ui.main.etiqueta.setBackgroundImage(image);
		
	}
	/**
	 * @dibuja el texto de las instrucciones en la imagen a cambiar
	 */
	public void dibujarImagen(Grafo objeto, Image imagen) {
		ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		GC gc = new GC(imagen);
		if( objeto.getNombreNodo().equals("condicion")) {
			gc.drawText(instrucciones.get(0), 80, 50);
			gc.drawText(instrucciones.get(1), 30, 240);
			gc.drawText(instrucciones.get(2), 180, 240);
			
		}
		if( objeto.getNombreNodo().equals("while")) {
			gc.drawText(instrucciones.get(0), 100, 50);
			gc.drawText(instrucciones.get(1), 90, 190);
			
		}
		if( objeto.getNombreNodo().equals("for")) {
			gc.drawText(instrucciones.get(0), 60, 30);
			gc.drawText(instrucciones.get(1), 80, 170);
			
		}
		if( objeto.getNombreNodo().equals("declaracion")) {
			gc.drawText(instrucciones.get(0), 70, 40);
			
		}
		if( objeto.getNombreNodo().equals("metodo")) {
			gc.drawText(instrucciones.get(0), 70, 40);
			
		}
		
	}
	
	//public void hacerGrafo(){
		
		//Grafo inicio = ui.main.objeto1;
		//int posicionY = ui.main.posicionY;
		//int posicionX = ui.main.posicionX;
		//Stopwatch timer = new Stopwatch().start();
		//for (int i = 0; i < largolistaintrucciones; i ++){
		//	if (i.lista[nombre].equals("condicion")){posicionY += 125;}
		//	if (i.lista[nombre].equals("while")){posicionY += 120;}
		//	if (i.lista[nombre].equals("metodo")){posicionY += 55;}
		//	if (i.lista[nombre].equals("declaracion")){posicionY += 55;}
		//	if (i.lista[nombre].equals("for")){posicionY += 120;}
		//	Grafo objeto2 = new Grafo(i.lista[nombre], new Rectangle(0, 0, posicionX, poicionY), i.lista[instrucciones], null, inicio);
		//	inicio.setNext(objeto2);
		//	inicio = objeto2;
		
		//}
		//timer.stop();
		//ui.main.tiempo = stopwatch.elapsed(MILLISECONDS);
	//}

}
