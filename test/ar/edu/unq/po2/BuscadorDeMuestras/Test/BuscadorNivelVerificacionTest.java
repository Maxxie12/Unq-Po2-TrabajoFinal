package ar.edu.unq.po2.BuscadorDeMuestras.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.po2.BuscadorDeMuestras.BuscadorNivelVerificacion;
import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.OpinionImagen;

public class BuscadorNivelVerificacionTest {

	List<Muestra> muestrasAFiltrar = new ArrayList<Muestra>();
	BuscadorNivelVerificacion buscadorNivelVerificacion;  
	
	  @Mock
	  Muestra  muestra1 = mock(Muestra.class);
	  Muestra  muestra2 = mock(Muestra.class);
	  Muestra  muestra3 = mock(Muestra.class);
      Muestra  muestra4 = mock(Muestra.class);
      
      
	
	 
		@BeforeEach
			void setUp() { 
			when(muestra1.getEstadoMuestra()).thenReturn(esVerificada());
		  	when(muestra2.getEstadoMuestra()).thenReturn(OpinionImagen.VINCHUCA_INFESTANS);
		  	when(muestra3.getEstadoMuestra()).thenReturn(OpinionImagen.CHINCHE_FOLIADA);
		  	when(muestra4.getEstadoMuestra()).thenReturn(OpinionImagen.VINCHUCA_SORDIDA);
		    
		
	        muestrasAFiltrar.add(muestra1);
			muestrasAFiltrar.add(muestra2);     
			muestrasAFiltrar.add(muestra3);
			muestrasAFiltrar.add(muestra4);
	    }
	   
	    @Test
	  public void testBuscadorTipoInsectoVinchuca(){   
	    	buscadorNivelVerificacion = new BuscadorNivelVerificacion();
	    	buscadorNivelVerificacion.setEstadoMuestraABuscar(IEstadoMuestra Verificada);
	    	List<Muestra> resultadoFiltrado = buscadorNivelVerificacion.filtrar(muestrasAFiltrar);

	    	    assertTrue(resultadoFiltrado.contains(muestra1));
	    	    assertTrue(resultadoFiltrado.contains(muestra2));
	    	    assertTrue(resultadoFiltrado.contains(muestra4));
	    	    assertFalse(resultadoFiltrado.contains(muestra3));
	    }

	    @Test
	   public void testBuscadorTipoInsectoCucaracha(){
	    	buscadorbuscadorNivelVerificacion = new BuscadorNivelVerificacion();
	    	buscadorNivelVerificacion.setInsectoABuscar("Cucaracha");
	    	List<Muestra> resultadoFiltrado = buscadorTipoInsecto.filtrar(muestrasAFiltrar);


	    	assertFalse(resultadoFiltrado.size()>0);
	    }
		 
		 

		
 }


