package ar.edu.unq.po2.Usuario;

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
		//exercise
		usuarioBasicoTest.setState();
		//verify
		Mockito.verify(usuarioDouble).cambiarEstado(usuarioBasicoDummy);
		}
	
	@Test
	
		public void elUsuarioBasicoActualizaEstadoSiCumpleCondicion() {
		//setUp
		UsuarioExperto usuarioBasicoTest = new UsuarioExperto(usuarioDouble);
		//exercise
		usuarioBasicoTest.actualizarEstado(10, 20);
		//verify
		Mockito.verify(usuarioDouble).cambiarEstado(usuarioBasicoDummy);
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
