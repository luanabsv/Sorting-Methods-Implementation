import java.io.IOException;
import java.io.RandomAccessFile;

public class Principal {
    long tempoInicio, tempoFinal, timeStartAll, tempoFinalTotal;
    Arquivo arqOrd, arqRev, arqRand, auxRev, auxRand, copia;

    int comparacoes, movimentacoes, tam = 1024;
    RandomAccessFile tabela;

    public void geraArquivos() throws IOException {
        arqOrd = new Arquivo("ArquivoOrdenado.dat");
        arqRev = new Arquivo("ArquivoReverso.dat");
        arqRand = new Arquivo("ArquivoRandomico.dat");
        auxRand = new Arquivo("copiaarqrev.dat");
        auxRev = new Arquivo("copiaarqrev.dat");

        gerarArquivos();
        //arqOrd.geraArquivoOrdenado();
        System.out.println("Arquivo Randomico");
        arqRand.geraArquivoDesordenado(tam);
        auxRand.copiaArq(arqRand.getFile());
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        auxRand.quickcpivo();
        auxRand.exibirArq();

        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("Arquivo Reverso");
        arqRev.geraArquivoReverso(tam);
        arqRev.exibirArq();
        System.out.println("-------------------------------------");
        auxRev.copiaArq(arqRev.getFile());
        auxRev.quickcpivo();
        auxRev.exibirArq();


        //auxRand.exibirArq();
        //auxRev.exibirArq();
        //arqOrd.geraArquivoReverso();
        //arqOrd.exibirArq();
        System.out.println("-------------------------------------");
        //arqRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
    }

    public void createFiles() throws IOException {
        System.out.println("Wait, creating files...\n\n");
        gerarArquivos();
        arqOrd.geraArquivoOrdenado(tam);
        arqRand.geraArquivoDesordenado(tam);
        arqRev.geraArquivoReverso(tam);
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
     //   this.selection();
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

    public void binary_insertion_sort() {
        /*auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.binary_insertion_sort();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();*/

        /*arqOrd.exibirArq();
        arqOrd.binary_insertion_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();*/

        arqRev.exibirArq();
        auxRev.binary_insertion_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRev.exibirArq();
    }

    public void selection() {
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.selection_sort();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();

        /*arqOrd.exibirArq();
        arqOrd.selection_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();*/

        /*arqRev.exibirArq();
        auxRev.selection_sort();
        auxRev.exibirArq();*/
    }

    public void shake_sort() {
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.shake_sort();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();

        /*arqOrd.exibirArq();
        arqOrd.shake_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();*/

       /* arqRev.exibirArq();
        auxRev.shake_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRev.exibirArq();*/
    }

    public void shell_sort () {
       /* auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.shell_sort();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();*/

        /*arqOrd.exibirArq();
        arqOrd.shell_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();*/

        arqRev.exibirArq();
        auxRev.shell_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRev.exibirArq();
    }

    public void heap_sort() {
        /*auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.heap_sort();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();*/

       /* arqOrd.exibirArq();
        arqOrd.heap_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();*/

       arqRev.exibirArq();
        auxRev.heap_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRev.exibirArq();
    }

    public void quickspivo() {
       /* auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.quickspivo();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();*/

       /* arqOrd.exibirArq();
        arqOrd.quickspivo();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();*/

        arqRev.exibirArq();
        auxRev.quickspivo();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRev.exibirArq();
    }

    public void quickcpivo() {
        /*auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.quickcpivo();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();*/

       arqOrd.exibirArq();
        arqOrd.quickcpivo();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();

        /*arqRev.exibirArq();
        auxRev.quickcpivo();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRev.exibirArq();*/
    }
    public void comb_sort() {
        /*auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.comb_sort();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();*/

        /*arqOrd.exibirArq();
        arqOrd.comb_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();*/

        arqRev.exibirArq();
        auxRev.comb_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRev.exibirArq();
    }

    public void gnome_sort() {
        /*auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRand.gnome_sort();
        auxRand.exibirArq();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqRand.exibirArq();*/

        arqOrd.exibirArq();
        arqOrd.gnome_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        arqOrd.exibirArq();

        /*arqRev.exibirArq();
        auxRev.gnome_sort();
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        auxRev.exibirArq();*/
    }


    public void gerarArquivos() throws IOException {
        arqOrd = new Arquivo("ArquivoOrdenado.dat");
        arqRand = new Arquivo("ArquivoRandomico.dat");
        arqRev = new Arquivo("ArquivoReverso.dat");
        java.io.File fileCopyAux = new java.io.File("copiaArq.txt");

        /*if (fileCopyAux.exists())
            fileCopyAux.delete();*/

        copia = new Arquivo("copiaArq.dat");
        java.io.File tableFile = new java.io.File("Tabela.txt");
        if (tableFile.exists())
            tableFile.delete();
        try {
            tabela = new RandomAccessFile(tableFile, "rw");
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    void gravarTopo() throws IOException {
        tabela.writeBytes("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        tabela.writeBytes(String.format("%-25s%-80s%-80s%-80s%n", "| Sorting Algorithms", "| Sorted File", "| Reverse File", "| Randomic File                                                                 |"));
        tabela.writeBytes("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        tabela.writeBytes("|                        |  Comp.Prog. *  |  Comp.Equa. #  |  Mov.Prog. +  |  Mov Equa. -   |    Time    |  Comp.Prog. *  |  Comp.Equa. #  |  Mov.Prog. +  |  Mov Equa. -   |    Time    |  Comp.Prog. *  |  Comp.Equa. #  |  Mov.Prog. +  |  Mov Equa. -   |    Time    |\n");
        tabela.writeBytes("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    public void teste() throws IOException {
        gerarArquivos();
        createFiles();
        gravarTopo();
        runInsertionSort();
        runBinnaryInsertionSort();
        runSelectionSort();
        runBubbleSort();
        runShakeSort();
        runShellSort();
        runHeapSort();
        runQuickSPivo();
        runQuickCPivo();
    }

    private void runInsertionSort() throws IOException {
        copia.copiaArq(arqOrd.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.insertion_sort();
        tempoFinal = System.currentTimeMillis();
        long duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("| %-22s |  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", "Insertion Sort", copia.getComparacoes(), tam - 1, copia.getMovimentacoes(), 3 * (tam - 1), duration));

        copia.copiaArq(arqRev.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.insertion_sort();
        tempoFinal = System.currentTimeMillis();

        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", copia.getComparacoes(), (tam * tam + tam - 4) / 4, copia.getMovimentacoes(), (tam * tam + 3 * tam - 4) / 2, duration));

        copia.copiaArq(arqRand.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.insertion_sort();
        tempoFinal = System.currentTimeMillis();
        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s |\n", copia.getComparacoes(), (tam * tam + tam - 2) / 4, copia.getMovimentacoes(), ((tam * tam + 9 * tam - 10 ) / 4), duration));
        tabela.writeBytes("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    private  void runBinnaryInsertionSort() throws IOException {
        copia.copiaArq(arqOrd.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.binary_insertion_sort();
        tempoFinal = System.currentTimeMillis();
        long duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("| %-22s |  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", "Binnary Insertion", copia.getComparacoes(),  tam * (Math.log(tam) - Math.log(Math.E) + 0.5)
                , copia.getMovimentacoes(), 3 * (tam - 1), duration));

        copia.copiaArq(arqRev.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.binary_insertion_sort();
        tempoFinal = System.currentTimeMillis();

        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", copia.getComparacoes(),  tam * (Math.log(tam) - Math.log(Math.E) + 0.5), copia.getMovimentacoes(), (Math.pow(tam, 2)+ 3 * tam - 4) / 2, duration));

        copia.copiaArq(arqRand.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.binary_insertion_sort();
        tempoFinal = System.currentTimeMillis();
        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s |\n", copia.getComparacoes(),  tam * (Math.log(tam) - Math.log(Math.E) + 0.5), copia.getMovimentacoes(), (Math.pow(tam, 2) + 9 * tam - 10) / 4 , duration));
        tabela.writeBytes("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    private void runSelectionSort() throws  IOException {
        copia.copiaArq(arqOrd.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.selection_sort();
        tempoFinal = System.currentTimeMillis();
        long duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("| %-22s |  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", "Selection Sort", copia.getComparacoes(), (tam*tam-tam)/2
                , copia.getMovimentacoes(), 3 * (tam - 1), duration));

        copia.copiaArq(arqRev.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.selection_sort();
        tempoFinal = System.currentTimeMillis();

        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", copia.getComparacoes(),  (tam*tam-tam)/2, copia.getMovimentacoes(), tam * tam / 4 + 3 * (tam - 1), duration));

        copia.copiaArq(arqRand.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.selection_sort();
        tempoFinal = System.currentTimeMillis();
        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s |\n", copia.getComparacoes(), (tam*tam-tam)/2, copia.getMovimentacoes(), tam * (Math.log(tam) + 0.577216) , duration));
        tabela.writeBytes("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    private void runBubbleSort() throws IOException {
        copia.copiaArq(arqOrd.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.bubble_sort();
        tempoFinal = System.currentTimeMillis();
        long duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("| %-22s |  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", "Bubble Sort", copia.getComparacoes(), (Math.pow(tam, 2)- tam) / 2, copia.getMovimentacoes(), 0, duration));

        copia.copiaArq(arqRev.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.bubble_sort();
        tempoFinal = System.currentTimeMillis();

        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", copia.getComparacoes(), (Math.pow(tam, 2)- tam) / 2, copia.getMovimentacoes(), 3 * (tam * tam - tam) / 4, duration));

        copia.copiaArq(arqRand.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.bubble_sort();
        tempoFinal = System.currentTimeMillis();
        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s |\n", copia.getComparacoes(), (Math.pow(tam, 2)- tam) / 2, copia.getMovimentacoes(), 3 * (tam * tam - tam) / 2, duration));
        tabela.writeBytes("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    public void runShakeSort() throws IOException {
        copia.copiaArq(arqOrd.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.shake_sort();
        tempoFinal = System.currentTimeMillis();
        long duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("| %-22s |  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", "Shake Sort", copia.getComparacoes(), (tam * tam - tam) / 2, copia.getMovimentacoes(), 0, duration));

        copia.copiaArq(arqRev.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.shake_sort();
        tempoFinal = System.currentTimeMillis();

        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", copia.getComparacoes(), (tam * tam - tam) / 2, copia.getMovimentacoes(), 3 * (tam * tam - tam) / 4, duration));

        copia.copiaArq(arqRand.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.shake_sort();
        tempoFinal = System.currentTimeMillis();
        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s |\n", copia.getComparacoes(), (tam * tam - tam) / 2, copia.getMovimentacoes(), 3 * (tam * tam - tam) / 2, duration));
        tabela.writeBytes("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    public void runShellSort() throws IOException {
        copia.copiaArq(arqOrd.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.shell_sort();
        tempoFinal = System.currentTimeMillis();
        long duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("| %-22s |  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", "Shell Sort", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));

        copia.copiaArq(arqRev.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.shell_sort();
        tempoFinal = System.currentTimeMillis();

        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));

        copia.copiaArq(arqRand.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.shell_sort();
        tempoFinal = System.currentTimeMillis();
        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s |\n", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));
        tabela.writeBytes("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    public void runHeapSort() throws IOException {
        copia.copiaArq(arqOrd.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.heap_sort();
        tempoFinal = System.currentTimeMillis();
        long duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("| %-22s |  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", "Heap Sort", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));

        copia.copiaArq(arqRev.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.heap_sort();
        tempoFinal = System.currentTimeMillis();

        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));

        copia.copiaArq(arqRand.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.heap_sort();
        tempoFinal = System.currentTimeMillis();
        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s |\n", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));
        tabela.writeBytes("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    public void runQuickSPivo() throws IOException {
        copia.copiaArq(arqOrd.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.quickspivo();
        tempoFinal = System.currentTimeMillis();
        long duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("| %-22s |  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", "Quick s/ pivo", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));

        copia.copiaArq(arqRev.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.quickspivo();
        tempoFinal = System.currentTimeMillis();

        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));

        copia.copiaArq(arqRand.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.quickspivo();
        tempoFinal = System.currentTimeMillis();
        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s |\n", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));
        tabela.writeBytes("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    public void runQuickCPivo() throws IOException {
        copia.copiaArq(arqOrd.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.quickcpivo();
        tempoFinal = System.currentTimeMillis();
        long duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("| %-22s |  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", "Quick c/ pivo", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));

        copia.copiaArq(arqRev.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.quickcpivo();
        tempoFinal = System.currentTimeMillis();

        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s ", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));

        copia.copiaArq(arqRand.getFile());
        copia.setComparacoes(0);
        copia.setMovimentacoes(0);
        tempoInicio = System.currentTimeMillis();
        copia.quickcpivo();
        tempoFinal = System.currentTimeMillis();
        duration = (tempoFinal - tempoInicio) / 1000;
        tabela.writeBytes(String.format("|  %-13s |  %-13s |  %-12s |  %-13s |   %-8s |\n", copia.getComparacoes(), -1, copia.getMovimentacoes(), -1, duration));
        tabela.writeBytes("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

}