import java.util.Scanner;

public class Criba {
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