package ar.edu.unq.po2.Muestra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ar.edu.unq.po2.Organizacion.Ubicacion;
import ar.edu.unq.po2.Usuario.Usuario;
import ar.edu.unq.po2.Usuario.UsuarioEspecialista;
import ar.edu.unq.po2.Usuario.UsuarioExperto;

public class MuestraTest {
	Muestra muestraTest;
	@Mock
	Ubicacion ubicacionDouble = mock(Ubicacion.class);
	Usuario usuarioBasicoDouble = mock(Usuario.class);
	Usuario usuarioBasicoDosDouble = mock(Usuario.class);
	UsuarioEspecialista usuarioExpertoDouble = mock(UsuarioEspecialista.class);
	Opinion opinionDouble = mock(Opinion.class);
	Opinion opinionDosDouble = mock(Opinion.class);
	Opinion opinionTresDouble = mock(Opinion.class);
	Opinion opinionCuatroDouble = mock(Opinion.class);
	
	
	@BeforeEach
	void setUp() {
		// comportamiento para usuarios
		when(usuarioBasicoDouble.getId()).thenReturn(1);
		when(usuarioBasicoDosDouble.getId()).thenReturn(2);
		when(usuarioExpertoDouble.getId()).thenReturn(3);
		when(usuarioExpertoDouble.esExperto()).thenReturn(true);
		// comportamiento para opiniones
			// seteo de usuarios para opiniones
		when(opinionDouble.getUsuario()).thenReturn(usuarioBasicoDouble);
		when(opinionDosDouble.getUsuario()).thenReturn(usuarioBasicoDosDouble);
		when(opinionTresDouble.getUsuario()).thenReturn(usuarioExpertoDouble);
			// seteo de enums para opiniones
		when(opinionDouble.getOpinion()).thenReturn(OpinionImagen.CHINCHE_FOLIADA);
		when(opinionDosDouble.getOpinion()).thenReturn(OpinionImagen.IMAGEN_POCO_CLARA);
		when(opinionTresDouble.getOpinion()).thenReturn(OpinionImagen.IMAGEN_POCO_CLARA);
		when(opinionCuatroDouble.getOpinion()).thenReturn(OpinionImagen.CHINCHE_FOLIADA);
		
		// seteo de muestra
		muestraTest = new Muestra(ubicacionDouble, opinionDouble);
	}
	
	@Test
	public void unaMuestraSeIniciaComoNoVerificada() {
		// exercise
		IEstadoMuestra estadoDeMuestraInicial = muestraTest.getEstadoMuestra();
		// verify
		assertTrue(estadoDeMuestraInicial instanceof MuestraNoVerificada);
	}
	
	
	
	@Test
	public void laMuestraObtieneUnaOpinionDeUsuarioDado() {
		//exercise
		Opinion opinionBuscada = muestraTest.opinionDeUsuario(usuarioBasicoDouble);
		//verify
		assertEquals(opinionDouble, opinionBuscada);
	}
	
	@Test
	public void laMuestraTraeLasOpinionesDeExpertos() {
		//setUp
		muestraTest.agregarOpinion(opinionTresDouble);
		// exercise
		List<Opinion> opinionExpertos = muestraTest.opinionesExpertos();
		//verify
		assertEquals(1, opinionExpertos.size());
	}
	
	@Test
	public void siElusuarioYaVotoNoPuedeVolverAOpinar() {
		//setUp
		int cantOpiniones = muestraTest.getOpiniones().size();
		when(opinionDosDouble.getUsuario()).thenReturn(usuarioBasicoDouble);
		//exercise
		muestraTest.agregarOpinion(opinionDosDouble);
		//verify
		assertEquals(1, cantOpiniones);
		
	}
	
	@Test
	public void laMuestraActualizaLaOpinionActual() {
		//setUp
		OpinionImagen opinionOriginal = muestraTest.getTipoInsecto();
		muestraTest.agregarOpinion(opinionDosDouble);
		muestraTest.agregarOpinion(opinionTresDouble);
		// exercise
		muestraTest.actualizarOpinion();
		OpinionImagen opinionAcutalizada = muestraTest.getTipoInsecto();
		//verify
		assertEquals(OpinionImagen.IMAGEN_POCO_CLARA, opinionAcutalizada);
	} 
	
	@Test public void laMuestraSiTieneUnEmpateEnVotacionSuTipoInsectoNoEstaDefinido() {
		//setUp
		muestraTest.agregarOpinion(opinionDosDouble);
		//exercise
		muestraTest.actualizarOpinion();
		OpinionImagen opinionActualziada = muestraTest.getTipoInsecto();
		//verify
		assertEquals(OpinionImagen.NO_DEFINIDA, opinionActualziada);
	}
}
