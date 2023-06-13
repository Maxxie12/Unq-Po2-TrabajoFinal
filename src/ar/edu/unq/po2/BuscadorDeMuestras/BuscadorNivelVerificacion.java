package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Muestra.IEstadoMuestra;
import ar.edu.unq.po2.Muestra.Muestra;

public class BuscadorNivelVerificacion implements IBuscadorMuestras{
	
	private IEstadoMuestra estadoMuestraABuscar;

	    public void setEstadoMuestraABuscar(IEstadoMuestra estadoMuestraABuscar) {
	        this.estadoMuestraABuscar = estadoMuestraABuscar;
	    }

	    @Override
	    public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
	        List<Muestra> resultado = muestrasAFiltrar.stream()
	                .filter(muestra -> muestra.getEstadoMuestra().equals(estadoMuestraABuscar))
	                .collect(Collectors.toList());
	        return resultado;
	    }


}
