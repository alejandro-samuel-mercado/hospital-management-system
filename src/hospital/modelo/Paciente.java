package hospital.modelo;

public class Paciente {

	private int dni;
	private String nombre;
	private int edad;
	private String antecedentes;
	private int diagnisticoPreliminar;
	
	public Paciente(int dni, String nombre, int edad, String antecedentes,
			int diagnisticoPreliminar) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.antecedentes = this.antecedentes + ", " + antecedentes;
		this.diagnisticoPreliminar = diagnisticoPreliminar;
	}
	
	public int getDni() {
		return dni;
	}

	
	public String getNombre() {
		return nombre;
	}

	
	public int getEdad() {
		return edad;
	}

	
	public String getAntecedentes() {
		return antecedentes;
	}

	
	public int getDiagnisticoPreliminar() {
		return diagnisticoPreliminar;
	}

	
	public void setDni(int dni) {
		this.dni = dni;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public void setEdad(int edad) {
		this.edad = edad;
	}

	
	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	
	public void setDiagnisticoPreliminar(int diagnisticoPreliminar) {
		this.diagnisticoPreliminar = diagnisticoPreliminar;
	}

	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", antecedentes=" + antecedentes
				+ ", diagnisticoPreliminar=" + diagnisticoPreliminar + "]";
	}
	
}
