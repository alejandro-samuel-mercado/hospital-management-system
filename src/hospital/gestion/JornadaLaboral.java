package hospital.gestion;

import hospital.modelo.*;

import java.util.Random;
import java.util.Scanner;
import hospital.estructuras.*;
import hospital.helper.*;

public class JornadaLaboral {

	public static void iniciarJornadaLaboral(Scanner entrada, int cantidadDeMedicamentos, Medicamento[] medicamentos,
			BinarySearchTree<Medico> medicosDisponibles) {

		Random random = new Random();
		medicamentos = medicamentos(cantidadDeMedicamentos, entrada);
		crearMedico(entrada, medicosDisponibles, random);

	}

	public static Medicamento[] medicamentos(int cantidadDeMedicamentos, Scanner entrada) {

		Medicamento[] medicamentos = new Medicamento[cantidadDeMedicamentos];
		for (int i = 0; i < cantidadDeMedicamentos; ++i) {
			String Descripcion = Helper.validarStringNoVacio(entrada, "Descripcion de Medicamentos...");
			double Precio = Helper.validarDoubleNoNegativo(entrada, "ingregrese el precio del medicamento...");
			int cantidadUnitaria = Helper.validarEnteroNoNegativo(entrada, "Cantidad unitaria: ");
			medicamentos[i] = new Medicamento(Descripcion, Precio, cantidadUnitaria);
		}
		return medicamentos;
	}

	private static void crearMedico(Scanner entrada, BinarySearchTree<Medico> medicosDisponibles, Random random) {
		boolean seguirCargando = true;
		int maximoDeMedicos = 0;
		int matriculas = 0;

		while (seguirCargando && maximoDeMedicos < 30) {
			int matricula = ++matriculas;
			String nombre = Helper.validarStringNoVacio(entrada, "Ingrese el nombre del medico: ");
			String especialidad = especialidad(entrada);
			medicosDisponibles.add(new Medico(matricula, nombre, especialidad));
			++maximoDeMedicos;
			if (maximoDeMedicos < 30) {
				seguirCargando = Helper.validarSiNo(entrada,
						"¿Desea seguir cargando Médicos? Tiene un máximo de 30 médicos.");
			} else {
				System.out.println("Se ha alcanzado el máximo de 30 médicos.");
			}
		}
	}

	public static String especialidad(Scanner entrada) {
		final String CIRUJANO = "Cirujano";
		final String CLINICO_GENERAL = "Clinico generalista";

		System.out.println("----Especialidades de los medicos----\n"
				+ "1. " + CIRUJANO + "\n"
				+ "2. " + CLINICO_GENERAL);
		int opcionEspecialidad = Helper.validarEnteroEnRango(entrada, "De qué especialidad es el médico", 1, 2);
		return (opcionEspecialidad == 1) ? CIRUJANO : CLINICO_GENERAL;
	}
}