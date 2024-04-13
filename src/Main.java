import java.util.Random;

public class Main {
    public static void main(String[] args) {
       /* Random random = new Random();
        Lista lista = new Lista(null, null);
        for (int i = 0; i < 7; i++) {
            lista.inserirFinal(random.nextInt(1001));
        }*/
       /* lista.inserirFinal(4);
        lista.inserirFinal(9);
        lista.inserirFinal(1);
        lista.inserirFinal(18);
        lista.inserirFinal(8);
        lista.inserirFinal(5);
        lista.inserirFinal(3);*/
       // lista.exibir();

       // lista.timSort();

       //lista.exibir();
        Principal principal = new Principal();
        principal.geraArquivos();
        principal.shake_sort();
    }
}