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
	
	public void hacerGrafo(){
		inicio = ui.main.objeto1;
		for (int = 0; i < largolistaintrucciones; i ++){
			objeto2 = new Grafo(lista[],);
		
		}
		
	}
	
}
