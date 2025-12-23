public class BuscaBinaria {
    public static int buscaBinaria(int[] lista, int item) {
        int baixo = 0;
        int alto = lista.length -1;

        while (baixo <= alto) {
            int meio = (baixo + alto) / 2;
            int chute = lista[meio];

            if (item == chute) {
                return meio;
            }
            if (item < chute) {
                alto = meio - 1;
            }
            if (item > chute) {
                baixo = meio + 1;
            }
        }

        return -1;
    }

    static void main(String [] args) {
        int[] minhaLista = {1,4,7,12,20,56,90};
        System.out.println(buscaBinaria(minhaLista, 12));
    }
}