package org.comiteolimpico.apiatletas.Repository;

import org.comiteolimpico.apiatletas.Model.Atleta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class atletaDAO {
    public void guardar(Atleta a){

        String sql = "INSERT INTO atletas (nombre, edad,departamento, disciplina,nacionalidad,fechaingreso) VALUES (?,?,?,?,?,?) ";
        try (Connection conn = conexionDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,a.getNombre());
            stmt.setInt(2,a.getEdad());
            stmt.setString(3,a.getDepartamento());
            stmt.setString(4,a.getDisciplina());
            stmt.setString(5,a.getNacionalidad());
            // convertimos fecha ingreso a java.sql.Date
            java.sql.Date fechasql = java.sql.Date.valueOf(
                    java.time.LocalDate.parse(a.getFechaIngreso(),
                            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            stmt.setDate(6,fechasql);
            stmt.executeUpdate();
            System.out.println("Registro guardado en PostgreSQL correctamente");

        }catch(SQLException e){
            System.out.println("Error al registrar atleta: "+e.getMessage());
        }
    }

}
