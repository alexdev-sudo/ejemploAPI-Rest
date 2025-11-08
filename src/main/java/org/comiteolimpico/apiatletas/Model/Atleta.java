package org.comiteolimpico.apiatletas.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "atletas")
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String nombre;
private int edad;
private String departamento;
private String disciplina;
private String nacionalidad;
private String Fechaingreso;


@OneToMany(mappedBy = "atleta",cascade = CascadeType.ALL,orphanRemoval = true)
private List<Entrenamiento> entrenamientos = new ArrayList<>();

// constructores -----------------
    public Atleta() {}
    public Atleta(String nombre, int edad, String departamento, String disciplina,
                  String nacionalidad, String Fechaingreso) {
    this.nombre = nombre;
    this.edad = edad;
    this.departamento = departamento;
    this.disciplina = disciplina;
    this.nacionalidad = nacionalidad;
    this.Fechaingreso = Fechaingreso;

}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getFechaIngreso() { return Fechaingreso; }
    public void setFechaIngreso(String fechaIngreso) { this.Fechaingreso = fechaIngreso; }

    public List<Entrenamiento> getEntrenamientos() { return entrenamientos; }
    public void setEntrenamientos(List<Entrenamiento> entrenamientos) { this.entrenamientos = entrenamientos; }


        public List<Entrenamiento> gethistorialordenado() {
            // se verifica el nombre completo, si no hay registro en entrenamientos devuelve el string
            if (entrenamientos == null || entrenamientos.isEmpty()) {
                return List.of();
            }
            // se ordena la lista entrenamientos por fecha para cumplir con el requisito
            // orden de redimiento por fecha
            return entrenamientos.stream()
                    .sorted(Comparator.comparing(Entrenamiento::getFecha))
                    .toList();
        }

    // se verifica el nombre completo, si no hay registro en entrenamientos devuelve el string
    public List<Entrenamiento> mostrarInternacionall() {
        if (entrenamientos == null || entrenamientos.isEmpty()) {
            return List.of();
        }
        return entrenamientos.stream()
                .filter(e -> "Nacinal".equalsIgnoreCase(e.getUbicacion()))
                .sorted(Comparator.comparing(Entrenamiento::getFecha)).toList();
    }

    public List<Entrenamiento> MostrarNacional(){
        if (entrenamientos == null || entrenamientos.isEmpty()) {
            return List.of();
        }
        return entrenamientos.stream()
                .filter(e -> "Nacinal".equalsIgnoreCase(e.getUbicacion()))
                .sorted(Comparator.comparing(Entrenamiento::getFecha)).toList();

        }

    // Convierte una cadena de texto (ddMMyyyy) a formato dd/MM/yyyy.


        public static String convertirfecha(String input){
        LocalDate fechavalida = LocalDate.parse(input,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return fechavalida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        public int getcantidadentrenamientos(){
        return entrenamientos == null ? 0 : entrenamientos.size();
        }
        public void agregarentrenamiento(Entrenamiento e) {
        entrenamientos.add(e);
        e.setAtleta(this);
        }
}
