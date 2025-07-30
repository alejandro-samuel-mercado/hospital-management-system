package hospital.modelo;

public class Medicamento {

	private int siguenteCodigo;
	private int codigo;
	private String descripcion;
	private double precioUnitario;
	private int cantidadEnStack;
	
	public Medicamento() {
		
	}
	
	public Medicamento( String descripcion, double precioUnitario, int cantidadEnStack) {
		this.codigo = siguenteCodigo;
		++this.siguenteCodigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.cantidadEnStack = cantidadEnStack;
	}
	

	public int getCodigo() {
		return codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	
	public int getCantidadEnStack() {
		return cantidadEnStack;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public void setCantidadEnStack(int cantidadEnStack) {
		this.cantidadEnStack = cantidadEnStack;
	}

	@Override
	public String toString() {
		return "Medicamento [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", cantidadEnStack=" + cantidadEnStack + "]";
	}
	
}
