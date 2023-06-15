package ar.edu.unq.po2.Muestra;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MuestraNoVerificadaTest {
	@Mock
	Muestra muestraDouble = mock(Muestra.class);
	Opinion opinionDummy = mock(Opinion.class);
	

	@Test  
	public void laMuestraNoEsVerificada() {
		//setup
		MuestraNoVerificada muestraNoVerificada = new MuestraNoVerificada(muestraDouble);
		//exercise 
		Boolean valorDeLaMuestra = muestraNoVerificada.esVerificada();
		//verify
		assertFalse(valorDeLaMuestra);
}	

	@Test
	public void laMuestraNoVerificadaEnviaLosMensajesALaMuestra() {
		//setup
		MuestraNoVerificada muestraNoVerificada = new MuestraNoVerificada(muestraDouble);
		//exercise
		muestraNoVerificada.agregarOpinion(opinionDummy);
		//verify
		Mockito.verify(muestraDouble).actualizarOpinion();
		Mockito.verify(muestraDouble).agregarOpinionDe(opinionDummy);
}
}
