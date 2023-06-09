package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Muestra.Muestra;

public class BuscadorOr extends BuscadorLogico {
	
	private IBuscadorMuestras primerBuscador;
	private IBuscadorMuestras segundoBuscador;
	


	public void setPrimerBuscador(IBuscadorMuestras primerBuscador) {
		this.primerBuscador = primerBuscador;
	}

	public void setSegundoBuscador(IBuscadorMuestras segundoBuscador) {
		this.segundoBuscador = segundoBuscador;
	}

	public IBuscadorMuestras getPrimerBuscador() {
		return this.primerBuscador;
	}

	public IBuscadorMuestras getSegundoBuscador() {
		return this.segundoBuscador;
	}

	
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
		
		List<Muestra> muestrasResultantes = new ArrayList <Muestra>();
		
	    muestrasResultantes.addAll(this.getPrimerBuscador().filtrar(muestrasAFiltrar));
	    muestrasResultantes.addAll(this.getSegundoBuscador().filtrar(muestrasAFiltrar));
		
		return muestrasResultantes.stream().distinct().toList(); // me quedo con todo lo que está en ambas listas y le saco los duplicados.
		
	}

	

}
