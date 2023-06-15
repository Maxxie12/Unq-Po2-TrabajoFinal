package ar.edu.unq.po2.TrabajoFinal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.po2.Common.Sistema;
import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Organizacion.Organizacion;
import ar.edu.unq.po2.Organizacion.ZonaDeCobertura;
import ar.edu.unq.po2.Usuario.Usuario;

public class SistemaTest {
	Sistema sistema = new Sistema();
	@Mock
	Muestra muestraDouble = mock(Muestra.class);
	Muestra muestraDouble1 = mock(Muestra.class);
	Muestra muestraDouble2 = mock(Muestra.class);
	Usuario usuarioDouble = mock(Usuario.class);
	Usuario usuarioDouble1 = mock(Usuario.class);
	Usuario usuarioDouble2 = mock(Usuario.class);
	ZonaDeCobertura ZonaCoberturaDouble = mock(ZonaDeCobertura.class);
	ZonaDeCobertura ZonaCoberturaDouble1 = mock(ZonaDeCobertura.class);
	ZonaDeCobertura ZonaCoberturaDouble2 = mock(ZonaDeCobertura.class);
	Organizacion organizacionDouble = mock(Organizacion.class);
	Organizacion organizacionDouble1 = mock(Organizacion.class);
	Organizacion organizacionDouble2 = mock(Organizacion.class);
	
	@Test
	public void seAgreganMuestras() {
		sistema.agregarMuestra(muestraDouble);
		sistema.agregarMuestra(muestraDouble1);
		sistema.agregarMuestra(muestraDouble2);
		int cantMuestras = sistema.getMuestras().size();
		assertEquals(3, cantMuestras);
	}
	
	@Test
	public void seAgreganUsuarios() {
		sistema.getUsuarios().add(usuarioDouble);
		sistema.getUsuarios().add(usuarioDouble1);
		sistema.getUsuarios().add(usuarioDouble2);
		int cantUsuarios = sistema.getUsuarios().size();
		assertEquals(3, cantUsuarios);
	}
	
	@Test
	public void seAgreganZonasDeCobertura() {
		sistema.getZonasDeCobertura().add(ZonaCoberturaDouble);
		sistema.getZonasDeCobertura().add(ZonaCoberturaDouble1);
		sistema.getZonasDeCobertura().add(ZonaCoberturaDouble2);
		int cantZonasCobertura = sistema.getZonasDeCobertura().size();
		assertEquals(3, cantZonasCobertura);
	}
	
	@Test
	public void seAgreganOrganizaciones() {
		sistema.getOrganizaciones().add(organizacionDouble);
		sistema.getOrganizaciones().add(organizacionDouble1);
		sistema.getOrganizaciones().add(organizacionDouble2);
		int cantOrganizaciones = sistema.getOrganizaciones().size();
		assertEquals(3, cantOrganizaciones);
	}
	
}
