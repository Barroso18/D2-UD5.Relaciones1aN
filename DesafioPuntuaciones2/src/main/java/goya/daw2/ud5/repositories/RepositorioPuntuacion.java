package goya.daw2.ud5.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import goya.daw2.ud5.model.Puntuacion;
@Repository
public interface RepositorioPuntuacion extends CrudRepository<Puntuacion,Long>{

}
