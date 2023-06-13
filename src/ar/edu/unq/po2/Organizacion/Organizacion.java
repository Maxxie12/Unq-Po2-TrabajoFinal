package ar.edu.unq.po2.Organizacion;

import java.util.List;

import ar.edu.unq.po2.Muestra.Muestra;



public class Organizacion implements ObserverZonaCobertura {
	
	private Ubicacion ubicacion;
	private TipoDeOrganizacion tipo;
	private int cantidadPersonas;
	private FuncionalidadExterna cargaMuestra;
	private FuncionalidadExterna validacionMuestra;
	
	
	
	
	public Organizacion(Ubicacion ubicacion, TipoDeOrganizacion tipo, int cantidadPersonas,
						FuncionalidadExterna cargaMuestra, FuncionalidadExterna validacionMuestra) {
		super();
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.cantidadPersonas = cantidadPersonas;
		this.cargaMuestra = cargaMuestra;
		this.validacionMuestra = validacionMuestra;
	}


	public Ubicacion getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}


	public TipoDeOrganizacion getTipo() {
		return tipo;
	}


	
	public void setTipo(TipoDeOrganizacion tipo) {
		this.tipo = tipo;
	}

	
	public int getCantidadPersonas() {
		return cantidadPersonas;
	}
	
	
	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}



	public FuncionalidadExterna getCargaMuestra() {
		return cargaMuestra;
	}



	public void setCargaMuestra(FuncionalidadExterna cargaMuestra) {
		this.cargaMuestra = cargaMuestra;
	}



	public FuncionalidadExterna getValidacionMuestra() {
		return validacionMuestra;
	}



	public void setValidacionMuestra(FuncionalidadExterna validacionMuestra) {
		this.validacionMuestra = validacionMuestra;
	}


	
	
	
	
	@Override
	public void nuevaCargaMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		this.getCargaMuestra().nuevoEvento(this, zonaDeCobertura, muestra);
	}
 
	@Override
	public void nuevaValidacionMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		this.getValidacionMuestra().nuevoEvento(this, zonaDeCobertura, muestra);
	}	
	
	
	
	public void suscribirseAValidacionMuestraZona(ZonaDeCobertura zona) {
		zona.suscribirAValidacion(this);
	}

	public void suscribirseACargaMuestraZona(ZonaDeCobertura zona) {
		zona.suscribirACarga(this);
	}

	public void desuscribirseDeValidacionMuestraZona(ZonaDeCobertura zona) {
		zona.desuscribirDeValidacion(this);
	}
	
	public void desuscribirseDeCargaMuestraZona(ZonaDeCobertura zona) {
		zona.desuscribirDeCarga(this);
	}
	
	
	
	
	
	
	
	
	
}