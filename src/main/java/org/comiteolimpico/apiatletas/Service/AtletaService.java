package org.comiteolimpico.apiatletas.Service;
import org.comiteolimpico.apiatletas.Model.Atleta;
import org.comiteolimpico.apiatletas.Repository.AtletaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class AtletaService {
private final AtletaRepository repo;

public AtletaService(AtletaRepository repo) {
    this.repo = repo;
}
public List<Atleta> listar(){
    return repo.findAll();
}
public Atleta guardar(Atleta a ){
    return repo.save(a);
}
public void eliminar(long id){
    repo.deleteById(id);
}

}
