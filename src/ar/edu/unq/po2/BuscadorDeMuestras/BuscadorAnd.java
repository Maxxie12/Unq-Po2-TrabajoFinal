package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Muestra.Muestra;

public class BuscadorAnd extends BuscadorMuestras{
	
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
		List<Muestra> muestrasAFiltrarPorPrimerBuscador  = new ArrayList<Muestra>();
		List<Muestra> muestrasAFiltrarPorSegundoBuscador = new ArrayList<Muestra>();
		
		muestrasAFiltrarPorPrimerBuscador.addAll(this.getPrimerBuscador().filtrar(muestrasAFiltrar));
		muestrasAFiltrarPorSegundoBuscador.addAll(this.getSegundoBuscador().filtrar(muestrasAFiltrar));
		
		muestrasAFiltrarPorPrimerBuscador.retainAll(muestrasAFiltrarPorSegundoBuscador); // Me quedo con las muestras que aparecen en ambas listas
		return(muestrasAFiltrarPorPrimerBuscador);
		
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
