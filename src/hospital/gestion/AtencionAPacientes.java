package hospital.gestion;

import java.time.LocalDate;
import java.util.ArrayList;
import hospital.estructuras.*;
import hospital.modelo.*;

public class AtencionAPacientes {

	public static void atencionAPacientes(Queue<Paciente> prioridadAlta, BinarySearchTree<Medico> medicosDisponibles,
			Queue<Paciente> prioridadMedia, SimpleLinkedList<Consulta> consultasRealizadas,
			StackGenerica<Cirugia> cirugiasProgramadas) {

		// atencionDeClientes(prioridadMedia, medicosDisponibles, consultasRealizadas);
		programarCirugias(prioridadAlta, medicosDisponibles, cirugiasProgramadas);

	}

	private static void atencionDeClientes(Queue<Paciente> prioridadMedia, BinarySearchTree<Medico> medicosDisponibles,
			SimpleLinkedList<Consulta> consultasRealizadas) {
		ArrayList<Paciente> arrayAuxiliar = new ArrayList<Paciente>();
		String especialidad = "Clinico generalista";
		while (!prioridadMedia.isEmpty()) {
			// A continuacion se hace la asignacion de medicos(Consultas)
			Medico medicoACargo = AsignacionDeMedicos.AsignarMedico(medicosDisponibles, especialidad);
			if (medicoACargo != null) {
				for (int i = 0; i < 10; i++) {
					Paciente pacienteARealizarConsulta = prioridadMedia.remove();
					arrayAuxiliar.add(pacienteARealizarConsulta);
					Consulta consultaARealizar = new Consulta(medicoACargo, pacienteARealizarConsulta, null, 0,
							LocalDate.now());
					consultasRealizadas.addLast(consultaARealizar);
				}
				medicosDisponibles.add(medicoACargo);
			} else {
				break;
			}

		}
		System.out.println("Los pacientes de prioridad media fueron todos atendidos");
	}

	private static void programarCirugias(Queue<Paciente> prioridadAlta, BinarySearchTree<Medico> medicosDisponibles,
			StackGenerica<Cirugia> cirugiasProgramadas) {
		int num;
		String especialidad = "Cirujano";
		while (!prioridadAlta.isEmpty()) {
			for (num = 0; num < 3; ++num) {
				if (!prioridadAlta.isEmpty()) {
					Paciente pacienteARealizarCirugia = prioridadAlta.remove();
					Medico medicoResponsable = AsignacionDeMedicos.AsignarMedico(medicosDisponibles, especialidad);

					if (medicoResponsable != null) {
						Cirugia cirugiaARealizar = new Cirugia(medicoResponsable, pacienteARealizarCirugia,
								LocalDate.now());
						cirugiasProgramadas.push(cirugiaARealizar);
						medicosDisponibles.add(medicoResponsable);
						System.out.println(
								"Se programó la cirugía para el paciente: " + pacienteARealizarCirugia.getNombre());
					} else {
						System.out.println("No se pudo asignar un médico para la cirugía " + num);
					}

				} else {
					System.out.println("Se programaron solo " + num + " cirugías porque no había más pacientes");
					break; // Salir si no hay pacientes
				}
			}
		}
	}

}