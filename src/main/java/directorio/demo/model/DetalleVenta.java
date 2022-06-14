package directorio.demo.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalleventa") 
public class DetalleVenta {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idDetalleVenta;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Producto producto;
		
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Venta venta;


	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}


	public void setIdDetalleVenta(Long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Venta getVenta() {
		return venta;
	}


	public void setVenta(Venta venta) {
		this.venta = venta;
	}


	public DetalleVenta(Long idDetalleVenta, Producto producto, Venta venta) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.producto = producto;
		this.venta = venta;
	}


	public DetalleVenta() {
		
	}
	
	
}
