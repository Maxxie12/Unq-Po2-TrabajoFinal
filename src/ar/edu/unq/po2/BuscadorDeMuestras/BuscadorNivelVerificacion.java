package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.List;
import java.util.stream.Collectors;


import ar.edu.unq.po2.Muestra.Muestra;

public class BuscadorNivelVerificacion implements IBuscadorMuestras{
	
	private boolean estadoMuestraABuscar;

	public void setEstadoMuestraABuscar(boolean esVerificada) {
	    this.estadoMuestraABuscar = esVerificada;
	}

	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
	    List<Muestra> resultado = muestrasAFiltrar.stream()
	            .filter(muestra -> muestra.getEstadoMuestra().esVerificada() == estadoMuestraABuscar)
	            .collect(Collectors.toList());
	    return resultado;
	}


}
