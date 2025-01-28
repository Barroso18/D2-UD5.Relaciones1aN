package goya.daw2.ud5.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PUNTUACION")
public class Puntuacion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PUNTUACION")
	private Long idPuntuacion;
	@Column(name = "FECHA")//@Column(name = "FECHA",nullable = true)
	private LocalDate fecha;
	@Column(name = "CIFRA")
	Integer cifra;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	public Puntuacion(Integer cifra) {
		super();
		this.cifra = cifra;
	}
	public Puntuacion(Integer cifra,LocalDate fecha) {
		super();
		this.cifra = cifra;
		this.fecha = fecha;
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
	public void setCifra(Integer cifra) {
		this.cifra = cifra;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Puntuacion [idPuntuacion=" + idPuntuacion + ", fecha=" + fecha + ", cifra=" + cifra + ", usuario="
				+ usuario.getNombre() + "]";
	}
	
}