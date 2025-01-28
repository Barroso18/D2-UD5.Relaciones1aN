package goya.daw2.ud5.repositories;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import goya.daw2.ud5.model.Puntuacion;
import goya.daw2.ud5.model.Usuario;

@Repository
public interface RepositorioPuntuacion extends CrudRepository<Puntuacion,Long>{
	List<Puntuacion> findByUsuario(Usuario usuario);
	public default List<Puntuacion> buscaTodasPuntuaciones(){
		List<Puntuacion> allPuntuaciones = new ArrayList<>();
		Iterable<Puntuacion> puntuaciones = this.findAll();
		for(Puntuacion puntuacion : puntuaciones) {
			allPuntuaciones.add(puntuacion);
		}
		return allPuntuaciones;
	}
	 //List<Puntuacion> findByCifraOrderByDesc();
		
	
}
