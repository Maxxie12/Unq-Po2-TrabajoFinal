package ar.edu.unq.po2.Common;
import java.util.ArrayList;
import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.MuestraVerificada;
import ar.edu.unq.po2.Muestra.Opinion;
import java.util.*;

public class ClasificadorDeMuestras {
	private Sistema sistema;
	
	public ClasificadorDeMuestras(Sistema sistema) {
		this.sistema = sistema;
	}

	public void clasificarMuestras() {
	List<Muestra> muestrasNoVerificadas = this.sistema.getMuestras().stream().filter(muestra -> (muestra.esVerificada().equals(false))).toList();
	muestrasNoVerificadas.stream().filter(muestra -> muestra.opinionesExpertos().stream().count() >= 2);
	this.clasificar(muestrasNoVerificadas);
	}

	public void clasificar(List<Muestra> muestras) {
		muestras.stream().forEach(muestra -> muestra.cambiarEstado(new MuestraVerificada()));;
	}
}
