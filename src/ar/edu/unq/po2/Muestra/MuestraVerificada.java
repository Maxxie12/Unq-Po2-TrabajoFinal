package ar.edu.unq.po2.Muestra;

public class MuestraVerificada implements IEstadoMuestra{

	@Override
	public boolean esVerificada() {
		return true;
	}
	
	public void agregarOpinion(Opinion opinion) {
		System.out.println("La muestra ya ha sido verificada");
	}
	
}
