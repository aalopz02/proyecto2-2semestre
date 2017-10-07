package ui;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

public class main {	
	
	private static Display display = new Display();
	
	public static Display display() {
		return display;
	}
	
	public static void main(String [] args) {
		Grafo objeto = new Grafo("nodo0","./src/img/condicion.png",null);
		ArrayList<String> lista = new ArrayList();
		lista.add("./src/img/condicion.png");
		lista.add("./src/img/declaracion.png");
		lista.add("./src/img/For.png");
		lista.add("./src/img/metodoExterno.png");
		lista.add("./src/img/While.png");
		Grafo objeto2;
		objeto2 = objeto;
		for (int i = 1; i < 4; i ++) {
			Grafo objeto3 = new Grafo("nodo"+ i,lista.get(i),null);
			objeto2.setNext(objeto3);
			objeto2 = objeto3;
		}
		for (int i = 0; i < 4; i ++) {
			System.out.print(i);
			Shell shell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
			shell.setText ("Shell");
			shell.setSize (300, 300);
			shell.setBackgroundMode(1);
			shell.setBackgroundImage(new Image(display,(String) objeto.getContenido()));
			shell.open ();
			objeto =(Grafo) objeto.next();
			while (!shell.isDisposed ()) {
				if (!display.readAndDispatch ()) display.sleep ();
			}
			
		}
		
		
	}
	

}
