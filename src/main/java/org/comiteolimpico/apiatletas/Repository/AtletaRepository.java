package org.comiteolimpico.apiatletas.Repository;
import org.comiteolimpico.apiatletas.Model.atleta;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AtletaRepository extends JpaRepository<atleta, Long> {

}
