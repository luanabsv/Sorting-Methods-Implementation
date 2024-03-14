import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Lista lista = new Lista(null, null);
        for (int i = 0; i < 8; i++) {

            lista.inserirFinal(random.nextInt(1001));
        }

        lista.exibir();

        lista.bubble_sort();

       lista.exibir();
    }
}