package ar.edu.unq.po2.TrabajoFinal;

import java.util.ArrayList;

import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Usuario.Usuario;

public class Sistema {
	
	private ArrayList<Muestra> muestras;
	private ArrayList<Usuario> usuarios;
	private ArrayList<ZonaDeCobertura> zonasDeCobertura;
	private ArrayList<Organizacion> organizaciones;
	
	public void agregarMuestra(Muestra muestra) {
		this.muestras.add(muestra);
	}
	
	public ArrayList<Muestra> getMuestras() {
		return muestras;
	}

	public void setMuestras(ArrayList<Muestra> muestras) {
		this.muestras = muestras;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<ZonaDeCobertura> getZonasDeCobertura() {
		return zonasDeCobertura;
	}

	public void setZonasDeCobertura(ArrayList<ZonaDeCobertura> zonasDeCobertura) {
		this.zonasDeCobertura = zonasDeCobertura;
	}

	public ArrayList<Organizacion> getOrganizaciones() {
		return organizaciones;
	}

	public void setOrganizaciones(ArrayList<Organizacion> organizaciones) {
		this.organizaciones = organizaciones;
	}

}

