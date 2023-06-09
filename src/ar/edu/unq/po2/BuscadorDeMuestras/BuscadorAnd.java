package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Muestra.Muestra;

public class BuscadorAnd extends BuscadorLogico{
	
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
		List<Muestra> muestrasAFiltrarPorPrimerBuscador  = new ArrayList<Muestra>();
		List<Muestra> muestrasAFiltrarPorSegundoBuscador = new ArrayList<Muestra>();
		
		muestrasAFiltrarPorPrimerBuscador.addAll(this.getPrimerBuscador().filtrar(muestrasAFiltrar));
		muestrasAFiltrarPorSegundoBuscador.addAll(this.getSegundoBuscador().filtrar(muestrasAFiltrar));
		
		muestrasAFiltrarPorPrimerBuscador.retainAll(muestrasAFiltrarPorSegundoBuscador); // Me quedo con las muestras que aparecen en ambas listas
		return(muestrasAFiltrarPorPrimerBuscador);
		
	}


}
