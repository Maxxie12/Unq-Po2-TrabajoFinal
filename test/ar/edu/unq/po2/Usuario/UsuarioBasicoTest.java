package ar.edu.unq.po2.Usuario;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UsuarioBasicoTest {
	UsuarioBasico usuarioBasicoTest;
	@Mock
	Usuario usuarioDouble = mock(Usuario.class);
	UsuarioExperto usuarioExpertoDummy = mock(UsuarioExperto.class);
	
	@BeforeEach
	void setUp() {
		usuarioBasicoTest = new UsuarioBasico(usuarioDouble);
	}
	
	@Test
		public void elUsuarioBasicoNoEsExperto() {
			//exercise
			boolean valorUsuarioEsExperto = usuarioBasicoTest.esExperto();
			//verify
			assertFalse(valorUsuarioEsExperto);
		}
	
	@Test
		public void elSetStateCambiaElEstadoDeUsuario() {
		//setup
		ArgumentCaptor<UsuarioExperto> usuarioCapturado = ArgumentCaptor.forClass(UsuarioExperto.class);
		//exercise
		usuarioBasicoTest.setState();
		//verify
		Mockito.verify(usuarioDouble).cambiarEstado(usuarioCapturado.capture());
		}
	
	@Test
	
		public void elUsuarioBasicoActualizaEstadoSiCumpleCondicion() {
		//setup
		ArgumentCaptor<UsuarioExperto> usuarioCapturado = ArgumentCaptor.forClass(UsuarioExperto.class);
		//exercise
		usuarioBasicoTest.actualizarEstado(21, 11);
		//verify
		Mockito.verify(usuarioDouble).cambiarEstado(usuarioCapturado.capture());
		}
	
	@Test
		public void elUsuarioBasicoNoActualizaEstadoSiNoCumpleCondicion() {
			//exercise
			usuarioBasicoTest.actualizarEstado(8, 9);
			//verify
			Mockito.verify(usuarioDouble, never()).cambiarEstado(usuarioExpertoDummy);
		}
}
