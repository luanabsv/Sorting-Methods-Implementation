import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Arquivo {

    private String nomearquivo;
    private RandomAccessFile arquivo;

    private int comparacoes = 0;
    private int movimentacoes = 0;

    public Arquivo(String nomearquivo) {
        try {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e) {
        }
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }

    public int getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(int movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public RandomAccessFile getFile() {
        return arquivo;
    }

    public void truncate(long pos) {
        try {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc) {
        }
    }

    public boolean eof() {
        boolean retorno = false;
        try {
            if (arquivo.getFilePointer() == arquivo.length())
                retorno = true;
        } catch (IOException e) {
        }
        return (retorno);
    }

    //insere um Registro no final do arquivo, passado por par�metro
    public void inserirRegNoFinal(Registro reg) {
        seekArq(filesize());//ultimo byte
        reg.gravaNoArq(arquivo);
    }

    public int filesize() {
        try {
            return (int) arquivo.length() / Registro.length();
        } catch (IOException e) {
            return 0;
        }
    }

    public void exibirArq() {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while (!this.eof()) {
            //System.out.println("Posicao " + i);
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
    }

    public void exibirUmRegistro(int pos) {
        Registro aux = new Registro();
        seekArq(pos);
        //System.out.println("Posicao " + pos);
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }

    public void seekArq(int pos) {
        try {
            arquivo.seek(pos * Registro.length());
        } catch (IOException e) {
        }
    }

    public void geraArquivoOrdenado(int tam) {
        Registro reg;
        for (int i = 1; i <= tam; i++) {
            reg = new Registro(i);
            reg.gravaNoArq(arquivo);
        }
    }

    public void geraArquivoDesordenado(int tam) {
        Registro reg;
        Random random = new Random();
        for (int i = 0; i < tam; i++) {
            reg = new Registro(random.nextInt(1000));
            reg.gravaNoArq(arquivo);
        }
    }

    public void geraArquivoReverso(int tam) {
        Registro reg;
        for (int i = tam; i > 0; i--) {
            reg = new Registro(i);
            reg.gravaNoArq(arquivo);
        }
    }



    public void copiaArq(RandomAccessFile arquivoOrigem) {
        try {
            Registro reg = new Registro();
            int i = 0, tam = (int) arquivoOrigem.length() / Registro.length();
            this.arquivo = new RandomAccessFile("temp.dat", "rw");
            truncate(0);
            arquivoOrigem.seek(0);
            while (i < tam) {
                reg.leDoArq(arquivoOrigem);
                reg.gravaNoArq(arquivo);
                i++;
            }
        } catch (IOException e) {

        }
    }

    public int returnMaior() {
        int maior;
        Registro reg = new Registro();
        seekArq(0);
        reg.leDoArq(arquivo);
        maior = reg.getNumero();

        for (int i = 1; i < filesize(); i++) {
            reg.leDoArq(arquivo);
            comparacoes++;
            if (maior < reg.getNumero())
                maior = reg.getNumero();
        }

        return maior;
    }
    //.............................................................................
    /*

    insira aqui os m�todos de Ordena��o;

    */

    public void insertion_sort() {
        Registro regPos = new Registro();
        Registro regAntPos = new Registro();
        int tam = filesize(), i = 1, pos;

        while (i < tam) {
            pos = i;
            seekArq(pos);
            regPos.leDoArq(arquivo);
            seekArq(pos - 1);
            regAntPos.leDoArq(arquivo);

            comparacoes++;
            while (pos > 0 && regAntPos.getNumero() > regPos.getNumero()) {
                seekArq(pos);
                movimentacoes++;
                regAntPos.gravaNoArq(arquivo);
                pos--;
                if (pos > 0) {
                    seekArq(pos - 1);
                    regAntPos.leDoArq(arquivo);
                }
            }

            seekArq(pos);
            if (pos != i) {
                movimentacoes++;
                regPos.gravaNoArq(arquivo);
            }
            i++;
        }
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    private int binary_search(int info, int tl) {
        int ini = 0, fim = tl - 1, meio = fim / 2;
        Registro regMeio = new Registro();

        seekArq(meio);
        regMeio.leDoArq(arquivo);
        comparacoes++;
        while (ini < fim && info != regMeio.getNumero()) {
            comparacoes++;
            if (info < regMeio.getNumero())
                fim = meio - 1;
            else
                ini = meio + 1;

            meio = (ini + fim) / 2;
            seekArq(meio);
            regMeio.leDoArq(arquivo);
        }

        comparacoes++;
        if (info > regMeio.getNumero())
            return meio + 1;
        return meio;
    }

    public void binary_insertion_sort() {
        int pos;
        Registro reg = new Registro();
        Registro regAntJ = new Registro();

        for (int i = 1; i < filesize(); i++) {
            seekArq(i);
            reg.leDoArq(arquivo);
            pos = binary_search(reg.getNumero(), i);

            for (int j = i; j > pos; j--) {
                seekArq(j - 1);
                regAntJ.leDoArq(arquivo);
                regAntJ.gravaNoArq(arquivo);
                movimentacoes++;
            }
            movimentacoes++;
            seekArq(pos);
            reg.gravaNoArq(arquivo);
        }

        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public void selection_sort() {
        Registro regJ = new Registro();
        Registro regPosMenor = new Registro();
        int i = 0;

        while (i < filesize() - 1) {
            int posMenor = i;
            seekArq(posMenor);
            regPosMenor.leDoArq(arquivo);

            int j = i + 1;

            while (j < filesize()) {
                seekArq(j);
                regJ.leDoArq(arquivo);


                this.comparacoes++;
                if (regJ.getNumero() < regPosMenor.getNumero()) {
                    posMenor = j;
                    seekArq(posMenor);
                    regPosMenor.leDoArq(arquivo);
                }
                j++;
            }

            if (posMenor != i) {

                seekArq(i);
                regJ.leDoArq(arquivo);

                seekArq(posMenor);
                movimentacoes++;
                regJ.gravaNoArq(arquivo);

                seekArq(i);
                movimentacoes++;
                regPosMenor.gravaNoArq(arquivo);
            }
            i++;
        }

        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public void bubble_sort() {
        movimentacoes = 0;
        comparacoes = 0;
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();
        int tam = filesize();
        boolean troca = true;

        while (tam > 1 && troca) {
            troca = false;

            for (int i = 0; i < tam - 1; i++) {
                seekArq(i);
                reg1.leDoArq(arquivo);
                reg2.leDoArq(arquivo);

                comparacoes++;
                if (reg1.getNumero() > reg2.getNumero()) {
                    seekArq(i);
                    movimentacoes++;
                    movimentacoes++;
                    reg2.gravaNoArq(arquivo);
                    reg1.gravaNoArq(arquivo);
                    troca = true;
                }
            }
            tam--;
        }

        System.out.println("Permutações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public void shake_sort() {
        int inicio = 0, fim = filesize() - 1;
        Registro regAtual = new Registro();
        Registro regAux = new Registro();

        while (inicio < fim) {
            for (int i = 0; i < fim; i++) {
                seekArq(i);
                regAtual.leDoArq(arquivo);
                regAux.leDoArq(arquivo);
                comparacoes++;

                if (regAtual.getNumero() > regAux.getNumero()) {
                    seekArq(i);
                    movimentacoes += 2;
                    regAux.gravaNoArq(arquivo);
                    regAtual.gravaNoArq(arquivo);
                }
            }
            fim--;

            for (int i = fim; i > inicio; i--) {
                seekArq(i - 1);
                regAux.leDoArq(arquivo);
                regAtual.leDoArq(arquivo);

                comparacoes++;
                if (regAtual.getNumero() < regAux.getNumero()) {
                    seekArq(i - 1);
                    movimentacoes += 2;
                    regAtual.gravaNoArq(arquivo);
                    regAux.gravaNoArq(arquivo);
                }
            }
            inicio++;
        }

        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public void shell_sort() {
        int i, j, dist = 1;
        Registro regAux = new Registro();
        Registro regJDist = new Registro();

        while (dist < filesize())
            dist = dist * 3 + 1;
        dist = dist / 3;

        while (dist > 0) {
            for (i = dist; i < filesize(); i++) {
                seekArq(i);
                regAux.leDoArq(arquivo);

                j = i;

                seekArq(j - dist);
                regJDist.leDoArq(arquivo);
                while (j - dist >= 0 && regAux.getNumero() < regJDist.getNumero()) {
                    seekArq(j);
                    movimentacoes++;
                    regJDist.gravaNoArq(arquivo);
                    j = j - dist;

                    seekArq(j - dist);
                    regJDist.leDoArq(arquivo);
                    comparacoes++;
                }
                comparacoes++;

                seekArq(j);
                movimentacoes++;
                regAux.gravaNoArq(arquivo);
            }
            dist = dist / 3;
        }
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public void heap_sort() {
        int fim = filesize(), fe, maiorF, pai;
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();
        Registro regFim = new Registro();
        Registro regIni = new Registro();

        while (fim > 1) {
            pai = fim / 2 - 1;

            while (pai >= 0) {
                fe = 2 * pai + 1;
                maiorF = fe;

                seekArq(fe);
                reg1.leDoArq(arquivo);
                reg2.leDoArq(arquivo);

                comparacoes++;
                if (fe + 1 < fim && reg2.getNumero() > reg1.getNumero())
                    maiorF = fe + 1;

                seekArq(maiorF);
                reg1.leDoArq(arquivo);
                seekArq(pai);
                reg2.leDoArq(arquivo);

                comparacoes++;
                if (reg1.getNumero() > reg2.getNumero()) {
                    seekArq(pai);
                    movimentacoes += 2;
                    reg1.gravaNoArq(arquivo);
                    seekArq(maiorF);
                    reg2.gravaNoArq(arquivo);
                }

                pai--;
            }

            movimentacoes += 2;
            seekArq(0);
            regIni.leDoArq(arquivo);
            seekArq(fim - 1);
            regFim.leDoArq(arquivo);

            seekArq(0);
            regFim.gravaNoArq(arquivo);
            seekArq(fim - 1);
            regIni.gravaNoArq(arquivo);
            fim--;
        }
    }


    public void quickspivo() {
        quicksp(0, filesize() - 1);
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }
    private void quicksp(int ini, int fim){
        int i = ini, j = fim;
        boolean flag = true;
        Registro regI = new Registro();
        Registro regJ = new Registro();

        while(i < j) {
            seekArq(i);
            regI.leDoArq(arquivo);

            seekArq(j);
            regJ.leDoArq(arquivo);

            if (flag) {
                comparacoes++;
                while(i < j && regI.getNumero() <= regJ.getNumero()) {
                    i++;
                    seekArq(i);
                    regI.leDoArq(arquivo);
                    comparacoes++;
                }
            } else {
                comparacoes++;
                while(i < j && regJ.getNumero() >= regI.getNumero()) {
                   j--;
                   seekArq(j);
                   regJ.leDoArq(arquivo);
                   comparacoes++;
               }
            }

            movimentacoes+=2;
            seekArq(i);
            regI.leDoArq(arquivo);
            seekArq(j);
            regJ.leDoArq(arquivo);

            seekArq(i);
            regJ.gravaNoArq(arquivo);
            seekArq(j);
            regI.gravaNoArq(arquivo);
        }

        if (ini < i - 1)
            quicksp(ini, i - 1);
        if (j + 1 < fim)
            quicksp(j + 1, fim);
    }

    public void quickcpivo(){
        quickcp(0, filesize()-1);
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    private void quickcp(int ini, int fim) {
        int i = ini, j = fim;
        Registro regPivo = new Registro();
        Registro regI = new Registro();
        Registro regJ = new Registro();

        seekArq((ini + fim) / 2);
        regPivo.leDoArq(arquivo);

        while (i < j) {
            seekArq(i);
            regI.leDoArq(arquivo);

            comparacoes++;
            while (regI.getNumero() < regPivo.getNumero()) {
                i++;
                seekArq(i);
                regI.leDoArq(arquivo);
                comparacoes++;
            }

            seekArq(j);
            regJ.leDoArq(arquivo);

            comparacoes++;
            while(regJ.getNumero() > regPivo.getNumero()) {
                j--;
                seekArq(j);
                regJ.leDoArq(arquivo);
                comparacoes++;
            }

            if (i <= j) {
                seekArq(i);
                movimentacoes += 2;
                regJ.gravaNoArq(arquivo);

                seekArq(j);
                regI.gravaNoArq(arquivo);
                i++;
                j--;
            }
        }

        if (ini < j)
            quickcp(ini, j);
        if (i < fim)
            quickcp(i, fim);
    }

    public void fusao(Arquivo mergeAux1, Arquivo mergeAux2, int seq) {
        int i = 0, j = 0, k = 0, auxSeq = seq;
        Registro regAux1 = new Registro();
        Registro regAux2 = new Registro();
        while (k < filesize()) {
            while (i < seq && j < seq) {
                mergeAux1.seekArq(i);
                regAux1.leDoArq(mergeAux1.getFile());
                mergeAux2.seekArq(j);
                regAux2.leDoArq(mergeAux2.getFile());

                comparacoes++;
                if (regAux1.getNumero() < regAux2.getNumero()) {
                    i++;
                    seekArq(k++);
                    regAux1.gravaNoArq(arquivo);
                    movimentacoes++;
                }
                else {
                    j++;
                    seekArq(k++);
                    regAux2.gravaNoArq(arquivo);
                    movimentacoes++;
                }
            }

            while (i < seq) {
                mergeAux1.seekArq(i++);
                regAux1.leDoArq(mergeAux1.getFile());
                seekArq(k++);
                regAux1.gravaNoArq(arquivo);
                movimentacoes++;
            }
            while (j < seq) {
                mergeAux2.seekArq(j++);
                regAux2.leDoArq(mergeAux2.getFile());
                seekArq(k++);
                regAux2.gravaNoArq(arquivo);
                movimentacoes++;
            }
            seq = seq + auxSeq;
        }
    }

    public void particao(Arquivo mergeAux1, Arquivo mergeAux2){
        int fileSize = filesize() / 2;
        Registro regI = new Registro();

        for (int i = 0; i < fileSize; i++) {
            seekArq(i);
            regI.leDoArq(arquivo);
            mergeAux1.seekArq(i);
            regI.gravaNoArq(mergeAux1.getFile());

            seekArq(i + fileSize);
            regI.leDoArq(arquivo);
            mergeAux2.seekArq(i);
            regI.gravaNoArq(mergeAux2.getFile());

            movimentacoes += 2;
        }
        mergeAux1.truncate(fileSize);
        mergeAux2.truncate(fileSize);
    }

    public void primeiro_merge() {
        int seq = 1;
        Arquivo mergeAux1 = new Arquivo("mergeAux1.dat");
        Arquivo mergeAux2 = new Arquivo("mergeAux2.dat");
        while (seq < filesize()) {
            particao(mergeAux1, mergeAux2);
            fusao(mergeAux1, mergeAux2, seq);
            seq = seq * 2;
        }
    }

    public void segundo_merge() {
        Arquivo mergeAux = new Arquivo("mergeAux.dat");
        merge(mergeAux, 0, filesize() -1);
    }

    private void merge(Arquivo mergeAux, int esq, int dir) {
        int meio;

        if (esq < dir) {
            meio = (esq + dir) / 2;
            merge(mergeAux, esq, meio);
            merge(mergeAux, meio + 1, dir);
            fusao2(mergeAux, esq, meio, meio + 1, dir);
        }
    }

    private void fusao2(Arquivo mergeAux, int ini1, int fim1, int ini2, int fim2) {
        int i = ini1, j = ini2, k = 0;
        Registro regI = new Registro();
        Registro regJ = new Registro();
        Registro regAux = new Registro();

        while (i <= fim1 && j <= fim2) {
            seekArq(i);
            regI.leDoArq(arquivo);
            seekArq(j);
            regJ.leDoArq(arquivo);

            comparacoes++;
            movimentacoes++;
            if (regI.getNumero() < regJ.getNumero()) {
                mergeAux.seekArq(k++);
                regI.gravaNoArq(mergeAux.getFile());
                i++;
            } else {
                mergeAux.seekArq(k++);
                regJ.gravaNoArq(mergeAux.getFile());
                j++;
            }
        }

        while (i <= fim1) {
            seekArq(i++);
            regI.leDoArq(arquivo);
            mergeAux.seekArq(k++);
            regI.gravaNoArq(mergeAux.getFile());
            movimentacoes++;
        }
        while (j <= fim2) {
            seekArq(j++);
            regJ.leDoArq(arquivo);
            mergeAux.seekArq(k++);
            regJ.gravaNoArq(mergeAux.getFile());
            movimentacoes++;
        }

        for (i = 0; i < k; i++) {
            mergeAux.seekArq(i);
            regAux.leDoArq(mergeAux.getFile());
            seekArq(i + ini1);
            regAux.gravaNoArq(arquivo);
            movimentacoes++;
        }
    }


    public void counting_sort() {
        int maior = returnMaior(), pos;
        int[] vetIndex = new int[maior], vetOrdenado = new int[filesize()];

        Registro reg = new Registro();

        for (int i = 0; i < maior; i++)
            vetIndex[i] = 0;

        for (int i = 0; i < filesize(); i++) {
            seekArq(i);
            reg.leDoArq(arquivo);
            vetIndex[reg.getNumero() - 1] += 1;
        }

        for (int i = 1; i < maior; i++)
            vetIndex[i] += vetIndex[i - 1];

        for (int i = 0; i < filesize(); i++) {
            seekArq(i);
            reg.leDoArq(arquivo);
            pos = reg.getNumero();
            vetOrdenado[vetIndex[pos - 1] - 1] = pos;
            vetIndex[pos - 1] -= 1;
        }

        for (int i = 0; i < filesize(); i++) {
            reg.setNumero(vetOrdenado[i]);
            seekArq(i);
            reg.gravaNoArq(arquivo);
            movimentacoes++;
        }
    }

    public void comb_sort() {
        int intervalo = filesize(), aux;
        Registro regI = new Registro();
        Registro regIIntervalo = new Registro();

        while (intervalo > 0) {
            intervalo = (int) (intervalo / 1.3);
            int i = 0;

            while (i + intervalo < filesize()) {
                seekArq(i);
                regI.leDoArq(arquivo);

                seekArq(i + intervalo);
                regIIntervalo.leDoArq(arquivo);

                comparacoes++;
                if (regI.getNumero() > regIIntervalo.getNumero()) {
                   seekArq(i);
                   movimentacoes+=2;
                   regIIntervalo.gravaNoArq(arquivo);
                   seekArq(i + intervalo);
                   regI.gravaNoArq(arquivo);
                }

                i++;
            }
        }
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public void gnome_sort() {
        int index = 1;
        Registro regI = new Registro();
        Registro regAnt = new Registro();

        while (index < filesize()) {
            seekArq(index - 1);
            regAnt.leDoArq(arquivo);
            regI.leDoArq(arquivo);

            comparacoes++;
            if (regI.getNumero() < regAnt.getNumero()) {
                seekArq(index - 1);
                movimentacoes += 2;
                regI.gravaNoArq(arquivo);
                regAnt.gravaNoArq(arquivo);

                if (index > 1) {
                    index--;
                }
            } else
                index++;
        }

        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public void executa() {
        exibirArq();
    }

    //m�todo principal
   /* public static void main(String args[])
    {
        Arquivo a = new Arquivo("c:\\arquivo.dat");
        a.executa();
    }*/

}
