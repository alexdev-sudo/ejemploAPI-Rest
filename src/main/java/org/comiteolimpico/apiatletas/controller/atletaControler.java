package org.comiteolimpico.apiatletas.controller;
import org.comiteolimpico.apiatletas.DTO.Estadisticas;
import org.comiteolimpico.apiatletas.DTO.Planilla;
import org.comiteolimpico.apiatletas.Model.Atleta;
import org.comiteolimpico.apiatletas.Model.Entrenamiento;
import org.comiteolimpico.apiatletas.Service.AtletaService;
import org.comiteolimpico.apiatletas.Service.Serviciounificado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/atletas")
public class atletaControler {

    private final AtletaService service;
    private final Serviciounificado serviciounificado;


    public atletaControler(AtletaService service, Serviciounificado serviciounificado) {
        this.service = service;
        this.serviciounificado = serviciounificado;
    }

 @GetMapping
   public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.listar());
 }
@PostMapping
    public ResponseEntity<?> agregar(@RequestBody Atleta atleta){
        return ResponseEntity.ok(service.guardar(atleta));
}
@DeleteMapping("/{id}/estadisticas")
    public  ResponseEntity<?> eliminar(@PathVariable Long id){
        service.eliminar(id);
   return ResponseEntity.ok().build();
}
@GetMapping("/{id}/estadisticas")
public ResponseEntity<?> estadisticas(@PathVariable Long id){
 Atleta atleta = service.listar().stream()
         .filter( a -> a.getId().equals(id)).findFirst().orElse(null);
 if(atleta == null)
     return ResponseEntity.notFound().build();
     Estadisticas dto = serviciounificado.getEstadisticas(atleta);
     return ResponseEntity.ok(dto);
 }
 @GetMapping("/{id}/planilla")
  public ResponseEntity<?> planilla(@PathVariable Long id){
     Atleta atleta = service.listar().stream()
             .filter(a -> a.getId().equals(id)).findFirst().orElse(null);
     if(atleta == null) return ResponseEntity.notFound().build();
        Planilla dto = serviciounificado.calcularplanilla(atleta);
        return ResponseEntity.ok(dto);

    }


    @GetMapping("/exportar/planilla")
    public ResponseEntity<?> exportarPlanilla() {
        try {
            serviciounificado.exportarPlanillaCSV("planilla.csv");
            return ResponseEntity.ok("Planilla exportada correctamente");
        } catch (IOException e){
            return ResponseEntity.status(500).body("Error exportando CSV: " + e.getMessage());
        }
    }

    @GetMapping("/exportar/entrenamientos")
    public ResponseEntity<?> exportarEntrenamientos() {
        try {
            serviciounificado.exportarEntrenamientosCSV("entrenamientos.csv");
            return ResponseEntity.ok("Entrenamientos exportados correctamente");
        } catch (IOException e){
            return ResponseEntity.status(500).body("Error exportando CSV: " + e.getMessage());
        }
    }
    @GetMapping("/exportar/json")
    public ResponseEntity<String> exportarJson() {
        String mensaje = service.exportarJSON();
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/{id}/entrenamientos")
    public ResponseEntity<Entrenamiento> agregarEntrenamiento(
            @PathVariable Long id,
            @RequestBody Entrenamiento nuevoEntrenamiento) {

        Entrenamiento entrenamiento = service.agregarEntrenamiento(id, nuevoEntrenamiento);
        return ResponseEntity.ok(entrenamiento);
    }


    }


