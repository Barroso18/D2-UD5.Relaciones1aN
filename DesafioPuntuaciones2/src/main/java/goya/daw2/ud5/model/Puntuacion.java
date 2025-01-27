package goya.daw2.ud5.model;

import java.io.Serializable;
import java.sql.Date;

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
	
	@Column(name = "FECHA")
	private Date fecha;
	
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
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Puntuacion [idPuntuacion=" + idPuntuacion + ", fecha=" + fecha + ", cifra=" + cifra + ", usuario="
				+ usuario.getNombre() + "]";
	}
	
}