package org.comiteolimpico.apiatletas.Service;

import org.comiteolimpico.apiatletas.Model.Entrenamiento;
import org.comiteolimpico.apiatletas.Model.Atleta;

public class GestorEstadistica {
    public double promedio(Atleta atleta1){
        return atleta1.getEntrenamientos()
                .stream().mapToDouble(Entrenamiento::getValor)
                .average().orElse(0) ;

    }

        public double mejormarca(Atleta atleta1){
        if (atleta1.getEntrenamientos()== null || atleta1.getEntrenamientos().isEmpty()){
        return 0;
        }
        double mejor = (atleta1.getEntrenamientos().get(0).getValor());
         String unidad = atleta1.getEntrenamientos().get(0).getUnidad().toLowerCase();

        for (Entrenamiento e : atleta1.getEntrenamientos()){
            String u = e.getUnidad().toLowerCase();
            if (u.equals("segundos")){// para tiempo menor es mejor
                if (e.getValor()< mejor){
                    mejor = e.getValor();
                    unidad = u ;
                }
            }else if (!u.equals("segundos")){// para las diciplinas donde marca es a mayor marca es mejor
               if (e.getValor() > mejor){
                   mejor = e.getValor();
                   unidad = u ;
               }
            }
        }
            return mejor;
    }


    public static void compararrendimiento(Atleta a) {
        String unidad = a.getEntrenamientos().get(0).getUnidad().toLowerCase();
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
        System.out.println("\n-- Comparacion de rendimiento de : " + a.getNombre() + " --");
        System.out.println("Promedio Nacional : " + promedionacional + " " + unidadatleta(a));
        System.out.println("Promedio Internacional : " + promedioextranjero + " " + unidadatleta(a));

        if (promedionacional > promedioextranjero) {
            System.out.println("➡ Mejor rendimiento en entrenamientos Nacionales");
        } else if (promedioextranjero > promedionacional) {
            System.out.println("➡ Mejor rendimiento en entrenamientos Internacionales");
        } else {
            System.out.println("➡ Rendimiento similar en entrenamientos Internacionales");
        }
    }

    private  static String unidadatleta(Atleta a){
        return a.getEntrenamientos().isEmpty()? "" :
                a.getEntrenamientos().get(0).getUnidad();
    }
}
