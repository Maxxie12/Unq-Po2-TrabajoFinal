package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.List;

import ar.edu.unq.po2.TrabajoFinal.Muestra;

public abstract class BuscadorMuestras {

	public abstract List<Muestra> filtrar(List <Muestra> muestrasAFiltrar);
	
    public abstract void agregarBuscador(BuscadorMuestras buscadorMuestras);
	
	public abstract void quitarBuscador(BuscadorMuestras buscadorMuestras);
		
	
}
