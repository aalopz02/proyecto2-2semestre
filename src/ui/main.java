package ui;

import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

public class main {	
	
	static ArrayList<String> lista;
	static Grafo objeto = new Grafo("nodo0",new CrearFormas().condicion(lista),null,null);
	
	public static void main(String [] args) {
		Display display = Display.getDefault();
		Grafo objeto2;
		objeto2 = objeto;
		
		for (int i = 1; i < 5; i ++) {
			Grafo objeto3 = new Grafo("nodo"+ i,new CrearFormas().cicloWhile(lista),null,objeto2);
			objeto2.setNext(objeto3);
			objeto2 = objeto3;
		}
		//for (int i = 0; i < 5; i ++) {
		//	objeto =(Grafo) objeto.next();
		//
		//}
		Shell shell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
		crearBotones(shell);
		shell.setText ("Diagrama");
		shell.setSize (300, 300);
		shell.setBackgroundMode(1);
		shell.setBackgroundImage((Image) objeto.getContenido());
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
				objeto = (Grafo) objeto.getPrevio();                   
				Display.getCurrent().syncExec(new Runnable() {
				    public void run() {
				    	shell.setBackgroundImage((Image) objeto.getContenido());
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
				objeto = (Grafo) objeto.next();                   
				Display.getCurrent().syncExec(new Runnable() {
				    public void run() {
				    	shell.setBackgroundImage((Image) objeto.getContenido());
				    }
				});
			}
			
		});
		
	}

	public static Device display() {
	
		return null;
	}
	

}
