package ar.edu.unq.po2.BuscadorDeMuestras.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import ar.edu.unq.po2.BuscadorDeMuestras.BuscadorTipoInsecto;
import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.OpinionImagen;

public class BuscadorTipoIntectoTest {
	
	List<Muestra> muestrasAFiltrar = new ArrayList<Muestra>();
	BuscadorTipoInsecto buscadorTipoInsecto;  
	
	
		@Mock
		  Muestra  muestra1 = mock(Muestra.class);
		  Muestra  muestra2 = mock(Muestra.class);
		  Muestra  muestra3 = mock(Muestra.class);
	      Muestra  muestra4 = mock(Muestra.class);
	
	 
		@BeforeEach
	    void setUp() { 
			when(muestra1.getTipoInsecto()).thenReturn(OpinionImagen.VINCHUCA_GUASAYANA);
		  	when(muestra2.getTipoInsecto()).thenReturn(OpinionImagen.VINCHUCA_INFESTANS);
		  	when(muestra3.getTipoInsecto()).thenReturn(OpinionImagen.CHINCHE_FOLIADA);
		  	when(muestra4.getTipoInsecto()).thenReturn(OpinionImagen.VINCHUCA_SORDIDA);
		    
		
	        muestrasAFiltrar.add(muestra1);
			muestrasAFiltrar.add(muestra2);     
			muestrasAFiltrar.add(muestra3);
			muestrasAFiltrar.add(muestra4);
			
			buscadorTipoInsecto = new BuscadorTipoInsecto();
	    }
	   
	    @Test
	    void testBuscadorTipoBichoVinchuca(){   
	    	
	    	buscadorTipoInsecto.setInsectoABuscar("Vinchuca");
	    	
	    	assertTrue(buscadorTipoInsecto.filtrar(muestrasAFiltrar).contains(muestra2));
	    	assertTrue(buscadorTipoInsecto.filtrar(muestrasAFiltrar).contains(muestra1));
	    	assertFalse(buscadorTipoInsecto.filtrar(muestrasAFiltrar).contains(muestra3));
	    	assertTrue(buscadorTipoInsecto.filtrar(muestrasAFiltrar).contains(muestra4));
	    }

	    @Test
	    void testBuscadorTipoBichoCucaracha(){
	    	buscadorTipoInsecto.setInsectoABuscar("Cucaracha");

	    	assertFalse(buscadorTipoInsecto.filtrar(muestrasAFiltrar).size()>0);
	    }
		 
		 

		
		
	 }

}
