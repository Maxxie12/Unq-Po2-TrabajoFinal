package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Muestra.Muestra;

public class BuscadorCompuesto implements IBuscadorMuestras{
	
	private List<IBuscadorMuestras> buscadoresMuestras = new ArrayList<IBuscadorMuestras>();

	@Override
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
		List<IBuscadorMuestras> buscadoresAAplicar = this.buscadoresMuestras;
		List<Muestra> resultadosFiltrados = new ArrayList<Muestra>();

		for (IBuscadorMuestras buscadores : buscadoresAAplicar) {
			resultadosFiltrados = buscadores.filtrar(muestrasAFiltrar);

		}

		return (resultadosFiltrados = resultadosFiltrados.stream().collect(Collectors.toSet()).stream()
				.collect(Collectors.toList()));

	}

	public void addBuscador(IBuscadorMuestras buscadorMuestras) {
		buscadoresMuestras.add(buscadorMuestras);

	}

	public void removeBuscador(IBuscadorMuestras buscadorMuestras) {
		buscadoresMuestras.remove(buscadorMuestras);
	}

	

}
