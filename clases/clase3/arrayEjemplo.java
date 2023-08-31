package clases.clase3;

public class arrayEjemplo {
    public static void main(String[] args) {
        int[] edades = new int[5]; // ojo, tiene 5 elementos, entonces hay indices del 0-4
        // NOTA: se puede defini tmb como int edades[] como haciamos en la facu, pero dice que no es convencional
        String[] nombresVarones;
        String[] nombresMujeres;

        edades[0] = 25;
        System.out.println("La primera edad es: " + edades[0]);
        System.out.println("Largo del array: " + edades.length);
        
        //OTRA FROMA DE CREAR E INICIALIZAR UN ARRAY
        int[] edades2 = {23, 24, 54, 10, 80}; // !! ojo, con llaves, no corechetes
        System.out.println("La primera edad es: " + edades2[0]);
    }
}