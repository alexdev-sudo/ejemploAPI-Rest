    package org.comiteolimpico.apiatletas.Service;

    import org.comiteolimpico.apiatletas.Model.Atleta;

    public class Gestor_planilla {

        public static final double bonoextranjero = 1000;
        public static final double marcasuperada = 500;
        public static final double pagoentreno = 22.5;


        public void  pago_mensual(Atleta a){
            int count_entrenamientos = a.getcantidadentrenamientos();
            double pago;
            if (count_entrenamientos==0){
                System.out.println("el atleta " + a.getNombre() +" no tiene entrenamientos");
                return;
            }
         // revisamos si alguno de los entrenamientos es internacional
            boolean tieneinternacional = a.getEntrenamientos().stream().anyMatch(
                    e ->"Internacional".equalsIgnoreCase(e.getUbicacion()));
            if (tieneinternacional){
                pago = ((pagoentreno * count_entrenamientos )+ bonoextranjero);
                System.out.println("-- Descripción salarial --\n" +
                        "Atleta: " + a.getNombre() + "\n" +
                        "Entrenamientos: " + count_entrenamientos + "\n" +
                        "Bono por entrenamientos en el extranjero: " + bonoextranjero + "\n" +
                        "Pago total: " + pago);
            }else{
                pago = pagoentreno * count_entrenamientos;
                System.out.println("-- Descripción salarial --\n" +
                        "Atleta: " + a.getNombre() + "\n" +
                        "Entrenamientos: " + count_entrenamientos + "\n" +
                        "Bono por entrenamientos en el extranjero: no existen entrenamientos extranjeros" +
                        "Pago total: " + pago);
            }
        }
    }

