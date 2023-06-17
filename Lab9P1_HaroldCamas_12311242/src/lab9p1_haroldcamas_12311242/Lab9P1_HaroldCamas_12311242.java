package lab9p1_haroldcamas_12311242;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab9P1_HaroldCamas_12311242 {

    static Scanner leer = new Scanner(System.in);
    static Scanner numero = new Scanner(System.in);
    static int contador = 0;

    public static void main(String[] args) {
        boolean empezar = true;
        boolean seguir = true;
        int op = 0;
        int opcion = 0;

        while (empezar) {
            op = ejercicio();
            switch (op) {
                
                case 1:
                    ArrayList<Libro> librero = new ArrayList<>();
                    seguir = true;
                    
                    while (seguir) {
                        opcion = menu();

                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese la cantidad de libros a añadir: ");
                                int number = numero.nextInt();
                                //Validacion.
                                while(number < 0){
                                    System.out.println("Ingrese una cantidad valida!");
                                    number = numero.nextInt();
                                }
                                
                                librero = agregar(number, librero);
                                contador += number;
                                break;

                            case 2:
                                //Validacion para que el usuario no entre con el ArrayList vacio al metodo.
                                if (contador == 0){
                                    System.out.println("No tienes ningun libro aun!");
                                    break;
                                }
                                listar(librero);
                                break;

                            case 3:
                                //Validacion para que el usuario no entre con el ArrayList vacio al metodo.
                                if (contador == 0){
                                    System.out.println("No tienes ningun libro aun!");
                                    break;
                                }
                                
                                listar(librero);
                                System.out.println("\nElija cual libro modificar: ");
                                int eleccion = numero.nextInt();
                                //Validacion.
                                while(eleccion <= 0 || eleccion > librero.size()){
                                    System.out.println("Elija un libro dentro de los disponibles!");
                                    eleccion = numero.nextInt();
                                }
                                
                                librero = modificar(eleccion,librero);
                                System.out.println("Libro modificado con exito.");
                                break;

                            case 4:
                                //Validacion para que el usuario no entre con el ArrayList vacio al metodo.
                                if (contador == 0){
                                    System.out.println("No tienes ningun libro que eliminar!");
                                    break;
                                }
                                
                                listar(librero);
                                System.out.println("\nElija cual libro eliminar: ");
                                int eleccion_e = numero.nextInt();
                                //Validacion.
                                while(eleccion_e <= 0 || eleccion_e > librero.size()){
                                    System.out.println("Elija un libro dentro de los disponibles!");
                                    eleccion_e = numero.nextInt();
                                }
                                
                                librero = eliminar(eleccion_e,librero);
                                System.out.println("Libro eliminado con exito");
                                contador -= 1;
                                break;

                            case 5:
                                System.out.println("Introduzca que Titulo desea buscar: ");
                                String filtro = leer.nextLine();
                                buscar(librero,filtro,5);
                                break;

                            case 6:
                                System.out.println("Introduzca que Autor desea buscar: ");
                                String filtro_2 = leer.nextLine();
                                buscar(librero,filtro_2,6);
                                break;

                            case 7:
                                System.out.println("Introduzca que Genero desea buscar: ");
                                String filtro_3 = leer.nextLine();
                                buscar(librero,filtro_3,7);
                                break;

                            case 8:
                                seguir = false;
                                break;

                            default:
                                System.out.println("Elija una opcion valida");
                                break;
                        }
                    }
                    break;

                case 2:
                    empezar = false;
                    break;

                default:
                    System.out.println("Elija una opcion valida.");
                    break;
            }
        }
    }

    public static int ejercicio() {
        int op = 0;
        System.out.println("1.)Ejercicio");
        System.out.println("2.)Salir");
        op = numero.nextInt();
        return op;
    }

    public static int menu() {
        int op = 0;
        System.out.println("");
        System.out.println("1.)Agregar libro");
        System.out.println("2.)Listar libros");
        System.out.println("3.)Modificar");
        System.out.println("4.)Eliminar libro");
        System.out.println("5.)Buscar libro por titulo");
        System.out.println("6.)Buscar libros segun autor");
        System.out.println("7.)Busqueda con filtro de genero");
        System.out.println("8.)Salir");
        op = numero.nextInt();
        return op;
    }

    public static ArrayList<Libro> agregar(int number, ArrayList<Libro> librero) {
        String titulo = "";
        String autor = "";
        String genero = "";
        int edad = 0;
        System.out.println("Se añadiran " + number + " libros");

        for (int i = 0; i < number; i++) {
            System.out.println("Ingrese los datos del libro " + (i + 1) + ":");
            System.out.println("Titulo: ");
            titulo = leer.nextLine();

            System.out.println("Nombre del autor: ");
            autor = leer.nextLine();

            System.out.println("Genero literario: ");
            genero = leer.nextLine();

            System.out.println("Edad minima para leerlo: ");
            edad = numero.nextInt();

            Libro libro = new Libro(titulo, autor, genero, edad);
            librero.add(libro);
        }
        return librero;
    }

    public static void listar(ArrayList<Libro> librero) {
        Libro libro = new Libro();
        for (int i = 0; i < librero.size(); i++) {
            System.out.println("\nLibro " + (i + 1) + "\n");
            libro = librero.get(i);
            System.out.println("Titulo: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Genero: " + libro.getGenero());
            System.out.println("Edad minima: " + libro.getEdad());
        }
    }
    
    public static ArrayList<Libro> modificar(int eleccion, ArrayList<Libro> librero){
        System.out.println("Que quiere modificar de ese libro?");
        System.out.println("1.) Titulo");
        System.out.println("2.) Autor");
        System.out.println("3.) Genero");
        System.out.println("4.) Edad");
        
        int opcion = numero.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Elija un nuevo titulo: ");
                String titulo = leer.nextLine();
                librero.get(eleccion - 1).setTitulo(titulo);
                break;
                
            case 2:
                System.out.println("Elija un nuevo autor: ");
                String autor = leer.nextLine();
                librero.get(eleccion - 1).setAutor(autor);
                break;
                
            case 3:
                System.out.println("Elija un nuevo genero: ");
                String genero = leer.nextLine();
                librero.get(eleccion - 1).setGenero(genero);
                break;
                
            case 4:
                System.out.println("Elija una nueva edad minima: ");
                int edad = numero.nextInt();
                librero.get(eleccion - 1).setEdad(edad);
                break;
        }
        return librero;
    }
    
    public static ArrayList<Libro> eliminar(int eleccion, ArrayList<Libro> librero){
        librero.remove(eleccion - 1);
        return librero;
    }
    
    public static void buscar(ArrayList<Libro> librero,String filtro, int opcion){
        String categoria = "";
        //Aqui estan las 3 busquedas en un solo metodo.
        switch(opcion){
            //Busqueda por titulo.
            case 5:
                System.out.println("Filtrado por Titulo seleccionado: ");
                for (int i = 0; i < librero.size(); i++){
                    categoria = librero.get(i).getTitulo();
                    //Si el atributo del libro coincide con el buscado solo lo imprime.
                    if (categoria.equalsIgnoreCase(filtro)){
                        System.out.println("\n" +"Libro " + (i + 1) + "\n");
                        System.out.println("Titulo: " + librero.get(i).getTitulo());
                        System.out.println("Autor: " + librero.get(i).getAutor());
                        System.out.println("Genero: " + librero.get(i).getGenero());
                        System.out.println("Edad minima: " + librero.get(i).getEdad());
                    }
                }
                break;
            //Busqueda por autor.    
            case 6:
                System.out.println("Filtrado por Autor seleccionado: ");
                for (int i = 0; i < librero.size(); i++){
                    categoria = librero.get(i).getAutor();
                    //Si el atributo del libro coincide con el buscado solo lo imprime.
                    if (categoria.equalsIgnoreCase(filtro)){
                        System.out.println("\n" +"Libro " + (i + 1) + "\n");
                        System.out.println("Titulo: " + librero.get(i).getTitulo());
                        System.out.println("Autor: " + librero.get(i).getAutor());
                        System.out.println("Genero: " + librero.get(i).getGenero());
                        System.out.println("Edad minima: " + librero.get(i).getEdad());
                    }
                }
                break;
            //Busqueda por genero.    
            case 7:
                System.out.println("Filtrado por Genero seleccionado: ");
                for (int i = 0; i < librero.size(); i++){
                    categoria = librero.get(i).getGenero();
                    //Si el atributo del libro coincide con el buscado solo lo imprime.
                    if (categoria.equalsIgnoreCase(filtro)){
                        System.out.println("\n" +"Libro " + (i + 1) + "\n");
                        System.out.println("Titulo: " + librero.get(i).getTitulo());
                        System.out.println("Autor: " + librero.get(i).getAutor());
                        System.out.println("Genero: " + librero.get(i).getGenero());
                        System.out.println("Edad minima: " + librero.get(i).getEdad());
                    }
                }
                break;
        }
    }
}