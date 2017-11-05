package ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import funciones.Grafo;
import java.util.ArrayList;

public class CrearFormasInicio extends funciones.Formas {
	
	private static int n;
	/**
	 * Calcula tamaño de algoritmo para graficarlo segun el mismo
	 */	
	@SuppressWarnings("static-access")
	public void calcularTamano(int n, Grafo inicio){
		
		Grafo objeto = inicio;
		while ((boolean) objeto.hasNext()){
			n += 2;
			objeto = (Grafo) objeto.next();
		}
		if (n > 22) {
			System.out.println("El grafico se va a cortar");
		}
		if (n < 1){
			n = 0;
		}
		this.n = n; 
	}
	/**
	 * Dibuja en el canvas la representacion de la condicional
	 */	
	@Override
	protected void condicion(Grafo objeto, String anterior) {
		ArrayList<Object> instrucciones = objeto.getInstrucciones();
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntos = { x, y, x - 50 + n, y + 15-(n/4), x, y + 30-(n/2), x + 50-n, y + 15-(n/4)};
		    	int[] puntosLinea = { x + 50 - n, y + 15-(n/4), x + 60-n, y + 15-(n/4), x + 60-n, y + 15-(n/4), x + 60-n, y + 65-n};
		    	int[] puntosLinea2 = { x - 50+n, y + 15-(n/4), x - 60+n, y + 15-(n/4), x - 60+n, y + 15-(n/4), x - 60+n, y + 65-n};
		    	int[] puntosLinea3 = {x - 30, y + 65-n, x + 30, y + 65-n, x, y + 65-n, x, y+ 100-n};
		    	e.gc.drawRectangle(x - 90+(n+(n/2)), y + 65-n, 60-n, 30-(n/2));
		    	Font font = new Font(ui.main.shell.getDisplay(),"Arial",8-(n/8),SWT.NONE);
		    	e.gc.setFont(font);
		    	e.gc.drawText((String) instrucciones.get(1), x - 85+(n+(n/2)), y + 70-n);
		    	e.gc.drawRectangle(x + 30-(n/2), y + 65-n, 60-n, 30-(n/2));
		    	e.gc.drawText((String) instrucciones.get(2), x + 35-(n/2), y + 70-n);
		        e.gc.drawPolygon(puntos);
		        e.gc.drawText((String) instrucciones.get(0), x - 15+n, y + 5-(n/4));
		        e.gc.drawPolyline(puntosLinea);
		        e.gc.drawText("SI", x - 80+n, y + 15-(n/4));
		        e.gc.drawPolyline(puntosLinea2);
		        e.gc.drawText("NO", x + 70-n, y + 15-(n/4));
		        e.gc.drawPolyline(puntosLinea3);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 100-n;
		dibujarLinea();
	}
	/**
	 * Dibuja en el canvas la representacion de un ciclo while
	 */
	@Override
	protected void cicloWhile(Grafo objeto, String anterior) {
		ArrayList<Object> instrucciones = objeto.getInstrucciones(); 
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntosRombo = { x, y, x - 50 + n, y + 15-(n/4), x, y + 30-(n/2), x + 50-n, y + 15-(n/4)};
		    	int[] puntosLinea = { x + 50 - n, y + 15-(n/4), x + 60-n, y + 15-(n/4), x + 60-n, y + 15-(n/4), x + 60-n, y + 65-n, x + 60-n, y + 65-n, x + 40-(n/2), y + 65-n};
		    	int[] puntosLinea2 = { x - 30+(n/2), y + 65-n, x - 60+n, y + 65-n, x - 60+n, y + 65-n, x - 60+n, y + 15, x - 60+n, y + 15,x - 50+n, y + 15};
		    	int[] puntosFlecha2 = { x + 40-(n/2), y + 65-n, x + 45-(n/2), y + 60-n, x + 40-(n/2), y + 65-n, x + 45-(n/2), y + 70-n};
		    	int[] puntosFlecha = { x - 50+n, y + 15, x - 55+n, y + 10, x - 50+n, y + 15, x - 55+n, y + 20};
		    	e.gc.drawPolygon(puntosRombo);
		    	e.gc.drawText((String) instrucciones.get(0), x - 15+n, y + 5-(n/4));
		        e.gc.drawPolyline(puntosLinea);
		        e.gc.drawPolyline(puntosLinea2);
		        e.gc.drawPolyline(puntosFlecha);
		        e.gc.drawPolyline(puntosFlecha2);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30-(n/2);
		dibujarLinea();
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	e.gc.drawText((String) instrucciones.get(1), x - 10, y+25-(n/2)+30-(n/2) + 5);
		    	e.gc.drawRectangle(x - 30+(n/2), y+25-(n/2)+30-(n/2), 60-n, 30-(n/2));
		    	
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30-(n/2);
		dibujarLinea();
	}
	/**
	 * Dibuja en el canvas la representacion de un ciclo for
	 */
	@Override
	protected void cicloFor(Grafo objeto, String anterior) {
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
    	ArrayList<Object> instrucciones = objeto.getInstrucciones(); 
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntosRombo = { x,y,x-25+(n/2),y,x-25+(n/2),y,x-40+(n/2),y+15-(n/4),x-40+(n/2),y+15-(n/4),x-25+(n/2),y+30-(n/2),x-25+(n/2),y+30-(n/2),x+25-(n/2),y+30-(n/2),x+25-(n/2),y+30-(n/2),x+40-(n/2),y+15-(n/4),x+40-(n/2),y+15-(n/4),x+25-(n/2),y,x+25-(n/2),y,x,y};
		    	int[] puntosLinea = { x + 60 - n, y + 15-(n/4), x + 65-n, y + 15-(n/4), x + 65-n, y + 15-(n/4), x + 65-n, y + 65-n, x + 65-n, y + 65-n, x + 40-(n/2), y + 65-n};
		    	int[] puntosLinea2 = { x - 30+(n/2), y + 65-n, x - 60+n, y + 65-n, x - 60+n, y + 65-n, x - 60+n, y + 15, x - 60+n, y + 15,x - 50+n, y + 15};
		    	int[] puntosFlecha2 = { x + 40-(n/2), y + 65-n, x + 45-(n/2), y + 60-n, x + 40-(n/2), y + 65-n, x + 45-(n/2), y + 70-n};
		    	int[] puntosFlecha = { x - 50+n, y + 15, x - 55+n, y + 10, x - 50+n, y + 15, x - 55+n, y + 20};
		    	e.gc.drawPolygon(puntosRombo);
		    	e.gc.drawText((String) instrucciones.get(0), x - 15+n, y + 5-(n/4));
		        e.gc.drawPolyline(puntosLinea);
		        e.gc.drawPolyline(puntosLinea2);
		        e.gc.drawPolyline(puntosFlecha);
		        e.gc.drawPolyline(puntosFlecha2);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30-(n/2);
		dibujarLinea();
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	e.gc.drawText((String) instrucciones.get(1), x - 10, y+25-(n/2)+30-(n/2) + 5);
		    	e.gc.drawRectangle(x - 30+(n/2), y+25-(n/2)+30-(n/2), 60-n, 30-(n/2));
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30-(n/2);
		dibujarLinea();	
	}
	/**
	 * Dibuja en el canvas la representacion de una definicion de variable
	 * o instruccion
	 */
	@Override
	protected void definicionVariable(Grafo objeto, String anterior) {
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
    	ArrayList<Object> instrucciones = objeto.getInstrucciones(); 
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) {
		    	e.gc.drawText((String) instrucciones.get(1), x - 10, y + 5);
		    	e.gc.drawRectangle(x - 30+(n/2), y, 60-n, 30-(n/2));
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30-(n/2);
		dibujarLinea();
		
	}
	/**
	* Dibuja en el canvas la representacion de un metodo externo
	*/
	@Override
	protected void instruccionesVarias(Grafo objeto, String anterior) {
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
    	ArrayList<Object> instrucciones = objeto.getInstrucciones(); 
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) {
		    	e.gc.drawRectangle( x - 35+(n/2), y, 70-n, 30-(n/2));
		    	e.gc.drawText((String) instrucciones.get(1), x - 10, y + 5);
		    	e.gc.drawRectangle(x - 30+(n/2), y, 60-n, 30-(n/2));
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30-(n/2);
		dibujarLinea();
	}
	/**
	 * Dibuja en el canvas el inicio y el fin del diagrama
	*/
	protected void inicioFin(funciones.Grafo objeto1) {
		int y = ui.main.posicionY;
		int x = ui.main.posicionX;
		if (objeto1.hasNext()) {
			ui.main.canvas.addPaintListener(new PaintListener() { 
			    public void paintControl(PaintEvent e) { 
			    	e.gc.setBackground(new Color(ui.main.shell.getDisplay(), 0,0,0)); 
			    	if (n != 0) {
			    		e.gc.fillOval(x-3, y, 6, y+6); 
						e.gc.setBackground(new Color(ui.main.shell.getDisplay(), 255,255,255));
						
			    	}
			    	else {
			    		e.gc.fillOval(x-15, y, 30, 30); 
			    		e.gc.setBackground(new Color(ui.main.shell.getDisplay(), 255,255,255));
			    		}
			    }
			});
			if (n != 0) {
	    		ui.main.posicionX = 200;
	    		ui.main.posicionY += 6;
			}
			else {
	    		ui.main.posicionX = 200;
	    		ui.main.posicionY += 30;
			}
			dibujarLinea();
		}
		else {//cxkdfavfasdvsdavcfsdjacvsdkacvsdaycv  hacer boton actualizar 
			int b = ui.main.posicionY;
			int a = ui.main.posicionX;
			ui.main.canvas.addPaintListener(new PaintListener() { 
			    public void paintControl(PaintEvent e) {
			    	if (n != 0) {
				    	e.gc.setBackground(new Color(ui.main.shell.getDisplay(),0,0,0));
			    		e.gc.fillOval(a-3,b,6,6); 
						e.gc.setBackground(new Color(ui.main.shell.getDisplay(),255,255,255));
			    	}
			    	else {
			    		e.gc.fillOval(x-15,y,30,30); 
			    		e.gc.setBackground(new Color(ui.main.shell.getDisplay(), 255,255,255));
			    		}
			    }
			});
			ui.main.posicionY = 0;
		}
	}
	/**
	 * Dibuja en el canvas una linea para conectar cada nodo del diagrama
	 */
	private static void dibujarLinea() {
		int y = ui.main.posicionY;
		int x = ui.main.posicionX;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		        e.gc.drawLine(x, y, x, y+25-(n/2));
		    }
		});
		ui.main.posicionY += 25-(n/2);
	}
}
