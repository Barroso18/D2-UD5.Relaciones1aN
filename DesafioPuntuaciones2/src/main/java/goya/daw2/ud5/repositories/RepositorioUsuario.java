package goya.daw2.ud5.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goya.daw2.ud5.model.Usuario;
@Repository
@Service
public interface RepositorioUsuario extends CrudRepository<Usuario,Long>{
	List<Usuario> findByNombre(String nombre);
//	@Override
	/*@Transactional(readOnly = true)
	public default List<Usuario> findAll(){
		return (List<Usuario>)this.findAll();
	}*/
	public default List<Usuario> buscaTodosUsuarios(){
		List<Usuario> allUsuarios = new ArrayList<>();
		Iterable<Usuario> usuarios = this.findAll();
		for(Usuario usuario : usuarios) {
			allUsuarios.add(usuario);
		}
		return allUsuarios;
	}
}
