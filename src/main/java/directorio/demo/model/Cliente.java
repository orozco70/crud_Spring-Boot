package directorio.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Id;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	@NotEmpty(message="El nombre del Cliente es obligatorio")
	@Size(min = 3, max = 8, message="El nombre del Cliente tiene que tener entre 3 y 15 caracteres")
	private String nombre;
	@NotEmpty(message="El  Apellido es obligatorio")
	private String apellido;
	@NotEmpty(message="El  DNI es obligatorio")
	private String dni;
	@NotEmpty(message="El # TELEFONO es obligatorio")
	private String telefono;
	@NotEmpty(message="La DIRECCIN DE CORREO es obligatorio")
	private String email;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente(Long idCliente, String nombre, String apellido, String dni, String telefono, String email) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
	}

	public Cliente() {

	}

}
