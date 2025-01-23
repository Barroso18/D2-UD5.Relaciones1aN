package goya.daw2.ud5.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import goya.daw2.ud5.repositories.RepositorioUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;
	String nombre;
	
	@OneToMany(
			mappedBy = "usuario",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Puntuacion> puntuaciones = new HashSet<Puntuacion>();
	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Usuario() {
		
	}
	public Usuario devuelveUsuario(RepositorioUsuario repo, String nombre) {
		return repo.findByNombre(nombre).get(0);
	}
	public boolean anadirPuntuacion(Puntuacion puntuacion) {
		puntuacion.setUsuario(this);
		return getPuntuaciones().add(puntuacion);
	}
	public void eliminarPuntuacion(Puntuacion puntuacion) {
		getPuntuaciones().remove(puntuacion);
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Puntuacion> getPuntuaciones() {
		return puntuaciones;
	}
	public void setPuntuaciones(Set<Puntuacion> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", puntuaciones=" + puntuaciones + "]";
	}
}


	
	
	
	