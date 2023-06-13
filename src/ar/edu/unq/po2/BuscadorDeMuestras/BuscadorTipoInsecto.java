package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.OpinionImagen;

public class BuscadorTipoInsecto implements IBuscadorMuestras{
	
public	String insectoABuscar;

	
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
		List<Muestra> resultado = new ArrayList<>();

		  resultado = muestrasAFiltrar.stream()
		            .filter(muestra -> muestra.getTipoInsecto().name().toLowerCase().contains(insectoABuscar.toLowerCase()))
		            .collect(Collectors.toList());

		    return resultado;
	}

	
	public 	void setInsectoABuscar (String insectoABuscar){
	 	this.insectoABuscar = insectoABuscar;
	}

}
