package ar.edu.unq.po2.Usuario;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UsuarioExpertoTest {
	@Mock
	Usuario usuarioDouble = mock(Usuario.class);
	UsuarioBasico usuarioBasicoDummy = mock(UsuarioBasico.class);
	
	@Test
		public void elUsuarioExpertoEsExperto() {
			//setUp
			UsuarioExperto usuarioBasicoTest = new UsuarioExperto(usuarioDouble);
			//exercise
			boolean valorUsuarioEsExperto = usuarioBasicoTest.esExperto();
			//verify
			assertTrue(valorUsuarioEsExperto);
		}
	
	@Test
		public void elSetStateCambiaElEstadoDeUsuario() {
		//setUp
		UsuarioExperto usuarioBasicoTest = new UsuarioExperto(usuarioDouble);
		ArgumentCaptor<UsuarioExperto> usuarioCapturado = ArgumentCaptor.forClass(UsuarioExperto.class);
		//exercise
		usuarioBasicoTest.setState();
		//verify
		Mockito.verify(usuarioDouble).cambiarEstado(usuarioCapturado.capture());
		}
	
	@Test
	
		public void elUsuarioBasicoActualizaEstadoSiCumpleCondicion() {
		//setUp
		UsuarioExperto usuarioBasicoTest = new UsuarioExperto(usuarioDouble);
		ArgumentCaptor<UsuarioExperto> usuarioCapturado = ArgumentCaptor.forClass(UsuarioExperto.class);
		//exercise
		usuarioBasicoTest.actualizarEstado(10, 20);
		//verify
		Mockito.verify(usuarioDouble).cambiarEstado(usuarioCapturado.capture());
		}
	
	@Test
		public void elUsuarioBasicoNoActualizaEstadoSiNoCumpleCondicion() {
			//setUp
			UsuarioExperto usuarioBasicoTest = new UsuarioExperto(usuarioDouble);
			//exercise
			usuarioBasicoTest.actualizarEstado(11, 21);
			//verify
			Mockito.verify(usuarioDouble, never()).cambiarEstado(usuarioBasicoDummy);
		}
}
