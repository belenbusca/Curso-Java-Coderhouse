package ejerciciosEntregables.manejoDatosTipoFloat;

public class NumeroFlotanteBusca {
    public static void main(String[] args) {
        float numero = 12.7f;
        int parteEntera = (int) numero;
        float parteDecimal = numero - parteEntera;
        System.out.println("numero: " + numero);
        System.out.println("parte entera: " + parteEntera);
        System.out.println("parte decimal: " + parteDecimal);
    }
}