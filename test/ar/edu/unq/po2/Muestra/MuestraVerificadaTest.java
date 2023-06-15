package ar.edu.unq.po2.Muestra;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MuestraVerificadaTest {
	@Mock
	Opinion opinionDummy = mock(Opinion.class);
	Muestra muestraDouble = mock(Muestra.class);

	@Test
	public void LaMuestraEsVerificada() {
		//setup 
		MuestraVerificada muestraVerificadaTest = new MuestraVerificada();
		// exercise
		Boolean valorMuestraVerificada = muestraVerificadaTest.esVerificada();
		// verify
		assertTrue(valorMuestraVerificada);
}

	@Test
	public void agregarOpinion() {
		//setup 
		MuestraVerificada muestraVerificadaTest = new MuestraVerificada();
		// exercise
		muestraVerificadaTest.agregarOpinion(opinionDummy);
		// verify
		Mockito.verify(muestraDouble, never()).agregarOpinionDe(opinionDummy);
		Mockito.verify(muestraDouble, never()).actualizarOpinion();;
}
}
