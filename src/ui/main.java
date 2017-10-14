package ui;

import java.util.ArrayList;
import funciones.Grafo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class main {	
	
	static ArrayList<String> lista;
	static Shell shell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
	static Canvas canvas = new  Canvas(shell, SWT.None);
	static int posicionX = 150;
	static int posicionY = 0;
	static Grafo objeto1 = new Grafo("inicio", new Rectangle(0, 0,posicionX, posicionY), lista, null, null);
    static Label etiqueta = new Label(shell, SWT.NONE);
	
	public static void main(String [] args) {
		Display display = Display.getDefault();
		Grafo objeto2;
		objeto2 = objeto1;
		
		for (int i = 1; i < 5; i ++) {
			posicionY += 30;
			Grafo objeto3 = new Grafo("declaracion", new Rectangle(0, 0, posicionX, posicionY), lista, null, objeto2);
			objeto2.setNext(objeto3);
			objeto2 = objeto3;
		  }
		objeto2 = objeto1;
		posicionY = 0;
		dibujoInicial(objeto2);
		canvas.setBackground(new Color(shell.getDisplay(), 255, 255, 200));
		canvas.setBounds(0, 0, 400, 695);
		crearBotones(objeto2);
		crearEtiquetas();
		shell.setText ("Diagrama");
		shell.setSize (700, 750);
		shell.open ();
		   
	    while (!display.isDisposed()) {
	    	if (!display.readAndDispatch()) { 
	             display.sleep();
	    	}
	    }
	}
	
	private static void crearEtiquetas() {
		etiqueta.setBackground(new Color(shell.getDisplay(), 255, 255, 200));
		etiqueta.setBounds(400, 0, 300, 300);
		
	}
	
	private static void crearBotones(funciones.Grafo objeto) {
		Button anterior = new Button(shell, SWT.PUSH);
		anterior.setBounds(0, 695, 60, 25);
		anterior.setText("Anterior");
		anterior.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		anterior.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				CrearFormas formas =  new CrearFormas();
				formas.condicion(objeto);
				
			}
			
		});
		Button siguiente = new Button(shell, SWT.PUSH);
		siguiente.setBounds(340, 695, 60, 25);
		siguiente.setText("Siguiente");
		siguiente.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		siguiente.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				CrearFormas formas =  new CrearFormas();
				formas.crearFlechas();
				
			}
			
		});
		Button stepInto = new Button(shell, SWT.PUSH);
		stepInto.setBounds(400, 300, 60, 25);
		stepInto.setText("Step Into");
		stepInto.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		
		Button stepOver = new Button(shell, SWT.PUSH);
		stepOver.setBounds(635, 300, 60, 25);
		stepOver.setText("Step Over");
		stepOver.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		
		
	}
	
	public static void dibujoInicial(funciones.Grafo objeto2) {
		CrearFormasInicio formas = new CrearFormasInicio();
		while (true){
			if( objeto2.getNombreNodo().equals("inicio")) {formas.inicioFin(objeto2);}
			if( objeto2.getNombreNodo().equals("condicion")) {formas.condicion(objeto2);}
			if( objeto2.getNombreNodo().equals("while")) {formas.cicloWhile(objeto2);}
			if( objeto2.getNombreNodo().equals("for")) {formas.cicloFor(objeto2);}
			if( objeto2.getNombreNodo().equals("declaracion")) {formas.definicionVariable(objeto2);}
			if( objeto2.getNombreNodo().equals("metodo")) {formas.instruccionesVarias(objeto2);}
			if(objeto2.hasNext()) {
				objeto2 = (Grafo) objeto2.next(); 
			}
			else {break;}
		}
		
		
	}
}
