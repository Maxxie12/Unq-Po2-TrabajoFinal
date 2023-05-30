package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.List;

import ar.edu.unq.po2.TrabajoFinal.Muestra;

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

	
	public List<Muestra> filtrar(List<Muestra> Muestras) {
		// TODO Auto-generated method stub
		return null;
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
