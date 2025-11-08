package org.comiteolimpico.apiatletas.Model;

public class comparacion {
    public static void compararrendimiento(Atleta a) {
        if (a.getEntrenamientos() == null || a.getEntrenamientos().isEmpty()) {
            System.out.println("el atleta" + a.getNombre() + "No tiene entrenamientos");
            return;
        }
        // filtramos por ubicacion
        double promedionacional = a.getEntrenamientos().stream().filter(e ->
                        "Nacional".equalsIgnoreCase(e.getUbicacion())).mapToDouble(Entrenamiento::getValor)
                .average().orElse(0);

        double promedioextranjero = a.getEntrenamientos().stream().filter(e ->
                        !"Nacional".equalsIgnoreCase(e.getUbicacion())).mapToDouble(Entrenamiento::getValor)
                .average().orElse(0);

        System.out.println("\n-- Comparacion de rendimiento de " + a.getNombre() + "--");

    }

    }

