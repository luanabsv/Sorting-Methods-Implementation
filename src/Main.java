import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        Lista lista = new Lista(null, null);
        for (int i = 0; i < 7; i++) {
            lista.inserirFinal(random.nextInt(1001));
        }
        Lista listaCopia = copiarLista(lista);

        System.out.println("Desordeanado: ");
        lista.exibir();

        System.out.println("Inserção Direta: ");
        listaCopia = copiarLista(lista);
        listaCopia.insertion_sort();
        listaCopia.exibir();

        System.out.println("Inserção Binária: ");
        listaCopia = copiarLista(lista);
        listaCopia.bynary_insertion_sort();
        listaCopia.exibir();

        System.out.println("Seleção Direta: ");
        listaCopia = copiarLista(lista);
        listaCopia.selection_sort();
        listaCopia.exibir();

        System.out.println("Bubble Sort: ");
        listaCopia = copiarLista(lista);
        listaCopia.bubble_sort();
        listaCopia.exibir();

        System.out.println("Shake Sort: ");
        listaCopia = copiarLista(lista);
        listaCopia.shake_sort();
        listaCopia.exibir();

        System.out.println("Shell Sort: ");
        listaCopia = copiarLista(lista);
        listaCopia.shell_sort();
        listaCopia.exibir();

        System.out.println("Heap Sort: ");
        listaCopia = copiarLista(lista);
        listaCopia.heap_soart();
        listaCopia.exibir();

        System.out.println("Quick c/ pivo: ");
        listaCopia = copiarLista(lista);
        listaCopia.quickcpivo();
        listaCopia.exibir();

        System.out.println("Quick s/ pivo: ");
        listaCopia = copiarLista(lista);
        listaCopia.quickspivo();
        listaCopia.exibir();

        System.out.println("Heap Sort: ");
        listaCopia = copiarLista(lista);
        listaCopia.heap_soart();
        listaCopia.exibir();

        System.out.println("Counting Sort: ");
        listaCopia = copiarLista(lista);
        listaCopia.counting_sort();
        listaCopia.exibir();

        System.out.println("Radix Sort: ");
        listaCopia = copiarLista(lista);
        listaCopia.radix_sort();
        listaCopia.exibir();

        System.out.println("Comb Sort: ");
        listaCopia = copiarLista(lista);
        listaCopia.comb_sort();
        listaCopia.exibir();

        System.out.println("Gnome Sort: ");
        listaCopia = copiarLista(lista);
        listaCopia.gnome_sort();
        listaCopia.exibir();

        Principal principal = new Principal();
        //principal.geraTabela();
    }

    public static Lista copiarLista(Lista listaOriginal) {
        Lista copia = new Lista(null, null);
        No atual = listaOriginal.getInicio();

        while (atual != null) {
            copia.inserirFinal(atual.getInfo());
            atual = atual.getProximo();
        }

        return copia;
    }
}