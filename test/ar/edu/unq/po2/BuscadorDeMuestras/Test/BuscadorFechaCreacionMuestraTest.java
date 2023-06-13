package ar.edu.unq.po2.BuscadorDeMuestras.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.BuscadorDeMuestras.BuscadorFechaCreacionMuestra;
import ar.edu.unq.po2.Muestra.Muestra;

public class BuscadorFechaCreacionMuestraTest {

		  private BuscadorFechaCreacionMuestra buscador;
		  private List<Muestra> muestrasAFiltrar;

		    @BeforeEach
		    public void setup() {
		        buscador = new BuscadorFechaCreacionMuestra();
		        muestrasAFiltrar = new ArrayList<>();
		    }

		    @Test
		    public void testFiltrar() {
		        
		        LocalDate fecha = LocalDate.of(2022, 1, 1);

		        Muestra muestra1 = Mockito.mock(Muestra.class);
		        when(muestra1.getFechaCreacion()).thenReturn(LocalDate.of(2021, 12, 31));

		        Muestra muestra2 = Mockito.mock(Muestra.class);
		        when(muestra2.getFechaCreacion()).thenReturn(LocalDate.of(2022, 2, 1));

		        Muestra muestra3 = Mockito.mock(Muestra.class);
		        when(muestra3.getFechaCreacion()).thenReturn(LocalDate.of(2022, 1, 2));

		        muestrasAFiltrar.add(muestra1);
		        muestrasAFiltrar.add(muestra2);
		        muestrasAFiltrar.add(muestra3);

		        buscador.setFecha(fecha);

		        
		        List<Muestra> resultado = buscador.filtrar(muestrasAFiltrar);

		        // Assert
		        assertEquals(2, resultado.size());
		        assertEquals(muestra2, resultado.get(0));
		        assertEquals(muestra3, resultado.get(1));
		    }
		}

