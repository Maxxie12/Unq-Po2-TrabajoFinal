package ar.edu.unq.po2.Muestra;

public class MuestraNoVerificada implements EstadoMuestra{
	Muestra muestra;

	public MuestraNoVerificada(Muestra muestra) {
		this.muestra = muestra;
	}

	@Override
	public boolean esVerificada() {
		return false;
	}

	public void agregarOpinion(Opinion opinion) {
		this.muestra.agregarOpinion(opinion);
		this.muestra.actualizarOpinion();
	}

}
