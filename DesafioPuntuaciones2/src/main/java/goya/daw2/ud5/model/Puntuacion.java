package goya.daw2.ud5.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PUNTUACION")
public class Puntuacion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PUNTUACION")
	private Long idPuntuacion;
	
	int cifra;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	public Puntuacion(int cifra) {
		super();
		this.cifra = cifra;
	}
	public Puntuacion() {
		
	}
	public Long getIdPuntuacion() {
		return idPuntuacion;
	}
	public void setIdPuntuacion(Long idPuntuacion) {
		this.idPuntuacion = idPuntuacion;
	}
	public int getCifra() {
		return cifra;
	}
	public void setCifra(int cifra) {
		this.cifra = cifra;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Puntuacion [idPuntuacion=" + idPuntuacion + ", cifra=" + cifra + ", usuario=" + usuario.getNombre() + "]";
	}
	
}