package org.comiteolimpico.apiatletas.Repository;
import org.comiteolimpico.apiatletas.Model.Entrenamiento;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EntrenamientosRepository extends JpaRepository<Entrenamiento,Long> {

}
