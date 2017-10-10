package ui;

import java.util.ArrayList;
import funciones.Grafo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

public class main {	
	
	static ArrayList<String> lista;
	static Grafo objeto = new Grafo("nodo0",new CrearFormas().condicion(lista),null,null);
	static Shell shell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
	
	public static void main(String [] args) {
		Display display = Display.getDefault();
		//Grafo objeto2;
		//objeto2 = objeto;
		
		//for (int i = 1; i < 5; i ++) {
		//	Grafo objeto3 = new Grafo("nodo"+ i,new CrearFormas().cicloWhile(lista),null,objeto2);
		//	objeto2.setNext(objeto3);
		//	objeto2 = objeto3;
		//}
		Grafo objeto2 = new Grafo("nodo1",new CrearFormas().definicionVariable(lista),null,objeto);
		Grafo objeto3 = new Grafo("nodo2",new CrearFormas().cicloFor(lista),null,objeto2);
		Grafo objeto4 = new Grafo("nodo3",new CrearFormas().instruccionesVarias(lista),null,objeto3);
		Grafo objeto5 = new Grafo("nodo4",new CrearFormas().cicloWhile(lista),null,objeto4);
		objeto.setNext(objeto2);
		objeto2.setNext(objeto3);
		objeto3.setNext(objeto4);
		objeto4.setNext(objeto5);
		crearBotones(shell);
		crearEtiquetaDerecha(shell);
		shell.setText ("Diagrama");
		shell.setSize (600, 300);
		objeto.getContenido().setBounds(150, 150, 300, 300);
		shell.open ();
	    while (!display.isDisposed()) {
	    	if (!display.readAndDispatch()) { 
	             display.sleep();
	    	}
	    }
	}
	
	private static void crearBotones(Shell shell) {
		Button anterior = new Button(shell, SWT.PUSH);
		anterior.setBounds(0, 246, 60, 25);
		anterior.setText("Anterior");
		anterior.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		anterior.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				if (objeto.getPrevio() == null) {
		    		return;
		    	}
				objeto = (Grafo) objeto.getPrevio();                   
				Display.getCurrent().syncExec(new Runnable() {
				    public void run() {
				    	objeto.getContenido().setBounds(150, 150, 300, 300);
				    }
				});
				
			}
			
		});
		Button siguiente = new Button(shell, SWT.PUSH);
		siguiente.setBounds(234, 246, 60, 25);
		siguiente.setText("Siguiente");
		siguiente.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		siguiente.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				if (objeto.next() == null) {
		    		return;
		    	}
				objeto = (Grafo) objeto.next();                   
				Display.getCurrent().syncExec(new Runnable() {
				    public void run() {
				    	objeto.getContenido().setBounds(150, 150, 300, 300);
				    }
				});
			}
			
		});
		
	}

	public static void crearEtiquetaDerecha(Shell shell) {
		Label etiqueta = new Label(shell, SWT.NONE);
		etiqueta.setBounds(300,0,300,300);
		etiqueta.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		
	}
	
	public static Device display() {
	
		return null;
	}
	
	public static Shell shell(){
		return shell;
	}
}
