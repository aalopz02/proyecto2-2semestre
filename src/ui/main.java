package ui;

import java.util.ArrayList;
import funciones.Grafo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class main {
	
	public float tiempo = 0.0;
	static ArrayList<String> lista;
	static Shell shell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
	static Canvas canvas = new  Canvas(shell, SWT.None);
	static int posicionX = 165;
	static int posicionY = 0;
	static Grafo objeto1 = new Grafo("inicio", new Rectangle(0, 0,posicionX, 10), lista, null, null);
        static Label etiqueta = new Label(shell, SWT.NONE);
	
        /**
	 * @main de la aplicacion
	 */
	public static void main(String [] args) {
		Display display = Display.getDefault();
		Grafo objeto2;
		objeto2 = objeto1;
		posicionY += 55;
		ArrayList<String> lista1 = new ArrayList<String>();
		lista1.add("x = 10".toString());
		lista1.add("metodo1");
		lista1.add("metodo2");
		Grafo objeto3 = new Grafo("condicion", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto2);
		posicionY += 125;
		Grafo objeto4 = new Grafo("declaracion", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto3);
		posicionY += 55;
		Grafo objeto5 = new Grafo("while", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto4);
		posicionY += 120;
		Grafo objeto6 = new Grafo("metodo", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto5);
		posicionY += 55;
		Grafo objeto7 = new Grafo("for", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto6);
		posicionY += 120;
		Grafo objeto8 = new Grafo("inicio", new Rectangle(0, 0, posicionX, posicionY), lista, null, objeto7);
		posicionY = 0;
		objeto2.setNext(objeto3);
		objeto3.setNext(objeto4);
		objeto4.setNext(objeto5);
		objeto5.setNext(objeto6);
		objeto6.setNext(objeto7);
		objeto7.setNext(objeto8);
		objeto1 = objeto2;
		dibujoInicial(objeto2);
		canvas.setBackground(new Color(shell.getDisplay(), 255, 255, 255));
		canvas.setBounds(0, 0, 400, 695);
		crearBotones();
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
	/**
	 * @crea las etiquetas de la ventana
	 */
	private static void crearEtiquetas() {
		etiqueta.setBackground(new Color(shell.getDisplay(), 255, 255, 255));
		etiqueta.setBounds(400, 0, 300, 300);
		new uiController().cambiarEtiqueta("./src/img/inicioFin.png", null);
		
	}
	/**
	 * @crea los botones de la ventana
	 */
	private static void crearBotones() {
		Button anterior = new Button(shell, SWT.PUSH);
		anterior.setBounds(0, 695, 60, 25);
		anterior.setText("Anterior");
		anterior.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		CrearFormas formas =  new CrearFormas();
		anterior.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				if (objeto1.hasPrev()){
					objeto1 = (Grafo) objeto1.getPrevio();
					if( objeto1.getNombreNodo().equals("inicio")) {new uiController().cambiarEtiqueta("./src/img/inicioFin.png", null);}
					if( objeto1.getNombreNodo().equals("condicion")) {formas.condicion(objeto1, "a");}
					if( objeto1.getNombreNodo().equals("while")) {formas.cicloWhile(objeto1, "a");}
					if( objeto1.getNombreNodo().equals("for")) {formas.cicloFor(objeto1, "a");}
					if( objeto1.getNombreNodo().equals("declaracion")) {formas.definicionVariable(objeto1, "a");}
					if( objeto1.getNombreNodo().equals("metodo")) {formas.instruccionesVarias(objeto1, "a");}
				}
				else {
					return;
				}
			}
			
		});
		Button siguiente = new Button(shell, SWT.PUSH);
		siguiente.setBounds(340, 695, 60, 25);
		siguiente.setText("Siguiente");
		siguiente.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		siguiente.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				if (objeto1.hasNext()){
					objeto1 = (Grafo) objeto1.next();
					if( objeto1.getNombreNodo().equals("condicion")) {formas.condicion(objeto1, "");}
					if( objeto1.getNombreNodo().equals("while")) {formas.cicloWhile(objeto1, "");}
					if( objeto1.getNombreNodo().equals("for")) {formas.cicloFor(objeto1, "");}
					if( objeto1.getNombreNodo().equals("declaracion")) {formas.definicionVariable(objeto1, "");}
					if( objeto1.getNombreNodo().equals("metodo")) {formas.instruccionesVarias(objeto1, "");}
				}
				else {
					new uiController().cambiarEtiqueta("./src/img/inicioFin.png", null);
					return;
				}
				
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
	/**
	 * @param recibe el nodo del grafo inicial
	 */
	public static void dibujoInicial(funciones.Grafo objeto2) {
		CrearFormasInicio formas = new CrearFormasInicio();
		while (true){
			if( objeto2.getNombreNodo().equals("inicio")) {formas.inicioFin(objeto2);}
			if( objeto2.getNombreNodo().equals("condicion")) {formas.condicion(objeto2, "");}
			if( objeto2.getNombreNodo().equals("while")) {formas.cicloWhile(objeto2, "");}
			if( objeto2.getNombreNodo().equals("for")) {formas.cicloFor(objeto2, "");}
			if( objeto2.getNombreNodo().equals("declaracion")) {formas.definicionVariable(objeto2, "");}
			if( objeto2.getNombreNodo().equals("metodo")) {formas.instruccionesVarias(objeto2, "");}
			if(objeto2.hasNext()) {
				objeto2 = (Grafo) objeto2.next(); 
			}
			else {break;}
		}
		
	}


}

