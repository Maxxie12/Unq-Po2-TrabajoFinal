package ar.edu.unq.po2.TrabajoFinal;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.MuestraVerificada;
import ar.edu.unq.po2.Muestra.Opinion;
import java.util.ArrayList;

public class ClasificadorDeMuestrasTest {
	List<Opinion> opinionesExpertos;
	List<Opinion> opinionesExpertos1;
	List<Muestra> muestras;
	@Mock
	Sistema sistemaDouble = mock(Sistema.class);
	Muestra muestraDouble = mock(Muestra.class);
	Muestra muestraDouble1 = mock(Muestra.class);
	Muestra muestraDouble2 = mock(Muestra.class);
	Opinion opinionDouble = mock(Opinion.class);
	
	@Test
	public void ClasificaMuestrasQueTienenAlMenos2ComentariosDeExpertos() {
		//setup
		ClasificadorDeMuestras clasificadorMuestrasTest = new ClasificadorDeMuestras(sistemaDouble);
			//setea listas
				//lista opinion
		opinionesExpertos = new ArrayList<Opinion>();
		opinionesExpertos.add(opinionDouble);
		opinionesExpertos.add(opinionDouble);
		opinionesExpertos1 = new ArrayList<Opinion>();
				//lista muestras
		muestras = new ArrayList <Muestra>();
		muestras.add(muestraDouble);
		muestras.add(muestraDouble1);
			// comportamiento a doubles
		when(muestraDouble.esVerificada()).thenReturn(false);
		when(muestraDouble1.esVerificada()).thenReturn(false);
		when(muestraDouble2.esVerificada()).thenReturn(false);
		when(muestraDouble.opinionesExpertos()).thenReturn(opinionesExpertos);
		when(muestraDouble1.opinionesExpertos()).thenReturn(opinionesExpertos1);
			// comportamiento a sistema
		when(sistemaDouble.getMuestras()).thenReturn((ArrayList<Muestra>) muestras);
		ArgumentCaptor<MuestraVerificada> estadoMuestraCapturada = ArgumentCaptor.forClass(MuestraVerificada.class);
		// exercise
		clasificadorMuestrasTest.clasificarMuestras();
		//verify
		Mockito.verify(muestraDouble).cambiarEstado(estadoMuestraCapturada.capture());
		Mockito.verify(muestraDouble1, never()).cambiarEstado(null);
	}
}
