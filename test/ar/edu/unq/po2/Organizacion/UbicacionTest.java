package ar.edu.unq.po2.Organizacion;




import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UbicacionTest {
		
	private  Ubicacion ubicacion1;
	private  Ubicacion ubicacion2;
	private  Ubicacion ubicacion3;
	private  Ubicacion ubicacion4;
	private  Ubicacion ubicacion5;
	private  Ubicacion ubicacion6;
	private  Ubicacion ubicacion7;
	
	 @BeforeEach
	    public void setUp() {
		 ubicacion1 = new Ubicacion(40.7128, -74.0060); // Nueva York
		 ubicacion2 = new Ubicacion(34.0522, -118.2437); // Los Ángeles
		 ubicacion3 = new Ubicacion(51.5074, -0.1278); // Londres
		 ubicacion4 = new Ubicacion(35.6895, 139.6917); // Tokio
		 ubicacion5 = new Ubicacion(-33.8675, 151.2070); // Sídney
		 ubicacion6 = new Ubicacion(1.85371, -76.05071); // Colombia
		 ubicacion7 = new Ubicacion(55.47920, 37.32733); // Rusia
		 
	    }

	
	
    @Test
    public void distanciaEntre() {
        

        double distancia = ubicacion6.distanciaEntre(ubicacion7);

        
        assertEquals(11278.040057575363, distancia);
        
    }

    @Test
    public void seEncuentranAMenosDeKM_UbicacionesCercanas() {

        List<Ubicacion> ubicaciones = new ArrayList<>();
        ubicaciones.add(ubicacion2);
        ubicaciones.add(ubicacion3);
        ubicaciones.add(ubicacion4);
        ubicaciones.add(ubicacion5);

        int kilometros = 10000; //  km

        List<Ubicacion> ubicacionesCercanas = ubicacion1.seEncuentranAMenosDeKM(ubicaciones, kilometros);

        // Comprobar que las ubicaciones 2 (Los Ángeles) y 3 (Londres) están a menos de 10000 km de distancia
        assertEquals(2, ubicacionesCercanas.size());
        assertTrue(ubicacionesCercanas.contains(ubicacion2));
        assertTrue(ubicacionesCercanas.contains(ubicacion3));
        assertFalse(ubicacionesCercanas.contains(ubicacion4));
        assertFalse(ubicacionesCercanas.contains(ubicacion5));
    }

    @Test
    public void seEncuentranAMenosDeKM_NingunaUbicacionCercana() {

        List<Ubicacion> ubicaciones = new ArrayList<>();
        ubicaciones.add(ubicacion2);
        ubicaciones.add(ubicacion3);

        int kilometros = 100; //  km

        List<Ubicacion> ubicacionesCercanas = ubicacion1.seEncuentranAMenosDeKM(ubicaciones, kilometros);

        // Comprobar que no hay ubicaciones a menos de 100 km de distancia
        Assert.assertEquals(0, ubicacionesCercanas.size());
    }
}
