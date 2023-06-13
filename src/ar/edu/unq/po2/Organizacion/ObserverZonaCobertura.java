package ar.edu.unq.po2.Organizacion;

import ar.edu.unq.po2.Muestra.Muestra;



public interface ObserverZonaCobertura {
	
	public void nuevaCargaMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra);
	
	public void nuevaValidacionMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra);
	
	
}
