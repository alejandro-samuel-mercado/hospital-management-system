package hospital.gestion;

import java.util.Scanner;

import hospital.helper.Helper;
import hospital.modelo.Medicamento;

public class AdministracionMedicamentos {

    static Scanner entrada = new Scanner(System.in);
    static private int cantidadAAdministrar;

    public static Medicamento administrarMedicamentos(Medicamento[] medicamentos) {
        cantidadAAdministrar = Helper.validarEnteroNoNegativo(entrada,
                "Indique la cantidad de medicamento a suministrar: ");

        Medicamento medicamentoSuministrado = asignarYCalcularNuevoStock(medicamentos, cantidadAAdministrar);

        return medicamentoSuministrado;
    }

    private static Medicamento asignarYCalcularNuevoStock(Medicamento[] medicamentos, int cantidadAdministrada) {
        Medicamento medicamentoSuministrado = null;
        boolean hayStock = false;

        for (Medicamento medicamento : medicamentos) {
            if (medicamento != null) {
                int cantidadDisponible = medicamento.getCantidadEnStack();
                int codigoMedicamento = medicamento.getCodigo();

                if (cantidadDisponible >= cantidadAdministrada) {
                    medicamento.setCantidadEnStack(cantidadDisponible - cantidadAdministrada);
                    medicamentoSuministrado = medicamento;
                    System.out.println("Se administró el medicamento con código " + codigoMedicamento);
                    System.out.println("Nuevo stock: " + medicamento.getCantidadEnStack());
                    hayStock = true;
                    break;
                }
            }
        }
        if (!hayStock) {
            System.out.println("No hay suficiente stock disponible en ninguno de los medicamentos.");
        }
        return medicamentoSuministrado;
    }

    public static int getCantidadAAdministrar() {
        return cantidadAAdministrar;
    }

}