package hospital.gestion;

import java.time.LocalDate;
import java.util.Scanner;

import hospital.estructuras.*;
import hospital.helper.Helper;
import hospital.modelo.*;

public class Consultas {

	public static void consultas (Scanner entrada, BinarySearchTree<Medico> medicosDisponibles,Medicamento[] medicamentos,SimpleLinkedList<Cirugia> cirugiasRealizadas,SimpleLinkedList<Consulta> consultasRealizadas) {
		
		boolean continuar = true;

		while (continuar) {
			menuConsultas();
			int opc = Helper.validarEnteroEnRango(entrada, "ingrese una opcion", 1, 9);
			switch (opc) {
			case 1:
				medicosDisponibles.InOrder();
				break;
			case 2:
				int num = 0;
				int cantidad = Helper.validarEntero(entrada, "ingrese la cantidad de medicamentos que necesita : ");
				try {
					
					
					for (Medicamento medicamento : medicamentos) {
						if (medicamento.getCantidadEnStack() >= cantidad) {
							System.out.println(medicamento.toString());
							++num; 
							
						}
				
						System.out.println("Los medicamentos con stock igual o mayor al que necesita son : " + num);
					}
					
				} catch (Exception e) {
					System.out.println("No hay medicamentos que superen el stock ingresado o no hay medicamentos disponibles");
				}
				
				break;

			case 3:
				if (cirugiasRealizadas.size() <= 0) {
					System.out.println("No hay cirugias realizadas existentes");
				} else {
					for (Cirugia cirugia : cirugiasRealizadas) {
						System.out.println(cirugia.toString());

					}
				}
				
				break;

			case 4:
				if (consultasRealizadas.size() <= 0) {
					System.out.println("No hay consultas realizadas existentes");
				} else {
					for(Consulta consulta : consultasRealizadas) {
						System.out.println(consulta.toString());
					}
				}
				

				break;

			case 5:
				LocalDate fechaInicio = Helper.validarFecha(entrada, "Ingrese la fecha de inicio :", "dd-MM-yyyy");
				LocalDate fechaFin = Helper.validarFecha(entrada, "Ingrese la fecha final :", "dd-MM-yyyy");

				int cont1 = 0;
				System.out.println("Consultas realizadas entre las fechas :");
				for(Consulta consulta : consultasRealizadas) {
					if (consulta.getFecha().isAfter(fechaInicio) && consulta.getFecha().isBefore(fechaFin)) {
						System.out.println(consulta.toString());
						++cont1;
					}
				}
				if (cont1 == 0) {
					System.out.println("No existen consultas realizadas entre las fechas");
				}

				int cont2 = 0;
				System.out.println("Cirugias realizadas entre las fechas :");
				for (Cirugia cirugia : cirugiasRealizadas) {
					if (cirugia.getFecha().isAfter(fechaInicio) && cirugia.getFecha().isBefore(fechaFin)) {
						System.out.println(cirugia.toString());
					}

				}
				if (cont2 == 0) {
					System.out.println("No existen cirugias realizadas entre las fechas");
				}
				
				break;
				
			case 6: 
				int edadMinima = Helper.validarEnteroNoNegativo(entrada, "Ingrese la edad minima :");
				int edadMaxima = Helper.validarEnteroEnRango(entrada, "Ingrese la edad maxima :", edadMinima, 120);
				int contador = 0;
				
				System.out.println("Informacion de las cirugias realizadas en el rango de edades ingresado : ");
				for(Cirugia cirugia : cirugiasRealizadas) {
					if(cirugia.getPaciente().getEdad() >= edadMinima && cirugia.getPaciente().getEdad() <= edadMaxima) {
						++contador;
						System.out.println(cirugia.toString());
					}
					
				}
				System.out.println("Cantidad de cirugias realizas en el rango de edades ingresado : " + contador);
				
				break;
				
			case 7: 
				String antecedente = Helper.validarStringNoVacio(entrada, "Ingrese el antecedente a filtrar :");
				
				int count = 0;
				try {
					for(Consulta consulta :consultasRealizadas) {
						if(consulta.getPaciente().getAntecedentes().equals(antecedente)) {
							++count;
						}
					}
					
				} catch (Exception e) {
					System.out.println("No hay pacientes que presenten el antecedente ingresado o la lista de consultas esta vacia");
				}
				
					
				
				System.out.println("La cantidad de pacientes atendidos que presentan el antecedente descripto son : " + count);

				break;
				
				
			case 8:
				double montoTotal = 0;
				
				try {
					for(Medicamento medicamento : medicamentos) {
						montoTotal = montoTotal + medicamento.getPrecioUnitario() * medicamento.getCantidadEnStack();
					}
					
				} catch (Exception e) {
					System.out.println("No existen medicamentos en stock");
				}
				
				System.out.println("El monto total al que ascienden los medicamentos en este momento es : " + montoTotal);
				
				break;
			
			case 9: 
				System.out.println("Saliendo de consultas...");
				continuar = false;
			
			default:
				break;
			}
		}
		
	}
	
	public static void menuConsultas() {
		System.out.println("Que tipo de consulta desea realizar: \n" + "1.Medicos disponibles\n"
				+ "2.Medicamentos en stock segun cantidad\n" + "3.Cirugias realizadas\n" + "4.Consultas realizadas\n"
				+ "5.Cantidad de pacientes atendidos en un rango de fechas\n"
				+ "6.Cantidad de pacientes operados en un rango de edad\\n"
				+ "7.Cantidad de pacientes atendidos segun un antecedente\\n"
				+ "8.Monto total de medicamentos en un momento dado\n" + "9.Salir");
	}
}