package hospital.gestion;

import java.util.EmptyStackException;

import hospital.estructuras.*;
import hospital.modelo.*;


public class RealizacionCirugia {

    public static void realizacionCirugia(StackGenerica<Cirugia> cirugiasProgramadas,
            SimpleLinkedList<Cirugia> operacionesRealizadas, BinarySearchTree<Medico> medicosDisponibles) {
        int maxCirugiasSimultaneas = 3;
        int cirugiasRealizadasEnEstaRonda = 0;

        System.out.println("Iniciando el proceso de cirugías...");

        while (!cirugiasProgramadas.isEmpty() && cirugiasRealizadasEnEstaRonda < maxCirugiasSimultaneas) {
            try {
                Cirugia cirugiaRealizada = cirugiasProgramadas.pop();
                operacionesRealizadas.addLast(cirugiaRealizada);
                cirugiasRealizadasEnEstaRonda++;

                System.out.println("Cirugía realizada para el paciente: " + cirugiaRealizada.getPaciente().getNombre() +
                        " con el cirujano: " + cirugiaRealizada.getMedicoResponsable().getNombre());

                medicosDisponibles.add(cirugiaRealizada.getMedicoResponsable());
            }

            catch (EmptyStackException e) {
                System.err.println("Error: No hay cirugías programadas en la pila.");
                break;
            } catch (NullPointerException e) {
                System.err.println("Error: No se pudo reinsertar al cirujano porque es nulo.");
            }
        }
        if (cirugiasRealizadasEnEstaRonda == 0) {
            System.out.println("No hay cirugías programadas para realizar.");
        }
    }

}