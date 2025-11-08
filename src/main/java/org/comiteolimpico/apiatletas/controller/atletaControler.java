package org.comiteolimpico.apiatletas.controller;
import org.comiteolimpico.apiatletas.DTO.Estadisticas;
import org.comiteolimpico.apiatletas.DTO.Planilla;
import org.comiteolimpico.apiatletas.Model.Atleta;
import org.comiteolimpico.apiatletas.Service.AtletaService;
import org.comiteolimpico.apiatletas.Service.Serviciounificado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
 if(atleta == null){
     return ResponseEntity.notFound().build();
     Estadisticas dto = serviciounificado.getEstadisticas(atleta);
     return ResponseEntity.ok(dto);
 }
 @GetMapping("/{id}/planilla")
  public ResponseEntity<?> planilla(@PathVariable Long id){
     Atleta atleta = service.listar().stream()
             .filter(a -> a.getId().equals(id)).findFirst().orElse(null);
     if(atleta == null) return ResponseEntity.notFound().build();
        Planilla dto = serviciounificado

    }

}

}
