

public class Principal {

    Arquivo arqOrd, arqRev, arqRand, auxRev, auxRand;

    public void geraArquivos() {
        arqOrd = new Arquivo("ArquivoOrdenado.dat");
        arqRev = new Arquivo("ArquivoReverso.dat");
        arqRand = new Arquivo("ArquivoRandomico.dat");
         auxRand = new Arquivo("copiaarqrev.dat");
        //arqOrd.geraArquivoOrdenado();
        arqRand.geraArquivoDesordenado();
        auxRand.copiaArq(arqRand.getFile());
        auxRand.exibirArq();

        //arqRev.geraArquivoReverso();
        //auxRev.copiaArq(arqRev.getFile());
        //arqOrd.exibirArq();
        System.out.println("-------------------------------------");
        //arqRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
    }

    public void bubble() {
        //arqOrd.bubble_sort();
        //arqOrd.exibirArq();

        auxRand.bubble_sort();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();
    }


}