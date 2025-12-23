import java.util.Arrays;
import java.util.Scanner;

public class BuscaBinaria {
    static void main(String [] args) {
        int[] minhaLista = {5,2,4,1,12,7,56,90};
        int[] ordenado = ordenador(minhaLista);

        Scanner input = new Scanner(System.in);
        System.out.print("Digite um valor para ser fatorado: ");
        int res = input.nextInt();

        System.out.print("Digite o valor do item da lista que você quer ver o índice: ");
        int verify = input.nextInt();
        int verified = findI(verify, ordenado);
        System.out.println("O valor dentro do array é: " + verified);


        System.out.println("Array desordenada " + Arrays.toString(minhaLista));
        System.out.println("Array ordenado " + Arrays.toString(ordenado));
        System.out.println("Localização do item solicitado = " + buscaBinaria(ordenado,12));
        System.out.println("Fatoração = " + fat(ordenado[res]) + " Num = " + ordenado[res]);
    };
    public static int buscaSelecao(int[] arr, int inicio) {
        int menor_indice = inicio;
        for (int i = inicio; i < arr.length; i++) {
            if (arr[i] < arr[menor_indice]) {
                menor_indice = i;
            }
        }
        return menor_indice;
    }

    public static int findI(Integer num, int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num){
                    return arr[num];
                } else {
                    return 0;
                }
            }

        return 1;
    }

    public static int[] ordenador(int[] arr) {
        int[] copia = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < copia.length - 1; i++) {
            int menor_indice = buscaSelecao(copia, i);
            int temp = copia[i];
            copia[i] = copia[menor_indice];
            copia[menor_indice] = temp;
        }
        return copia;
    }


    public static int buscaBinaria(int[] lista, int item) {
        int[] ordenada = ordenador(lista);
        int baixo = 0;
        int alto = ordenada.length -1;

        while (baixo <= alto) {
            int meio = (baixo + alto) / 2;
            int chute = ordenada[meio];

            if (item == chute) {
                return meio;
            };
            if (item < chute) {
                alto = meio - 1;
            };
            if (item > chute) {
                baixo = meio + 1;
            };
        };

        return -1;
    };

    public static int fat(Integer x) {
        if (x == 1) {
            return 1;
        } else {
          return x * fat(x-1);
        }
    };
};