package org.comiteolimpico.apiatletas.Service;
import org.comiteolimpico.apiatletas.Repository.AtletaRepository;
import org.comiteolimpico.apiatletas.Model.atleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service


public class AtletaService {
    @Autowired
    private AtletaRepository repo;

    public List<atleta> listar(){
        return repo.findAll();
    }
    public atleta guardar(atleta a){
        return repo.save(a);
    }
    public void eliminar(Long id){
        repo.deleteById(id);
    }
}

