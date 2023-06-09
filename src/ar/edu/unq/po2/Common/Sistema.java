package ar.edu.unq.po2.Common;

import java.util.ArrayList;

import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Organizacion.Organizacion;
import ar.edu.unq.po2.Organizacion.ZonaDeCobertura;
import ar.edu.unq.po2.Usuario.Usuario;

public class Sistema {
	
	private ArrayList<Muestra> muestras;
	private ArrayList<Usuario> usuarios;
	private ArrayList<ZonaDeCobertura> zonasDeCobertura;
	private ArrayList<Organizacion> organizaciones;
	
	public Sistema(){
			muestras = new ArrayList<Muestra>();
			usuarios = new ArrayList<Usuario>();
			zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
			organizaciones = new ArrayList<Organizacion>();
	}
	
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

