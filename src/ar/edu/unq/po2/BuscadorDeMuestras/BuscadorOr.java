package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Muestra.Muestra;

public class BuscadorOr extends BuscadorMuestras {
	
	private BuscadorMuestras primerBuscador;
	private BuscadorMuestras segundoBuscador;
	


	public void setPrimerBuscador(BuscadorMuestras primerBuscador) {
		this.primerBuscador = primerBuscador;
	}

	public void setSegundoBuscador(BuscadorMuestras segundoBuscador) {
		this.segundoBuscador = segundoBuscador;
	}

	public BuscadorMuestras getPrimerBuscador() {
		return this.primerBuscador;
	}

	public BuscadorMuestras getSegundoBuscador() {
		return this.segundoBuscador;
	}

	
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
		
		List<Muestra> muestrasResultantes = new ArrayList <Muestra>();
		
	    muestrasResultantes.addAll(this.getPrimerBuscador().filtrar(muestrasAFiltrar));
	    muestrasResultantes.addAll(this.getSegundoBuscador().filtrar(muestrasAFiltrar));
		
		return muestrasResultantes.stream().distinct().toList(); // me quedo con todo lo que está en ambas listas y le saco los duplicados.
		
	}

	@Override
	public void agregarBuscador(BuscadorMuestras buscadorMuestras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarBuscador(BuscadorMuestras buscadorMuestras) {
		// TODO Auto-generated method stub
		
	}

}
