package org.comiteolimpico.apiatletas.Service;
import org.comiteolimpico.apiatletas.Model.Atleta;
import org.comiteolimpico.apiatletas.Model.Entrenamiento;
import org.comiteolimpico.apiatletas.DTO.Estadisticas;
import org.comiteolimpico.apiatletas.DTO.Planilla;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class Serviciounificado {
    private final   GestorEstadistica gestorEstadistica = new GestorEstadistica();
    private  final Gestor_planilla  gestor_planilla = new Gestor_planilla();

    public Estadisticas getEstadisticas(Atleta atleta) {
        Estadisticas dto = new Estadisticas();
        dto.setPromedio(gestorEstadistica.promedio(atleta));
        dto.setMejormarca(gestorEstadistica.mejormarca(atleta));
        dto.setHistorial(atleta.gethistorialordenado());
        Map<String, Double> comparacion = new HashMap<>();
        double promedioNacional = atleta.getEntrenamientos().stream()
                .filter(e -> "Nacional".equalsIgnoreCase(e.getUbicacion()))
                .mapToDouble(Entrenamiento::getValor).average().orElse(0.0);
        double promedioInternacional = atleta.getEntrenamientos().stream()
                .filter(e -> !"Nacional".equalsIgnoreCase(e.getUbicacion()))
                .mapToDouble(Entrenamiento::getValor).average().orElse(0.0);
        comparacion.put("Nacional", promedioNacional);
        comparacion.put("Internacional", promedioInternacional);
        dto.setNacinal_intarnacional(comparacion);
        return dto;
    }
    public Planilla calcularplanilla(Atleta atleta) {
        Planilla dto = new Planilla();
        int count = atleta.getcantidadentrenamientos();
        dto.setNombreatleta(atleta.getNombre());
        dto.setTotalentreno(count);
        double pago = count * Gestor_planilla.pagoentreno;
        double bonoextranjero = atleta.getEntrenamientos().stream()
                .anyMatch(e -> "Internacional".equalsIgnoreCase(e.getUbicacion()))
                ? Gestor_planilla.bonoextranjero : 0;
        double bonoMarca = 500;
        dto.setBonoextranjero(bonoextranjero);
        dto.setBonoMarca(bonoMarca);
        dto.setPagoTotal(bonoMarca + bonoextranjero + pago);
        return dto;
    }
}
