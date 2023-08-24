package ejerciciosEnClase;
/* Descripción de la actividad. 
   Generar un programa que retorne por consola el número del mes a partir del nombre del mes que se pasa cómo parámetro
 */
public class ejercicioNumeroDeMes {
    public static void main(String[] args) {
        String mesIngresado = "Mayo";
        int numeroMes;

        switch (mesIngresado) {
            case "Enero":
            case "enero":
                numeroMes = 1;
                break;
            case "Febrero":
            case "febrero":
                numeroMes = 2;
                break;
            case "Marzo":
            case "marzo":
                numeroMes = 3;
                break;
            case "Abril":
            case "abril":
                numeroMes = 4;
                break;
            case "Mayo":
            case "mayo":
                numeroMes = 5;
                break;
            case "Junio":
            case "junio":
                numeroMes = 6;
                break;
            case "Julio":
            case "julio":
                numeroMes = 7;
                break;
            case "Agosto":
            case "agosto":
                numeroMes = 8;
                break;
            case "Septiembre":
            case "septiembre":
                numeroMes = 9;
                break;
            case "Octubre":
            case "octubre":
                numeroMes = 10;
                break;
            case "Noviembre":
            case "noviembre":
                numeroMes = 11;
                break;
            case "Diciembre":            
            case "diciembre":
                numeroMes = 12;
                break;
            default:
                System.out.println("Mes invalido");
                break;
        }

        System.out.println(numeroMes);
    }
}
