package ar.edu.unq.po2.Usuario;

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