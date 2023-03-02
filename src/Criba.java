import java.util.Scanner;

/**
 *
 *La clase Criba contiene un método para generar números primos hasta un número máximo dado.
 *
 */
public class Criba {

    /**

     Genera un array de números primos hasta el número máximo especificado.
     @param max El número máximo hasta el cual se generarán los números primos.
     @return Un array de enteros que contiene todos los números primos hasta el número máximo especificado.

     */
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0];
        }
        int dim = max + 1;
        boolean[] esPrimo = new boolean[dim];
        int cuenta = 0;

        for (int i = 2; i < dim; i++) {
            esPrimo[i] = true;
        }

        for (int i = 2; i * i < dim; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j < dim; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        for (int i = 2; i < dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }

        int[] primos = new int[cuenta];
        int index = 0;
        for (int i = 2; i < dim; i++) {
            if (esPrimo[i]) {
                primos[index++] = i;
            }
        }

        return primos;
    }

    /**

     El método principal de la clase, que solicita al usuario un número máximo para generar los números primos correspondientes y los muestra en la consola.

     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el número para la criba de Eratóstenes: ");
        int dato = teclado.nextInt();

        int[] vector = generarPrimos(dato);

        System.out.println("\nVector de primos hasta " + dato + ":");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + "\t");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}