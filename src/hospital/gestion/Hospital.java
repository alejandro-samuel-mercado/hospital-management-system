package hospital.gestion;

import java.util.Scanner;

import hospital.estructuras.*;
import hospital.helper.Helper;
import hospital.modelo.*;

public class Hospital {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        
        Medicamento[] medicamentos = null;
        Queue<Paciente> prioridadMedia = new Queue<Paciente>();
        Queue<Paciente> prioridadAlta = new Queue<Paciente>();
        StackGenerica<Cirugia> cirugiasProgramadas = new StackGenerica<Cirugia>();
        SimpleLinkedList<Consulta> consultasRealizadas = new SimpleLinkedList<Consulta>();
        SimpleLinkedList<Cirugia> cirugiasRealizadas = new SimpleLinkedList<Cirugia>();
        BinarySearchTree<Medico> medicosDisponibles = new BinarySearchTree<Medico>();
        
        boolean seguir = true;
        boolean jornadaIniciada = false;
        
        while (seguir) {
            menu();
            int opcion = Helper.validarEnteroEnRango(entrada, "Elija una opcion", 1, 8);
        
            switch(opcion) {
                case 1:
                    if (!jornadaIniciada) {
                        int cantidadDeMedicamentos = Helper.validarEnteroNoNegativo(entrada, "Cantidad de medicamentos a registrar.");
                        medicamentos = new Medicamento[cantidadDeMedicamentos];
                        JornadaLaboral.iniciarJornadaLaboral(entrada, cantidadDeMedicamentos, medicamentos, medicosDisponibles);
                        jornadaIniciada = true;
                    } else {
                        System.out.println("No puede iniciar una nueva jornada sin haber terminado la actual.");
                    }
                    break;
                case 2:
                    if (jornadaIniciada) {
                        RecepcionPasientes.recepcionDePaciente(entrada, prioridadMedia, prioridadAlta);
                    } else {
                        System.out.println("Debe iniciar la jornada antes de recibir pacientes.");
                    }
                    break;
                case 3:
                    if (jornadaIniciada) {
                        AtencionAPacientes.atencionAPacientes(prioridadAlta, medicosDisponibles, prioridadMedia, consultasRealizadas, cirugiasProgramadas);
                    } else {
                        System.out.println("Debe iniciar la jornada antes de atender pacientes.");
                    }
                    break;
                case 4:
                    if (jornadaIniciada) {
                        RealizacionCirugia.realizacionCirugia(cirugiasProgramadas, cirugiasRealizadas, medicosDisponibles);
                    } else {
                        System.out.println("Debe iniciar la jornada antes de realizar cirugías.");
                    }
                    break;
                case 5:
                    if (jornadaIniciada) {
                        AdministracionMedicamentos.administrarMedicamentos(medicamentos);
                    } else {
                        System.out.println("Debe iniciar la jornada antes de administrar medicamentos.");
                    }
                    break;
                case 6:
                    if (jornadaIniciada) {
                        Consultas.consultas(entrada, medicosDisponibles, medicamentos, cirugiasRealizadas, consultasRealizadas);
                    } else {
                        System.out.println("Debe iniciar la jornada antes de realizar consultas.");
                    }
                    break;
                case 7:
                    if (jornadaIniciada) {
                        System.out.println("Jornada finalizada");
                        seguir = false;
                    } else {
                        System.out.println("Debe iniciar la jornada antes de finalizarla.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        entrada.close();
    }

    public static void menu() {
        System.out.println("------Menu------\n"
                + "1. Inicio de Jornada\n"
                + "2. Recepción de Paciente\n"
                + "3. Atención de Pacientes\n"
                + "4. Realización de Cirugía\n"
                + "5. Administración de Medicamentos\n"
                + "6. Consultas\n"
                + "7. Fin de Jornada\n");
    }
}