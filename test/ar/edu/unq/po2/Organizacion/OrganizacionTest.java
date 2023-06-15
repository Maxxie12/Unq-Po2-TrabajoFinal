package ar.edu.unq.po2.Organizacion;





import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Muestra.Muestra;

public class OrganizacionTest {

    private Organizacion organizacion;
    private Ubicacion ubicacion;
    private TipoDeOrganizacion tipo;
    private int cantidadPersonas;
    private FuncionalidadExterna cargaMuestra;
    private FuncionalidadExterna validacionMuestra;

    @BeforeEach
    public void setUp() {
        ubicacion = mock(Ubicacion.class);
        tipo = mock(TipoDeOrganizacion.class);
        cantidadPersonas = 10;
        cargaMuestra = mock(FuncionalidadExterna.class);
        validacionMuestra = mock(FuncionalidadExterna.class);

        organizacion = new Organizacion(ubicacion, tipo, cantidadPersonas, cargaMuestra, validacionMuestra);
    }

    @Test
    public void setUbicacion_ShouldUpdateUbicacion() {
        Ubicacion nuevaUbicacion = mock(Ubicacion.class);

        organizacion.setUbicacion(nuevaUbicacion);

        assertEquals(nuevaUbicacion, organizacion.getUbicacion());
    }

    @Test
    public void setTipo_ShouldUpdateTipo() {
        TipoDeOrganizacion nuevoTipo = mock(TipoDeOrganizacion.class);

        organizacion.setTipo(nuevoTipo);

        assertEquals(nuevoTipo, organizacion.getTipo());
    }

    @Test
    public void setCantidadPersonas_ShouldUpdateCantidadPersonas() {
        int nuevaCantidad = 20;

        organizacion.setCantidadPersonas(nuevaCantidad);

        assertEquals(nuevaCantidad, organizacion.getCantidadPersonas());
    }

    @Test
    public void setCargaMuestra_ShouldUpdateCargaMuestra() {
        FuncionalidadExterna nuevaCarga = mock(FuncionalidadExterna.class);

        organizacion.setCargaMuestra(nuevaCarga);

        assertEquals(nuevaCarga, organizacion.getCargaMuestra());
    }

    @Test
    public void setValidacionMuestra_ShouldUpdateValidacionMuestra() {
        FuncionalidadExterna nuevaValidacion = mock(FuncionalidadExterna.class);

        organizacion.setValidacionMuestra(nuevaValidacion);

        assertEquals(nuevaValidacion, organizacion.getValidacionMuestra());
    }

    @Test
    public void nuevaCargaMuestra_ShouldInvokeCargaMuestra() {
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        Muestra muestra = mock(Muestra.class);

        organizacion.nuevaCargaMuestra(zona, muestra);

        verify(cargaMuestra).nuevoEvento(organizacion, zona, muestra);
    }

    @Test
    public void nuevaValidacionMuestra_ShouldInvokeValidacionMuestra() {
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        Muestra muestra = mock(Muestra.class);

        organizacion.nuevaValidacionMuestra(zona, muestra);

        verify(validacionMuestra).nuevoEvento(organizacion, zona, muestra);
    }
    
    
    @Test
    public void suscribirseAValidacionMuestraZona_ShouldSubscribeToValidation() {
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);

        organizacion.suscribirseAValidacionMuestraZona(zona);

        verify(zona).suscribirAValidacion(organizacion);
    }

    @Test
    public void suscribirseACargaMuestraZona_ShouldSubscribeToLoad() {
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);

        organizacion.suscribirseACargaMuestraZona(zona);

        verify(zona).suscribirACarga(organizacion);
    }

    @Test
    public void desuscribirseDeValidacionMuestraZona_ShouldUnsubscribeFromValidation() {
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);

        organizacion.desuscribirseDeValidacionMuestraZona(zona);

        verify(zona).desuscribirDeValidacion(organizacion);
    }

    @Test
    public void desuscribirseDeCargaMuestraZona_ShouldUnsubscribeFromLoad() {
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);

        organizacion.desuscribirseDeCargaMuestraZona(zona);

        verify(zona).desuscribirDeCarga(organizacion);
    }
}
