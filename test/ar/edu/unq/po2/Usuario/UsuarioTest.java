package ar.edu.unq.po2.Usuario;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import ar.edu.unq.po2.Common.Sistema;
import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.Opinion;

public class UsuarioTest {
	Usuario usuarioTest;
	@Mock
	UsuarioBasico usuarioBasicoDummy = mock(UsuarioBasico.class);
	Muestra muestraDouble = mock(Muestra.class);
	Opinion opinionDummy = mock(Opinion.class);
	Sistema sistemaDouble = mock(Sistema.class);
	
	@BeforeEach
	void setUp() {
		usuarioTest = new Usuario(1, "jose");
	}
	
	@Test
	public void unUsuarioSeInicializaComoBasico() {
		//exercise
		EstadoUsuario estadoUsuarioTest = usuarioTest.getState();
		//verify
		assertTrue(estadoUsuarioTest instanceof UsuarioBasico);
	}
	
	@Test
	public void unUsuarioPuedaDarUnaOpinion(){
		//exercise
		usuarioTest.darOpinion(muestraDouble, opinionDummy);	
		// verify
		Mockito.verify(muestraDouble).agregarOpinion(opinionDummy);
	}
	
	@Test
	public void unUsuarioPuedeSubirUnaMuestra() {
		//exercise
		usuarioTest.enviarMuestra(muestraDouble, sistemaDouble);
		//verify
		Mockito.verify(sistemaDouble).agregarMuestra(muestraDouble);
	}
	
	@Test 
	public void unUsuarioPuedeActualizarSuEstado(){
		//exercise
		usuarioTest.actualizarEstado(21, 11);
		//verify
		assertTrue(usuarioTest.getState() instanceof UsuarioExperto);
	}
}