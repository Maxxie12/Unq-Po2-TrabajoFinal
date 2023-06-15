package ar.edu.unq.po2.Usuario;

public class UsuarioBasicoTest {
	@Mock
	Usuario usuarioDouble = mock(Usuario.class);
	UsuarioExperto usuarioExpertoDummy = mock(UsuarioExperto.class);
	
	@Test
		public void elUsuarioBasicoNoEsExperto() {
			//setUp
			UsuarioBasico usuarioBasicoTest = new UsuarioBasico(usuarioDouble);
			//exercise
			boolean valorUsuarioEsExperto = usuarioBasicoTest.esExperto();
			//verify
			assertFalse(valorUsuarioEsExperto);
		}
	
	@Test
		public void elSetStateCambiaElEstadoDeUsuario() {
		//setUp
		UsuarioBasico usuarioBasicoTest = new UsuarioBasico(usuarioDouble);
		//exercise
		usuarioBasicoTest.setState();
		//verify
		Mockito.verify(usuarioDouble).cambiarEstado(usuarioExpertoDummy);
		}
	
	@Test
	
		public void elUsuarioBasicoActualizaEstadoSiCumpleCondicion() {
		//setUp
		UsuarioBasico usuarioBasicoTest = new UsuarioBasico(usuarioDouble);
		//exercise
		usuarioBasicoTest.actualizarEstado(11, 21);
		//verify
		Mockito.verify(usuarioDouble).cambiarEstado(usuarioExpertoDummy);
		}
	
	@Test
		public void elUsuarioBasicoNoActualizaEstadoSiNoCumpleCondicion() {
			//setUp
			UsuarioBasico usuarioBasicoTest = new UsuarioBasico(usuarioDouble);
			//exercise
			usuarioBasicoTest.actualizarEstado(10, 20);
			//verify
			Mockito.verify(usuarioDouble, never()).cambiarEstado(usuarioExpertoDummy);
		}
}
