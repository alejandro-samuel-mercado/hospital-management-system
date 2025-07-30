package hospital.modelo;

import java.time.LocalDate;

public class Consulta {

	private Medico medicoACargo;
	private Paciente paciente;
	private Medicamento medicacionAdministrada;
	private int cantidadAplicada;
	private LocalDate fecha;
	
	public Consulta(Medico medicoACargo, Paciente paciente, Medicamento medicacionAdministrada, int cantidadAplicada,
			LocalDate fecha) {
		super();
		this.medicoACargo = medicoACargo;
		this.paciente = paciente;
		this.medicacionAdministrada = medicacionAdministrada;
		this.cantidadAplicada = cantidadAplicada;
		this.fecha = fecha;
	}
	public Medico getMedicoACargo() {
		return medicoACargo;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public Medicamento getMedicacionAdministrada() {
		return medicacionAdministrada;
	}
	public int getCantidadAplicada() {
		return cantidadAplicada;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setMedicoACargo(Medico medicoACargo) {
		this.medicoACargo = medicoACargo;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public void setMedicacionAdministrada(Medicamento medicacionAdministrada) {
		this.medicacionAdministrada = medicacionAdministrada;
	}
	public void setCantidadAplicada(int cantidadAplicada) {
		this.cantidadAplicada = cantidadAplicada;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Consulta [medicoACargo=" + medicoACargo + ", paciente=" + paciente + ", medicacionAdministrada="
				+ medicacionAdministrada + ", cantidadAplicada=" + cantidadAplicada + ", fecha=" + fecha + "]";
	}
	
	
}
