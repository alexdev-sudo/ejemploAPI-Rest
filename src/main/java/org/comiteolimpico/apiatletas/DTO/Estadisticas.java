package org.comiteolimpico.apiatletas.DTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.comiteolimpico.apiatletas.Model.Entrenamiento;

public class Estadisticas {
    private double promedio;
    private double mejormarca;
    private List<Entrenamiento> historial;
    private Map<String, Double> nacinal_intarnacional;

    // Getter Y Setters
    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    public double getMejormarca() {
        return mejormarca;
    }
    public void setMejormarca(double mejormarca) {
        this.mejormarca = mejormarca;
    }
    public List<Entrenamiento> getHistorial() {
        return historial;

    }
    public void setHistorial(List<Entrenamiento> historial) {
        this.historial = historial;
    }
    public Map<String, Double> getNacinal_intarnacional() {
        return nacinal_intarnacional;
    }
    public void setNacinal_intarnacional(Map<String, Double> nacinal_intarnacional) {
        this.nacinal_intarnacional = nacinal_intarnacional;
    }
}
