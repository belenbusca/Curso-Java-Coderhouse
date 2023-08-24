package ejerciciosEnClase.ejercicioPrestamo;
// clase 1

/* CONSIGNA:
   Generaar un programa que retorne por consola el monto total que se pagara en el banco
   El monto total es Capital Solicitado + intereses a pagar.
   La fórmula para calcular "cuánto interés se pagará" por un préstamo pedido al banco es: 
   Interés a pagar = Capital solicitado x Interés x periodo en meses
*/

public class prestamo {
    public static void main(String[] args) {
        int capitalSolicitado = 1000;
        double intereses = 2;
        int cuotas = 12;

        int interesAPagar = capitalSolicitado * (int) intereses * cuotas;
        int montoTotal = capitalSolicitado + interesAPagar;
        System.out.println("El interes a pagar es: " + interesAPagar);
        System.out.println("El monto total es: " + montoTotal);
    }
}
