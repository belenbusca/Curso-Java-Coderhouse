package ejerciciosEnClase;
// clase 4 - objetos 
/* Crear una clase con un método main, en el cuerpo de este método imprimir el valor de una variable entera. 
   Dentro de la misma clase crear un segundo método para incrementar allí la variable anterior e invocarlo desde el 
   método main y volver a imprimir el valor. 
   Debe mostrarse el valor incrementado. 
   Importante: el segundo método no recibirá ni retorna valor. */

public class metodosVariables {
    static int variableEntera = 10;
    
    public static void main(String[] args) {
        System.out.println(variableEntera);
        incrementarVariable();
        System.out.println(variableEntera);
    }
    
    static public void incrementarVariable(){
        variableEntera++;
    }
}
