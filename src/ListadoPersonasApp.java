import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        boolean salir = false;
        int opcion;

        while (!salir){
            mostrarMenu();
            try{
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e){
                System.out.println("Ocurrio un error: "+ e);
            }
            System.out.println();
        }
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        int opcion = Integer.parseInt(consola.nextLine());
        boolean salir = false;
        switch (opcion){
            case 1:
                System.out.print("Proporciona el nombre");
                String nombre = consola.nextLine();
                System.out.print("Proporciona el telefono");
                String telefono = consola.nextLine();
                System.out.print("Proporciona el email");
                String email = consola.nextLine();
                var persona = new Persona(nombre, telefono, email);
                personas.add(persona);
                System.out.print("La lista contiene " + personas.size() + "elementos");
                break;
            case 2:
                System.out.println("Listado de personas : ");
                //Lambda y metodo de referencia
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Hasta pronto...");
                salir = true;
            default:
                System.out.println("Opcion erronea : " + opcion);
                break;
        }
        return salir;
    }

    private static void mostrarMenu(){
        System.out.println("""
                **** Aplicacion de listado de personas ****
                1. Agregar 
                2. Listar
                3. Salir
                """);
        System.out.print("Selecciona una opcion ");
    }
}