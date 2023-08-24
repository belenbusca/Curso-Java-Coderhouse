package clases.clase2;

public class operadorTernario {
    public static void main(String[] args) {
        // OPERADOR TERNARIO (?)
        // Abreviacion de if then else 

        /* Para hacer el ejercicio de la edad, la podemos hacer en una linea en vez de varias */

        int edad = 15;
        boolean puedeEntrar = edad > 17 && edad < 60;
        String mensaje = puedeEntrar? "Puede acceder" : "No puede acceder";
        System.out.println(mensaje);
        
        // ES LO MISMO QUE: (sin tener en cuenta los 60)
        if (edad < 18) {
            puedeEntrar = false;
        } else {
            puedeEntrar = true;
        }   
    }
}
