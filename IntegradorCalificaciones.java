import java.util.Scanner;
import java.util.Arrays;

public class IntegradorCalificaciones {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        boolean logico;
        int opcion=0;
        Double suma=0.0;
        String nombreABuscar;
        String[] alumnos = new String[0];
        Double[] notas = new Double[0];
        
        do{
        System.out.println("1.Agregar alumno y nota \n 2.Mostrar todos los alumnos y notas \n 3.Mostrar promedio de notas \n 4.Buscar alumnos por nombre y mostrar nota \n 5.Modificar nombre y nota \n 6.Eliminar alumno por nombre \n 7.Salir");
        System.out.println("\n Ingrese una opcion");
        opcion=lector.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese nombre del alumno");
                alumnos=Arrays.copyOf(alumnos,alumnos.length+1);
                alumnos[alumnos.length-1]=lector.next();
                System.out.println("Ingrese la nota del alumno");
                notas=Arrays.copyOf(notas,notas.length+1);
                notas[notas.length-1]=lector.nextDouble();
                break;
            case 2:
                if(alumnos.length==0){
                    System.out.println("No hay alumnos cargados");
                }else {
                //System.out.println(Arrays.toString(alumnos));
                //System.out.println(Arrays.toString(notas));
                for(int k=0 ; k<alumnos.length ; k++){
                    String msj = alumnos[k]+"   "+notas[k];
                    System.out.println(msj);
                }
                }
                break;
            case 3:
                if(alumnos.length==0){
                    System.out.println("No hay alumnos cargados");
                }else {
                for (int i=0; i<notas.length;i++){
                suma=suma+notas[i];
                }
                System.out.println("El promedio de las notas es "+ (suma/notas.length));
                }
                break;
            case 4:
                System.out.println("Ingrese el nombre del alumno que desea buscar, y se devuelve la nota");
                nombreABuscar=lector.next();
                logico=false;
                for (int i=0;i<alumnos.length;i++){
                    if(alumnos[i].equals(nombreABuscar)){
                        System.out.println("La nota es "+notas[i]);
                        logico=true;
                    }  
                }
                if (logico==false){
                    System.out.println("El nombre no esta en la lista");
                }
                break;
            case 5:
                System.out.println("Ingrese el nombre del alumno que desea buscar y modificar");
                nombreABuscar=lector.next();
                logico=false;
                for (int i=0;i<alumnos.length;i++){
                    if(alumnos[i].equals(nombreABuscar)){
                        System.out.println("Ingrese el nuevo nombre del alumno");
                        alumnos[i]=lector.next();
                        System.out.println("Modificar la nota");
                        notas[i]=lector.nextDouble();
                        logico=true;
                    }
                }
                if(logico==false){
                    System.out.println("El nombre no esta en la lista");
                }
                
                break;
            case 6:
            System.out.println("Ingrese el nombre del alumno que desea buscar y eliminar");
                nombreABuscar=lector.next();
                logico=false;
                for (int i=0;i<alumnos.length;i++){
                    if(alumnos[i].equals(nombreABuscar)){
                        for(int j=i;j<notas.length-1;j++){
                            alumnos[j]=alumnos[j+1];
                            notas[j]=notas[j+1];
                        }
                        alumnos=Arrays.copyOf(alumnos,alumnos.length-1);
                        notas=Arrays.copyOf(notas,notas.length-1);
                        System.out.println("Alumno eliminado");
                        logico=true;
                    }
                }
                if(logico==false){
                        System.out.println("El nombre no esta en la lista");
                }
                break;
            default:
            System.out.println("Usted eligió salir del menu");
                break;
        }

    } while (opcion != 7);
    lector.close();
}
}
