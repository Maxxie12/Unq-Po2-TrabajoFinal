package ar.edu.unq.po2.BuscadorDeMuestras.Test;

import static org.junit.Assert.assertEquals;
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
import ar.edu.unq.po2.Muestra.IEstadoMuestra;
import ar.edu.unq.po2.Muestra.Muestra;
<<<<<<< HEAD
=======
import ar.edu.unq.po2.Muestra.MuestraVerificada;
import ar.edu.unq.po2.Muestra.OpinionImagen;
>>>>>>> branch 'main' of https://github.com/Maxxie12/Unq-Po2-TrabajoFinal.git

public class BuscadorNivelVerificacionTest {

	List<Muestra> muestrasAFiltrar = new ArrayList<Muestra>();
	BuscadorNivelVerificacion buscadorNivelVerificacion;  
	Boolean estadoMuestraABuscar;
	
	  @Mock
	  Muestra  muestra1 = mock(Muestra.class);
	  Muestra  muestra2 = mock(Muestra.class);
	  Muestra  muestra3 = mock(Muestra.class);
      Muestra  muestra4 = mock(Muestra.class);
      MuestraVerificada muestraVerificada =  mock(MuestraVerificada.class);
      
      IEstadoMuestra estadoMuestraVerificado;
      IEstadoMuestra estadoMuestraNoVerificado;
    
      
      
	
	 
		@BeforeEach
			void setUp() { 
<<<<<<< HEAD
			buscadorNivelVerificacion = new BuscadorNivelVerificacion();
			muestrasAFiltrar = new ArrayList<>();
	
			estadoMuestraVerificado = mock(IEstadoMuestra.class);
		    estadoMuestraNoVerificado = mock(IEstadoMuestra.class);
=======
			when(muestra1.getEstadoMuestra()).thenReturn(muestraVerificada);
		  	when(muestra2.getEstadoMuestra()).thenReturn(OpinionImagen.VINCHUCA_INFESTANS);
		  	when(muestra3.getEstadoMuestra()).thenReturn(OpinionImagen.CHINCHE_FOLIADA);
		  	when(muestra4.getEstadoMuestra()).thenReturn(OpinionImagen.VINCHUCA_SORDIDA);
>>>>>>> branch 'main' of https://github.com/Maxxie12/Unq-Po2-TrabajoFinal.git
		    
			when(muestra1.getEstadoMuestra()).thenReturn(estadoMuestraVerificado);
	        when(muestra2.getEstadoMuestra()).thenReturn(estadoMuestraNoVerificado);
	        when(muestra3.getEstadoMuestra()).thenReturn(estadoMuestraVerificado);
	        when(muestra4.getEstadoMuestra()).thenReturn(estadoMuestraVerificado);
	        
	        when(estadoMuestraVerificado.esVerificada()).thenReturn(true);
	        when(estadoMuestraNoVerificado.esVerificada()).thenReturn(false);
			
			muestrasAFiltrar.add(muestra1);
			muestrasAFiltrar.add(muestra2);
			muestrasAFiltrar.add(muestra3);
			muestrasAFiltrar.add(muestra4);
	    }
	   
	    @Test
<<<<<<< HEAD
	    public void testFiltrarMuestrasEstadoVerificado() {
		buscadorNivelVerificacion.setEstadoMuestraABuscar(true);
        List<Muestra> resultado = buscadorNivelVerificacion.filtrar(muestrasAFiltrar);
=======
	  public void testBuscadorTipoInsectoVinchuca(){   
	    	buscadorNivelVerificacion = new BuscadorNivelVerificacion();
	    	buscadorNivelVerificacion.setEstadoMuestraABuscar(muestraVerificada);
	    	List<Muestra> resultadoFiltrado = buscadorNivelVerificacion.filtrar(muestrasAFiltrar);
>>>>>>> branch 'main' of https://github.com/Maxxie12/Unq-Po2-TrabajoFinal.git

        // Assert
        assertEquals(3, resultado.size());

    }
	    
	    @Test
	    public void testMuestra1EsVerificada() {
		buscadorNivelVerificacion.setEstadoMuestraABuscar(true);
        List<Muestra> resultado = buscadorNivelVerificacion.filtrar(muestrasAFiltrar);
		assertTrue(resultado.contains(muestra1));
	    }
	    
	    @Test
	    public void testMuestra3EsNoVerificada() {
		buscadorNivelVerificacion.setEstadoMuestraABuscar(false);
        List<Muestra> resultado = buscadorNivelVerificacion.filtrar(muestrasAFiltrar);
		assertTrue(resultado.contains(muestra2));
	    }
	    
	    @Test
	    public void testMuestra3EsVerificada() {
		buscadorNivelVerificacion.setEstadoMuestraABuscar(false);
        List<Muestra> resultado = buscadorNivelVerificacion.filtrar(muestrasAFiltrar);
		assertFalse(resultado.contains(muestra1));
	    }
	    
	    
	    
	    
	
		 
		 

		
 }


