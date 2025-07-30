package hospital.gestion;

import java.util.Random;
import java.util.Scanner;
import hospital.estructuras.Queue;
import hospital.helper.Helper;
import hospital.modelo.Paciente;

public class RecepcionPasientes {

	
	public static void recepcionDePaciente(Scanner entrada,Queue<Paciente> prioridadMedia,Queue<Paciente> prioridadAlta) {
		
		Random random = new Random();
		int dni = Helper.validarEnteroEnRango(entrada, "ingrese el DNI", 10000000, 60000000);
		String nombre = Helper.validarStringNoVacio(entrada, "ingrese el nombre del paciente");
		int edad =Helper.validarEnteroEnRango(entrada, "ingrese la edad del paciente ", 1, 100);
		String antecedente = Helper.validarStringNoVacio(entrada, "ingrese el antecedente");
		int diagnosticoPreliminar = random.nextInt(1,3);
		
		Paciente paciente = new Paciente(dni, nombre, edad, antecedente, diagnosticoPreliminar);
		
		if (paciente.getDiagnisticoPreliminar() == 1) {
			prioridadAlta.add(paciente);
		}else {
			prioridadMedia.add(paciente);
		}
	}
}
