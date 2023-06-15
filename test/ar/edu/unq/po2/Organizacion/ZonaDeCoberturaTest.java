package ar.edu.unq.po2.Organizacion;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.Muestra.Muestra;

public class ZonaDeCoberturaTest {
	
    
	
	@Test
	public void zonasSolapadas_ZonasAComparar_DevuelveZonasSolapadasCorrectas() {
	    Ubicacion ubicacion1 = new Ubicacion(40.7128, -74.0060); // Nueva York
	    Ubicacion ubicacion2 = new Ubicacion(1.85371, -76.05071); // Colombia
	    Ubicacion ubicacion3 = new Ubicacion(55.47920, 37.32733); // Rusia

	    ZonaDeCobertura zona1 = new ZonaDeCobertura("Zona 1", ubicacion1, 10);
	    ZonaDeCobertura zona2 = new ZonaDeCobertura("Zona 6", ubicacion2, 5000);
	    ZonaDeCobertura zona3 = new ZonaDeCobertura("Zona 7", ubicacion3, 500);
	    
	    List<ZonaDeCobertura> zonasAComparar = new ArrayList<>();
	    zonasAComparar.add(zona2);
	    zonasAComparar.add(zona3);

	    List<ZonaDeCobertura> zonasSolapadas = zona1.zonasSolapadas(zonasAComparar);
	    //11278.040057575363
	    assertEquals(1, zonasSolapadas.size());
	    
	    zona2.setRadioEnKm(500);
	    List<ZonaDeCobertura> zonasSolapadas2 = zona1.zonasSolapadas(zonasAComparar);
	    assertEquals(0, zonasSolapadas2.size());
	}
   

    @Test
    public void agregarMuestra_NuevaMuestra_NotificaCargaDeMuestra() {
        Ubicacion epicentro = new Ubicacion(40.7128, -74.0060); // Nueva York
        ZonaDeCobertura zona = new ZonaDeCobertura("Zona 1", epicentro, 10);

        Muestra muestra = Mockito.mock(Muestra.class);

        ObserverZonaCobertura observer = Mockito.mock(ObserverZonaCobertura.class);
        zona.suscribirACarga(observer);

        zona.agregarMuestra(muestra);

        // Verificar que se llamó al método nuevaCargaMuestra del observer
        Mockito.verify(observer).nuevaCargaMuestra(zona, muestra);
        
        zona.desuscribirDeCarga(observer);
        assertEquals(0, zona.getSubscritosACarga().size());
    }

    @Test
    public void notificarValidacionDeMuestra_ZonaConSubscritos_NotificaValidacionDeMuestra() {
        Ubicacion epicentro = new Ubicacion(40.7128, -74.0060); // Nueva York
        ZonaDeCobertura zona = new ZonaDeCobertura("Zona 1", epicentro, 10);

        Muestra muestra = Mockito.mock(Muestra.class);

        ObserverZonaCobertura observer = Mockito.mock(ObserverZonaCobertura.class);
        zona.suscribirAValidacion(observer);

        zona.notificarValidacionDeMuestra( muestra);

        // Verificar que se llamó al método nuevaValidacionMuestra del observer
        Mockito.verify(observer).nuevaValidacionMuestra(zona, muestra);
        
        zona.desuscribirDeValidacion(observer);
        assertEquals(0, zona.getSubscritosACarga().size());
        
        
    }
    
    
    
}