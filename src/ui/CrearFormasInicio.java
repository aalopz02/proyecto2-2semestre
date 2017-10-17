package ui;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import funciones.Grafo;
import java.util.ArrayList;

public class CrearFormasInicio extends Formas {

	@Override
	protected void condicion(Grafo objeto, String anterior) {
		ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntos = { x, y, x - 50, y + 15, x, y + 30, x + 50, y + 15};
		    	int[] puntosLinea = { x + 50, y + 15, x + 60, y + 15, x + 60, y + 15, x + 60, y + 65};
		    	int[] puntosLinea2 = { x - 50, y + 15, x - 60, y + 15, x - 60, y + 15, x - 60, y + 65};
		    	int[] puntosLinea3 = {x - 30, y + 80, x + 30, y + 80, x, y + 80, x, y+ 100};
		    	e.gc.drawRectangle(x - 90, y + 65, 60, 30);
		    	e.gc.drawText(instrucciones.get(1), x - 85, y + 70);
		    	e.gc.drawRectangle(x + 30, y + 65, 60, 30);
		    	e.gc.drawText(instrucciones.get(2), x + 35, y + 70);
		        e.gc.drawPolygon(puntos);
		        e.gc.drawText(instrucciones.get(0), x - 15, y + 5);
		        e.gc.drawPolyline(puntosLinea);
		        e.gc.drawText("SI", x - 80, y + 15);
		        e.gc.drawPolyline(puntosLinea2);
		        e.gc.drawText("NO", x + 70, y + 15);
		        e.gc.drawPolyline(puntosLinea3);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 100;
		dibujarLinea();
		
	}

	@Override
	protected void cicloWhile(Grafo objeto, String anterior) {
		ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntosRombo = { x, y, x - 50, y + 15, x, y + 30, x + 50, y + 15};
		    	int[] puntosLinea = { x + 50, y + 15, x + 60, y + 15, x + 60, y + 15, x + 60, y + 65, x + 60, y + 65, x + 40, y + 65};
		    	int[] puntosLinea2 = { x - 30, y + 70, x - 60, y + 70, x - 60, y + 70, x - 60, y + 15, x - 60, y + 15,x - 50, y + 15};
		    	int[] puntosFlecha2 = { x + 40, y + 65, x + 45, y + 60, x + 40, y + 65, x + 45, y + 70};
		    	int[] puntosFlecha = { x - 50, y + 15, x - 55, y + 10, x - 50, y + 15, x - 55, y + 20};
		    	e.gc.drawPolygon(puntosRombo);
		    	e.gc.drawText(instrucciones.get(0), x - 15, y + 5);
		        e.gc.drawPolyline(puntosLinea);
		        e.gc.drawPolyline(puntosLinea2);
		        e.gc.drawPolyline(puntosFlecha);
		        e.gc.drawPolyline(puntosFlecha2);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30;
		dibujarLinea();
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	e.gc.drawRectangle( x - 30, y + 55, 60, 30);
		    	e.gc.drawText(instrucciones.get(1), x - 25, y + 60);
		    	
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30;
		dibujarLinea();
		
		
	}

	@Override
	protected void cicloFor(Grafo objeto, String anterior) {
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
    	ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntosRombo = { x, y, x - 25, y, x - 25, y, x - 50, y + 15, x - 50, y + 15, x - 25, y + 30,  x - 25, y + 30, x + 25, y + 30, x + 25, y + 30, x + 50, y + 15, x + 50, y + 15,x + 25, y, x + 25, y, x, y};
		    	int[] puntosLinea = { x + 50, y + 15, x + 60, y + 15, x + 60, y + 15, x + 60, y + 65, x + 60, y + 65, x + 40, y + 65};
		    	int[] puntosLinea2 = { x - 30, y + 70, x - 60, y + 70, x - 60, y + 70, x - 60, y + 15, x - 60, y + 15,x - 50, y + 15};
		    	int[] puntosFlecha2 = { x + 40, y + 65, x + 45, y + 60, x + 40, y + 65, x + 45, y + 70};
		    	int[] puntosFlecha = { x - 50, y + 15, x - 55, y + 10, x - 50, y + 15, x - 55, y + 20};
		    	e.gc.drawPolygon(puntosRombo);
		    	e.gc.drawText(instrucciones.get(0), x - 15, y + 5);
		        e.gc.drawPolyline(puntosLinea);
		        e.gc.drawPolyline(puntosLinea2);
		        e.gc.drawPolyline(puntosFlecha);
		        e.gc.drawPolyline(puntosFlecha2);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30;
		dibujarLinea();
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	e.gc.drawRectangle( x - 30, y + 55, 60, 30);
		    	e.gc.drawText(instrucciones.get(1), x - 25, y + 60);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30;
		dibujarLinea();
		
	}

	@Override
	protected void definicionVariable(Grafo objeto, String anterior) {
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
    	ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	e.gc.drawRectangle( x - 30, y, 60, 30);
		    	e.gc.drawText(instrucciones.get(1), x - 25, y + 10);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30;
		dibujarLinea();
		
	}

	@Override
	protected void instruccionesVarias(Grafo objeto, String anterior) {
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
    	ArrayList<String> instrucciones = objeto.getInstrucciones(); 
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) {
		    	e.gc.drawRectangle( x - 35 , y, 70, 30);
		    	e.gc.drawRectangle( x - 30, y, 60, 30);
		    	e.gc.drawText(instrucciones.get(1), x - 25, y + 10);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30;
		dibujarLinea();
		
	}
	
	protected void inicioFin(funciones.Grafo objeto1) {
		int y = ui.main.posicionY;
		int x = ui.main.posicionX;
		
		if (objeto1.hasNext()) {
			ui.main.canvas.addPaintListener(new PaintListener() { 
			    public void paintControl(PaintEvent e) { 
			        e.gc.drawOval(x, y, 30, 30);
			    }
			});
			ui.main.posicionX += 15;
			ui.main.posicionY += 30;
			dibujarLinea();
		}
		else {
			ui.main.canvas.addPaintListener(new PaintListener() { 
			    public void paintControl(PaintEvent e) { 
			        e.gc.drawOval(x - 15, y, 30, 30);
			    }
			});
		}
	}
	
	private static void dibujarLinea() {
		int y = ui.main.posicionY;
		int x = ui.main.posicionX;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		        e.gc.drawLine(x, y + 25, x, y);
		 
		    }
		});
		ui.main.posicionY += 25;
	}
}
