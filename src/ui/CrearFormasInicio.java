package ui;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import funciones.Grafo;
import java.util.ArrayList;

public class CrearFormasInicio extends funciones.Formas {
	
	private int n = 1;
	
	private void calcularTamano(){
		int tamano = 0;
		while (ui.main.objeto.next()){
			tamano += 0.1;
		}
		if (tamaño < 1){
			n = 1;
		}
		else{n = tamano;}
	}
	/**
	 * @dibuja en el canvas la representacion de la condicional
	 */	
	@Override
	protected void condicion(Grafo objeto, String anterior) {
		ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		int y = ui.main.posicionY/n;
    		int x = ui.main.posicionX/n;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntos = { x, y, x - 50/n, y + 15/n, x, y + 30/n, x + 50/n, y + 15/n};
		    	int[] puntosLinea = { x + 50/n, y + 15/n, x + 60/n, y + 15/n, x + 60/n, y + 15/n, x + 60/n, y + 65/n};
		    	int[] puntosLinea2 = { x - 50/n, y + 15/n, x - 60/n, y + 15/n, x - 60/n, y + 15/n, x - 60/n, y + 65/n};
		    	int[] puntosLinea3 = {x - 30/n, y + 80/n, x + 30/n, y + 80/n, x, y + 80/n, x, y+ 100/n};
		    	e.gc.drawRectangle(x - 90/n, y + 65/n, 60/n, 30/n);
		    	e.gc.drawText(instrucciones.get(1), x - 85/n, y + 70/n);
		    	e.gc.drawRectangle(x + 30/n, y + 65/n, 60/n, 30/n);
		    	e.gc.drawText(instrucciones.get(2), x + 35/n, y + 70/n);
		        e.gc.drawPolygon(puntos);
		        e.gc.drawText(instrucciones.get(0), x - 15/n, y + 5/n);
		        e.gc.drawPolyline(puntosLinea);
		        e.gc.drawText("SI", x - 80/n, y + 15/n);
		        e.gc.drawPolyline(puntosLinea2);
		        e.gc.drawText("NO", x + 70/n, y + 15/n);
		        e.gc.drawPolyline(puntosLinea3);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 100/n;
		dibujarLinea();
		
	}
	/**
	 * @dibuja en el canvas la representacion de un ciclo while
	 */
	@Override
	protected void cicloWhile(Grafo objeto, String anterior) {
		ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		int y = ui.main.posicionY/n;
    		int x = ui.main.posicionX/n;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntosRombo = { x, y, x - 50/n, y + 15/n, x, y + 30/n, x + 50/n, y + 15/n};
		    	int[] puntosLinea = { x + 50/n, y + 15/n, x + 60/n, y + 15/n, x + 60/n, y + 15/n, x + 60/n, y + 65/n, x + 60/n, y + 65/n, x + 40/n, y + 65/n};
		    	int[] puntosLinea2 = { x - 30/n, y + 70/n, x - 60/n, y + 70/n, x - 60/n, y + 70/n, x - 60/n, y + 15/n, x - 60/n, y + 15/n,x - 50/n, y + 15/n};
		    	int[] puntosFlecha2 = { x + 40/n, y + 65/n, x + 45/n, y + 60/n, x + 40/n, y + 65/n, x + 45/n, y + 70/n};
		    	int[] puntosFlecha = { x - 50/n, y + 15/n, x - 55/n, y + 10/n, x - 50/n, y + 15/n, x - 55/n, y + 20/n};
		    	e.gc.drawPolygon(puntosRombo);
		    	e.gc.drawText(instrucciones.get(0), x - 15/n, y + 5/n);
		        e.gc.drawPolyline(puntosLinea);
		        e.gc.drawPolyline(puntosLinea2);
		        e.gc.drawPolyline(puntosFlecha);
		        e.gc.drawPolyline(puntosFlecha2);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30/n;
		dibujarLinea();
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	e.gc.drawRectangle( x - 30/n, y + 55/n, 60/n, 30/n);
		    	e.gc.drawText(instrucciones.get(1), x - 25/n, y + 60/n);
		    	
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30/n;
		dibujarLinea();
		
	}
	/**
	 * @dibuja en el canvas la representacion de un ciclo for
	 */
	@Override
	protected void cicloFor(Grafo objeto, String anterior) {
		int y = ui.main.posicionY/n;
    		int x = ui.main.posicionX/n;
    		ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntosRombo = { x, y, x - 25/n, y, x - 25/n, y, x - 50/n, y + 15/n, x - 50/n, y + 15/n, x - 25/n, y + 30/n,  x - 25/n, y + 30/n, x + 25/n, y + 30/n, x + 25/n, y + 30/n, x + 50/n, y + 15/n, x + 50/n, y + 15/n,x + 25/n, y, x + 25/n, y, x, y};
		    	int[] puntosLinea = { x + 50/n, y + 15/n, x + 60/n, y + 15/n, x + 60/n, y + 15/n, x + 60/n, y + 65/n, x + 60/n, y + 65/n, x + 40/n, y + 65/n};
		    	int[] puntosLinea2 = { x - 30/n, y + 70/n, x - 60/n, y + 70/n, x - 60/n, y + 70/n, x - 60/n, y + 15/n, x - 60/n, y + 15/n,x - 50/n, y + 15/n};
		    	int[] puntosFlecha2 = { x + 40/n, y + 65/n, x + 45/n, y + 60/n, x + 40/n, y + 65/n, x + 45/n, y + 70/n};
		    	int[] puntosFlecha = { x - 50/n, y + 15/n, x - 55/n, y + 10/n, x - 50/n, y + 15/n, x - 55/n, y + 20/n};
		    	e.gc.drawPolygon(puntosRombo);
		    	e.gc.drawText(instrucciones.get(0), x - 15/n, y + 5/n);
		        e.gc.drawPolyline(puntosLinea);
		        e.gc.drawPolyline(puntosLinea2);
		        e.gc.drawPolyline(puntosFlecha);
		        e.gc.drawPolyline(puntosFlecha2);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30/n;
		dibujarLinea();
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	e.gc.drawRectangle( x - 30/n, y + 55/n, 60/n, 30/n);
		    	e.gc.drawText(instrucciones.get(1), x - 25/n, y + 60/n);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30/n;
		dibujarLinea();
		
	}
	/**
	 * @dibuja en el canvas la representacion de una definicion de variable
	 * o instruccion
	 */
	@Override
	protected void definicionVariable(Grafo objeto, String anterior) {
		int y = ui.main.posicionY;
    		int x = ui.main.posicionX;
    		ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	e.gc.drawRectangle( x - 30/n, y, 60/n, 30/n);
		    	e.gc.drawText(instrucciones.get(1), x - 25/n, y + 10/n);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30/n;
		dibujarLinea();
		
	}
	/**
	 * @dibuja en el canvas la representacion de un metodo externo
	 */
	@Override
	protected void instruccionesVarias(Grafo objeto, String anterior) {
		int y = ui.main.posicionY/n;
    		int x = ui.main.posicionX/n;
    		ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) {
		    	e.gc.drawRectangle( x - 35/n , y, 70/n, 30/n);
		    	e.gc.drawRectangle( x - 30/n, y, 60/n, 30/n);
		    	e.gc.drawText(instrucciones.get(1), x - 25/n, y + 10/n);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30/n;
		dibujarLinea();
		
	}
	/**
	 * @dibuja en el canvas el inicio y el fin del diagrama
	 */
	protected void inicioFin(funciones.Grafo objeto1) {
		int y = ui.main.posicionY/n;
		int x = ui.main.posicionX/n;
		
		if (objeto1.hasNext()) {
			ui.main.canvas.addPaintListener(new PaintListener() { 
			    public void paintControl(PaintEvent e) { 
			        e.gc.drawOval(x, y, 30/n, 30/n);
			    }
			});
			ui.main.posicionX += 15/n;
			ui.main.posicionY += 30/n;
			dibujarLinea();
		}
		else {
			ui.main.canvas.addPaintListener(new PaintListener() { 
			    public void paintControl(PaintEvent e) { 
			        e.gc.drawOval(x - 15/n, y, 30/n, 30/n);
			    }
			});
		}
	}
	/**
	 * @dibuja en el canvas una linea para conectar cada nodo del diagrama
	 */
	private static void dibujarLinea() {
		int y = ui.main.posicionY/n;
		int x = ui.main.posicionX/n;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		        e.gc.drawLine(x, y + 25/n, x, y);
		 
		    }
		});
		ui.main.posicionY += 25/n;
	}
}
