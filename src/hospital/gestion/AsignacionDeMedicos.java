package hospital.gestion;

import hospital.estructuras.BinarySearchTree;
import hospital.modelo.*;

public class AsignacionDeMedicos {

	public static Medico AsignarMedico(BinarySearchTree<Medico> medicosDisponibles, String especialidadBuscada) {
		// Crea un auxiliar para buscar el medico por su especialidad
		Medico auxiliar = new Medico(especialidadBuscada);
		Medico medicoAsignado = null;
		try {
			medicoAsignado = medicosDisponibles.remove(auxiliar);
			if (medicoAsignado == null) {
				System.out.println("No se encontró un médico con la especialidad: " + especialidadBuscada);
			}
		} catch (RuntimeException e) {
			System.out.println("Error al intentar asignar un médico: " + e.getMessage());
		}
		return medicoAsignado;
	}

}