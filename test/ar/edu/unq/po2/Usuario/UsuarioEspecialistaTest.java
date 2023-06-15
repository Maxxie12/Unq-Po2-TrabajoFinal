package ar.edu.unq.po2.Usuario;

public class UsuarioEspecialistaTest {
	@Test
	public void elUsuarioEspecialistaEsExperto() {
		//setUp
		UsuarioEspecialista usuarioEspecialistaTest = new UsuarioEspecialista(1, "carlos");
		//exercise
		Boolean valorUsuarioExperto = usuarioEspecialistaTest.esExperto();
		//verify
		assertTrue(valorUsuarioExperto);
	}

	@Test 
		public void elUsuarioEspecialistaNoPuedeActualizarSuEstado() {
			//setUp
			UsuarioEspecialista usuarioEspecialistaTest = new UsuarioEspecialista(1, "carlos");
			//exercise
			usuarioEspecialistaTest.actualizarEstado(15, 20);;
			//verify
			assertTrue(usuarioEspecialistaTest.getState() instanceof UsuarioExperto);
	}
}
