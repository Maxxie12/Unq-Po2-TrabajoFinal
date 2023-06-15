package ar.edu.unq.po2.TrabajoFinal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.Opinion;
import ar.edu.unq.po2.Usuario.Usuario;


public class ClasificadorDeUsuariosTest {
	ClasificadorDeUsuarios clasificadorTest;
	ArrayList<Muestra> listaMuestra;
	ArrayList<Opinion> listaOpiniones;
	ArrayList<Usuario> listaUsuarios;
	@Mock
	// se mockea sistema
	Sistema sistemaDouble = mock(Sistema.class);
	// se mockea opinion
	Opinion opinionDouble = mock(Opinion.class);
	Opinion opinionDouble1 = mock(Opinion.class);
	// se mockean las muestras
	Muestra muestraDouble = mock(Muestra.class);
	Muestra muestraDouble1 = mock(Muestra.class);
	Muestra muestraDouble2 = mock(Muestra.class);
	// se mockean los usuarios
	Usuario usuarioDouble = mock(Usuario.class);
	Usuario usuarioDouble1 = mock(Usuario.class);
	@BeforeEach
	void setUp() {
		// seteo listas
		listaMuestra = new ArrayList<Muestra>();
		listaOpiniones = new ArrayList<Opinion>();
		//seteo comportamiento sistema
		when(sistemaDouble.getMuestras()).thenReturn(listaMuestra);
		clasificadorTest = new ClasificadorDeUsuarios(sistemaDouble);

	}
	
	@Test
	public void elClasificadorObtieneLasMuestrasPublicadasPorElUsuarioDeLosUltimos30Dias() {
		//setUp
		listaMuestra.add(muestraDouble);
		when(muestraDouble.getUsuario()).thenReturn(usuarioDouble);
		when(muestraDouble.getFechaCreacion()).thenReturn(LocalDate.now());
		// exercise
		List<Muestra> muestras = clasificadorTest.muestrasPublicadasPorUsuario(usuarioDouble);
		//verify
		assertEquals(1, muestras.size());
		assertTrue(muestras.get(0).getUsuario().equals(usuarioDouble));
	}
	
	
	@Test
	public void elClasificadorRetornaLasOpinionesDelUsuarioDeLosUltimos30Dias() {
		//setUp
			// se agregan muestras a la lista
		listaMuestra.add(muestraDouble);
		listaMuestra.add(muestraDouble1);
			// se le da comportamiento a la muestra
		when(muestraDouble.elUsuarioNoOpino(usuarioDouble)).thenReturn(false);
		when(muestraDouble.opinionDeUsuario(usuarioDouble)).thenReturn(opinionDouble);
		when(muestraDouble1.opinionDeUsuario(usuarioDouble)).thenReturn(opinionDouble1);
			// se le da comportamiento a las opininiones
		when(opinionDouble.getFechaPublicacion()).thenReturn(LocalDate.now());
		when(opinionDouble1.getFechaPublicacion()).thenReturn(LocalDate.now());
		//exercise 
		List<Opinion> opiniones = clasificadorTest.opinionesDeMuestras(usuarioDouble);
		//verify
		assertEquals(2, opiniones.size());
	}
	
	@Test
	public void elClasificadorActualizaALosUsuariosQueCorresponden() {
		//exercise
		clasificadorTest.clasificarUsuarioPor(listaMuestra, listaOpiniones, usuarioDouble);
		//verify
		Mockito.verify(usuarioDouble).actualizarEstado(0, 0);
	}
}
