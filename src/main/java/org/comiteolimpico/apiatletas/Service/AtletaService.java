package org.comiteolimpico.apiatletas.Service;
import org.comiteolimpico.apiatletas.Model.Atleta;
import org.comiteolimpico.apiatletas.Model.Entrenamiento;
import org.comiteolimpico.apiatletas.Repository.AtletaRepository;
import org.comiteolimpico.apiatletas.Repository.EntrenamientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;
import java.io.File;
import java.util.Optional;


@Service

public class AtletaService {

    @Value("${respaldo.json.ruta:src/main/java/org/comiteolimpico/apiatletas/Respaldo/atletas.json}")
    private String rutaRespaldoJson;

    @Autowired
    private final AtletaRepository repo;
    @Autowired
    private EntrenamientosRepository entrenamientoRepository;

    public AtletaService(AtletaRepository repo) {
        this.repo = repo;
    }

    public List<Atleta> listar() {
        return repo.findAll();
    }

    public Atleta guardar(Atleta a) {
        return repo.save(a);
    }

    public void eliminar(long id) {
        repo.deleteById(id);
    }

    // EXPORTAR A JSON
    public String exportarJSON() {
        List<Atleta> atletas = repo.findAll();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File(rutaRespaldoJson), atletas);
            return "Respaldo Json Exportado correctamente a " + rutaRespaldoJson;
        } catch (IOException e) {
            e.printStackTrace();
            return "error al exportar JSON" + e.getMessage();
        }


    }

    // 🔹 nuevo repo

    public Entrenamiento agregarEntrenamiento(Long idAtleta, Entrenamiento entrenamiento) {
        Optional<Atleta> optAtleta = repo.findById(idAtleta);

        if (optAtleta.isPresent()) {
            Atleta atleta = optAtleta.get();

            // Enlaza el entrenamiento con el atleta
            entrenamiento.setAtleta(atleta);

            // Guarda el entrenamiento directamente
            Entrenamiento guardado = entrenamientoRepository.save(entrenamiento);

            // También lo agregamos a la lista del atleta (sin afectar persistencia)
            atleta.getEntrenamientos().add(guardado);

            return guardado;
        } else {
            throw new RuntimeException("Atleta no encontrado con ID: " + idAtleta);
        }
    }
}


