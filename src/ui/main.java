package ui;

import java.io.InputStream;
import java.util.ArrayList;
import funciones.Grafo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class main {
	
	public static long tiempo;
	static ArrayList<Object> lista;
	static Shell shell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
	static Canvas canvas = new  Canvas(shell,SWT.NONE);
	static int posicionX = 200;
	static int posicionY = 0;
	static Grafo objeto1 = 	new Grafo("inicio", new Rectangle(0, 0,posicionX, 10), lista, null, null);
	static Grafo inicio = objeto1;
    static Label etiqueta = new Label(shell, SWT.NONE);

    public static void main(String[] args) {
    	ejecutar();
    }
    /**
	 * Inicio de la aplicacion de la aplicacion
	 */
	public static void ejecutar() {
		Display display = Display.getDefault();
		canvas.setBounds(0, 0, 400, 695);
		tiempo = System.currentTimeMillis();
		Grafo objeto2;
		objeto2 = objeto1;
		ArrayList<Object> lista1 = new ArrayList<Object>();
		lista1.add("x = 10".toString());
		lista1.add("metodo1");
		lista1.add("metodo2");
		Grafo into1 = new Grafo("inicio", new Rectangle(0,0,posicionX,posicionY),lista1,null,null);
		posicionY += 55;
		Grafo into2 = new Grafo("condicion", new Rectangle(0,0,posicionX,posicionY),lista1,null,into1);
		posicionY += 125;
		Grafo into3 = new Grafo("inicio", new Rectangle(0,0,posicionX,posicionY),lista1,null,into2);
		into1.setNext(into2);
		into2.setNext(into3);
		lista1.add(into1);
		posicionY = 0;
		posicionY += 55;
		Grafo objeto3 = new Grafo("condicion", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto2);
		posicionY += 125;
		Grafo objeto4 = new Grafo("declaracion", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto3);
		posicionY += 55;
		Grafo objeto5 = new Grafo("while", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto4);
		posicionY += 110;
		Grafo objeto6 = new Grafo("metodo", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto5);
		posicionY += 55;
		Grafo objeto7 = new Grafo("while", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto6);
		posicionY += 110;
		Grafo objeto8 = new Grafo("condicion", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto7);
		posicionY += 125;
		Grafo objeto9 = new Grafo("for", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto8);
		posicionY += 110;
		Grafo objeto10 = new Grafo("metodo", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto9);
		posicionY += 55;
		Grafo objeto11 = new Grafo("condicion", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto10);
		posicionY += 125;
		Grafo objeto12 = new Grafo("for", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto11);
		posicionY += 120;
		Grafo objeto13 = new Grafo("condicion", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto12);
		posicionY += 125;
		Grafo objeto14 = new Grafo("for", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto13);
		posicionY += 120;
		Grafo objeto15 = new Grafo("inicio", new Rectangle(0, 0, posicionX, posicionY), lista1, null, objeto14);
		posicionY = 0;
		objeto2.setNext(objeto3);
		objeto3.setNext(objeto4);
		objeto4.setNext(objeto5);
		objeto5.setNext(objeto6);
		objeto6.setNext(objeto7);
		objeto7.setNext(objeto8);
		objeto8.setNext(objeto9);
		objeto9.setNext(objeto10);
		objeto10.setNext(objeto11);
		objeto11.setNext(objeto12);
		objeto12.setNext(objeto13);
		objeto13.setNext(objeto14);
		objeto14.setNext(objeto15);
		tiempo = System.currentTimeMillis() - tiempo;
		objeto1 = objeto2;
		dibujoInicial(objeto2);
		canvas.setBackground(new Color(shell.getDisplay(), 255,255,255));
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
	 * Crea las etiquetas de la ventana
	 */
	private static void crearEtiquetas() {
		etiqueta.setBackground(new Color(shell.getDisplay(), 255, 255, 255));
		etiqueta.setBounds(400, 0, 300, 300);
		String size = String.valueOf(13);
	    Label etiquetaSize = new Label(shell, SWT.NONE);
	    etiquetaSize.setText("El numero de instrucciones del algoritmo es de: "+size);
	    etiquetaSize.setBounds(400, 670, 300, 25);
	    Label etiquetaTiempo = new Label(shell, SWT.NONE);
		String s = String.valueOf(tiempo);
		etiquetaTiempo.setText("El tiempo en recorrer el algoritmo es de : "+s+" ms");
		etiquetaTiempo.setBounds(400, 695, 300, 25);
		new uiController().cambiarEtiqueta((InputStream) new CrearFormas().aux(), null);
	}
	/**
	 * Crea botones de la ventana
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
				if (inicio.hasPrev()){
					inicio = (Grafo) inicio.getPrevio();
					if( inicio.getNombreNodo().equals("inicio")) {new uiController().cambiarEtiqueta((InputStream) new CrearFormas().aux(), null);}
					if( inicio.getNombreNodo().equals("condicion")) {formas.condicion(inicio, "a");}
					if( inicio.getNombreNodo().equals("while")) {formas.cicloWhile(inicio, "a");}
					if( inicio.getNombreNodo().equals("for")) {formas.cicloFor(inicio, "a");}
					if( inicio.getNombreNodo().equals("declaracion")) {formas.definicionVariable(inicio, "a");}
					if( inicio.getNombreNodo().equals("metodo")) {formas.instruccionesVarias(inicio, "a");}
					canvas.dispose();
					canvas = new  Canvas(shell,SWT.NONE);
					canvas.setBounds(0, 0, 400, 695);
					canvas.setBackground(new Color(shell.getDisplay(), 255,255,255));
					dibujoInicial((Grafo) inicio);
					
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
				if (inicio.hasNext()){
					inicio = (Grafo) inicio.next();
					if( inicio.getNombreNodo().equals("condicion")) {formas.condicion(inicio, "");}
					if( inicio.getNombreNodo().equals("while")) {formas.cicloWhile(inicio, "");}
					if( inicio.getNombreNodo().equals("for")) {formas.cicloFor(inicio, "");}
					if( inicio.getNombreNodo().equals("declaracion")) {formas.definicionVariable(inicio, "");}
					if( inicio.getNombreNodo().equals("metodo")) {formas.instruccionesVarias(inicio, "");}
					canvas.dispose();
					canvas = new  Canvas(shell,SWT.NONE);
					canvas.setBounds(0, 0, 400, 695);
					canvas.setBackground(new Color(shell.getDisplay(), 255,255,255));
					dibujoInicial((Grafo) inicio);
				}
				else {
					new uiController().cambiarEtiqueta((InputStream) new CrearFormas().aux(), null);
					return;
				}		
			}	
		});
		Button stepInto = new Button(shell, SWT.PUSH);
		stepInto.setBounds(400, 300, 60, 25);
		stepInto.setText("Step Into");
		stepInto.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		stepInto.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				if( inicio.getNombreNodo().equals("metodo")) {
					if(inicio.getInstrucciones().get(3).getClass() == inicio.getClass()) {
						canvas.dispose();
						canvas = new  Canvas(shell,SWT.NONE);
						canvas.setBounds(0, 0, 400, 695);
						canvas.setBackground(new Color(shell.getDisplay(), 255,255,255));
						dibujoInicial((Grafo) inicio.getInstrucciones().get(3));
						inicio = (Grafo) inicio.getInstrucciones().get(3);
					}
				}
			}
		});
		Button stepOver = new Button(shell, SWT.PUSH);
		stepOver.setBounds(635, 300, 60, 25);
		stepOver.setText("Step Over");
		stepOver.setBackground(new Color(shell.getDisplay(), 200, 200, 200));
		stepOver.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				canvas.dispose();
				canvas = new  Canvas(shell,SWT.NONE);
				canvas.setBounds(0, 0, 400, 695);
				canvas.setBackground(new Color(shell.getDisplay(), 255,255,255));
				Grafo objeto2 = objeto1;
				inicio = objeto1;
				dibujoInicial(objeto2);
			}
		});
	}
	/**
	 * @param objeto2 nodo del grafo inicial, para llamar a CrearFormasInicio()
	 */
	public static void dibujoInicial(funciones.Grafo objeto2) {
		Grafo aux = objeto2;
		CrearFormasInicio formas = new CrearFormasInicio();
		formas.calcularTamano(0,objeto2);
		int n = 1;
		while ((boolean) objeto2.hasNext()){
			n += 1;
			objeto2 = (Grafo) objeto2.next();
		}
		objeto2 = aux;
		for (int i = 0; i<n; i++) {
			if( objeto2.getNombreNodo().equals("inicio")) {formas.inicioFin(objeto2);}
			if( objeto2.getNombreNodo().equals("condicion")) {formas.condicion(objeto2, "");}
			if( objeto2.getNombreNodo().equals("while")) {formas.cicloWhile(objeto2, "");}
			if( objeto2.getNombreNodo().equals("for")) {formas.cicloFor(objeto2, "");}
			if( objeto2.getNombreNodo().equals("declaracion")) {formas.definicionVariable(objeto2, "");}
			if( objeto2.getNombreNodo().equals("metodo")) {formas.instruccionesVarias(objeto2, "");}
			objeto2 = (Grafo) objeto2.next(); 
		}	
	}
}