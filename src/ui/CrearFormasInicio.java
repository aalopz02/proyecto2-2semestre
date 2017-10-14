package ui;

import java.util.ArrayList;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import funciones.Grafo;

public class CrearFormasInicio extends Formas {

	@Override
	protected void condicion(Grafo objeto) {
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	int[] puntos = { x, y, x - 50, y + 15, x, y + 30, x + 50, y + 15};
		        e.gc.drawPolygon(puntos);;
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30;
		dibujarLinea();
		
	}

	@Override
	protected void cicloWhile(Grafo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void cicloFor(Grafo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void definicionVariable(Grafo objeto) {
		int y = ui.main.posicionY;
    	int x = ui.main.posicionX;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		    	e.gc.drawRectangle( x - 30, y, 60, 30);
		    }
		});
		ui.main.posicionX += 0;
		ui.main.posicionY += 30;
		dibujarLinea();
		
	}

	@Override
	protected void instruccionesVarias(Grafo objeto) {
		// TODO Auto-generated method stub
		
	}
	
	protected void inicioFin(funciones.Grafo objeto1) {
		Rectangle posicion = (Rectangle) objeto1.getContenido();
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		        e.gc.drawOval(posicion.width, posicion.height, 30, 30);
		    }
		});
		ui.main.posicionX += 15;
		ui.main.posicionY += 30;
		dibujarLinea();
	}
	
	private static void dibujarLinea() {
		int y = ui.main.posicionY;
		ui.main.canvas.addPaintListener(new PaintListener() { 
		    public void paintControl(PaintEvent e) { 
		        e.gc.drawLine(ui.main.posicionX, y + 25, ui.main.posicionX, y);
		 
		    }
		});
		ui.main.posicionY += 25;
	}
}
