

public class Principal {

    Arquivo arqOrd, arqRev, arqRand, auxRev, auxRand;

    public void geraArquivos() {
        arqOrd = new Arquivo("ArquivoOrdenado.dat");
        arqRev = new Arquivo("ArquivoReverso.dat");
        arqRand = new Arquivo("ArquivoRandomico.dat");
        auxRand = new Arquivo("copiaarqrev.dat");
        //auxRev = new Arquivo("copiaarqrev.dat");
        //arqOrd.geraArquivoOrdenado();
        arqRand.geraArquivoDesordenado();
        auxRand.copiaArq(arqRand.getFile());
        //auxRand.exibirArq();
        //arqRev.geraArquivoReverso();
        //auxRev.copiaArq(arqRev.getFile());
       // arqRev.exibirArq();

        /*arqOrd.geraArquivoReverso();
        arqOrd.exibirArq();*/
        System.out.println("-------------------------------------");
        //arqRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
    }

    public void bubble() {
        //arqOrd.bubble_sort();
        //arqOrd.exibirArq();

        arqOrd.exibirArq();
        arqOrd.bubble_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();
    }

    public void insertion() {
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.insertion_sort();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();

       /* auxRev.insertion_sort();
        auxRev.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRev.exibirArq();*/

       /* arqOrd.exibirArq();
        System.out.println("-------------------------------------");
        arqOrd.insertion_sort();
        arqOrd.exibirArq();*/
    }


}