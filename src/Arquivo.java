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

    public void geraArquivoOrdenado() {
        Registro reg;
        for (int i = 0; i < 8; i++) {
            reg = new Registro(i);
            reg.gravaNoArq(arquivo);
        }
    }

    public void geraArquivoDesordenado() {
        Registro reg;
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            reg = new Registro(random.nextInt(1001));
            reg.gravaNoArq(arquivo);
        }
    }

    public void geraArquivoReverso() {
        Registro reg;
        Random random = new Random();
        for (int i = 8; i > 0; i--) {
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
        while(ini < fim && info != regMeio.getNumero()) {
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

        while(dist < filesize())
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

        while(fim > 1) {
            pai = fim / 2 - 1;

            while(pai >= 0) {
                fe = 2 * pai + 1;
                maiorF = fe;

                seekArq(fe);
                reg1.leDoArq(arquivo);
                reg2.leDoArq(arquivo);

                if (fe + 1 < fim && reg2.getNumero() > reg1.getNumero())
                    maiorF = fe + 1;

                seekArq(maiorF);
                reg1.leDoArq(arquivo);
                seekArq(pai);
                reg2.leDoArq(arquivo);

                if (reg1.getNumero() > reg2.getNumero()) {
                    seekArq(pai);
                    reg1.gravaNoArq(arquivo);
                    seekArq(maiorF);
                    reg2.gravaNoArq(arquivo);
                }

                pai--;
            }

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
