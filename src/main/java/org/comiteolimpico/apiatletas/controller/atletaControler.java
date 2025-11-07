package org.comiteolimpico.apiatletas.controller;
import org.comiteolimpico.apiatletas.Model.atleta;
import org.comiteolimpico.apiatletas.Service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/atletas")
public class atletaControler {
    @Autowired
    private AtletaService service;
    @GetMapping
    public List<atleta> listar(){
        return service.listar();
    }
@PostMapping
    public atleta agregar(@RequestBody atleta a){
        return service.guardar(a);

}
@DeleteMapping("/{id}" )
    public void eliminar(@PathVariable Long id){
        service.eliminar(id);
}
}
