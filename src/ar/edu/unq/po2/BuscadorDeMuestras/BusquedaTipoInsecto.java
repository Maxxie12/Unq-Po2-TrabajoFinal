package ar.edu.unq.po2.BuscadorDeMuestras;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.OpinionImagen;

public class BusquedaTipoInsecto implements IBuscadorMuestras{

	
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar, String tipoInsecto) {
		List<Muestra> resultado = new ArrayList<>();

        String patron = "\\b" + tipoInsecto + "\\b"; // Patrón de búsqueda para buscar el tipo de insecto exacto (ignorando mayúsculas y minúsculas)
        Pattern pattern = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);

        for (Muestra muestra : muestrasAFiltrar) {
            String insectoMuestra = muestra.getOpinionActual().name();
            Matcher matcher = pattern.matcher(insectoMuestra);
            if (matcher.find()) {
                resultado.add(muestra);
            }
        }

        return resultado;
	}


}
