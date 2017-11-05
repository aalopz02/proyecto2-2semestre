package proyecto_2.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * Clase basada de los ejecplos de eclipse para hacer un manejador que inicia la aplicacion
 */
public class Handler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ui.main.ejecutar();
		return null;
	}
}
