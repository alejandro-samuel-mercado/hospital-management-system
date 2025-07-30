package hospital.modelo;

public class Medico implements Comparable<Medico> {

	private int matricula;
	private String nombre;
	private String especialidad;

	public Medico(int matricula, String nombre, String especialidad) {

		this.matricula = matricula;
		this.nombre = nombre;
		this.especialidad = especialidad;
	}

	public Medico() {

	}

	public Medico(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Medico [matricula=" + matricula + ", nombre=" + nombre + ", especialidad=" + especialidad + "]";
	}

	@Override
	public int compareTo(Medico otroMedico) {

		return this.especialidad.compareTo(otroMedico.especialidad);
	}

}
