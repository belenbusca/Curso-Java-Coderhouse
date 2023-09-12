package ejerciciosEntregables.listarPersonasBusca;

import java.util.ArrayList;
import java.util.List;

/* -- Consigna --
Deberán crear la clase persona que tiene como atributos nombre y apellido, ambos de tipo String; 
    la clase tiene sus métodos getters y setters para cada atributo.
Deberán crear una segunda clase donde estará el método main como lo conocemos. 
Creen 5 objetos: Personas con nombres y apellidos aleatorios, es importante que sean nombres y apellidos en español.
Teniendo los 5 objetos, agregarlos a una lista. 
Crear la lógica para ordenar alfabéticamente la lista y mostrar en consola de acuerdo al siguiente criterio:
    - Ordenado por nombre.
    - Ordenado por apellido.
    - Ordenado inversamente por apellido. */

public class ListarPersonasBusca {
    public static void main(String[] args) {
        
        //creacion 5 objetos persona
        Persona persona1 = new Persona("Belen", "Busca");
        Persona persona2 = new Persona("Garbiela", "Sande");
        Persona persona3 = new Persona("Pablo", "Fernandez");
        Persona persona4 = new Persona("Valentina", "Aldunate");
        Persona persona5 = new Persona("Manuel", "Mendoza");

        //listado de personas
        List<Persona> listaPersonas = new ArrayList<>();

        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);
        
        //ordenamientos
        // -- Orden por nombre --
        listaPersonas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre())); 
        System.out.println("Orden por nombre: ");
        for (Persona persona : listaPersonas) {
            System.out.println(persona.getNombre() + " " + persona.getApellido());
        }
        
        // -- Orden por apellido --
        listaPersonas.sort((p1, p2) -> p1.getApellido().compareTo(p2.getApellido())); // Orden por apellido
        System.out.println("\nOrden por apellido: ");
        for (Persona persona : listaPersonas) {
            System.out.println(persona.getNombre() + " " + persona.getApellido());
        }
        
        // -- Orden inverso por apellido --
        listaPersonas.sort((p1, p2) -> p2.getApellido().compareTo(p1.getApellido())); // Orden inverso por apellido
        System.out.println("\nOrden inverso por apellido: ");
        for (Persona persona : listaPersonas) {
          System.out.println(persona.getNombre() + " " + persona.getApellido());
        }
    }
}
