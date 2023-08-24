package clases.clase2;

public class Condicionales {
    
    public static void main(String[] args) {
        int edad = 18;

        // if
        if(edad < 18) {
            System.out.println("No podes entrar, sos menor de edad");
        } else if (edad > 65) {
            System.out.println("No podes entrar, sos mayor de edad");
        } else {
            System.out.println("Podes entrar, aposta tranca");
        }


        // suponemos que tenemos un sistema de notas del 1 al 10, que tiene diferente calificaciones:
        // 1 - 4  desaprobado
        // 5 - 6  aprobado (bien)
        // 7 - 8  aprobado (muy bien)
        // 8 - 10 aprobado (excelente)
    
        int nota = 5;
        if(nota <= 4) {
            System.out.println("Desaprobado");
        } else if (nota > 4 && nota <= 6) {
            System.out.println("Apobado, bien");
        } else if (nota > 6 && nota <= 7) {
            System.out.println("Aprobado, muy bien");
        } else {
            System.out.println("Aprobado, excelente");
        }
    
        // DE ESTA FORMA HAY MUCHOS IF ELSE, POR LO QUE ES MEJOR USAR SWITCH

        // SWITCH

        String mes;
        int mesActual = 8;
        switch (mesActual) {
            case 1:
                mes = "Enero";
                break;
            case 2:
                mes = "Febrero";
                break;
            case 3:
                mes = "Marzo";
                break;
            case 4:
                mes = "Abril";
                break;
            case 5:
                mes = "Mayo";
                break;
            case 6:
                mes = "Junio";
                break;
            case 7:
                mes = "Julio";
                break;
            case 8:
                mes = "Agosto";
                break;
            case 9:
                mes = "Septiembre";
                break;
            case 10:
                mes = "Octubre";
                break;
            case 11:
                mes = "Novimebre";
                break;
            case 12:
                mes = "Diciembre";
                break;
            default:
                mes = "No existe ese numero de mes";
                break;
        }
        // Break es para que no siga evaluando una vez que coincide, sino sigue.
        System.out.println(mes);

        //SWITCH CON MULTI-ETIQUETAS
        //CONSIGNA: determinar la cantidad de días de acuerdo al mes, OJO CON FEBRERO!

        int mes2 = 2;
        int anio = 2023;
        int numeroDeDias = 0;
        
        switch(mes2) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDeDias = 31;
                break;
            
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDeDias = 30;
                break;
            
            case 2:
                if (((anio % 4 == 0) && !(anio % 100 == 0)) || (anio % 400 == 0))
                    numeroDeDias = 29;
                else
                    numeroDeDias = 28;
                break;
            
            default:
                System.out.println("Mes invalido");
                break;
        }

        System.out.println("El mes " + mes2 + " tiene " + numeroDeDias + " dias");
    }

}