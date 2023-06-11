package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Muestra.Muestra;

public class BusquedaNivelVerificacion implements IBuscadorMuestras{
	
	

	@Override
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
		List<Muestra> resultado = new ArrayList<>();
		resultado = muestrasAFiltrar.stream()
				.filter(muestra -> muestra.get)
                .collect(Collectors.toList());
		return (resultado);
		
		
		
		
	}



}
