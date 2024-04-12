import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Arquivo {

    private String nomearquivo;
    private RandomAccessFile arquivo;

    public Arquivo(String nomearquivo)
    {
        try
        {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e)
        { }
    }

    public RandomAccessFile getFile() {
        return arquivo;
    }

    public void truncate(long pos)
    {
        try
        {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc)
        { }
    }

    public boolean eof()
    {
        boolean retorno = false;
        try
        {
            if (arquivo.getFilePointer() == arquivo.length())
                retorno = true;
        } catch (IOException e)
        { }
        return (retorno);
    }

    //insere um Registro no final do arquivo, passado por par�metro
    public void inserirRegNoFinal(Registro reg)
    {
        seekArq(filesize());//ultimo byte
        reg.gravaNoArq(arquivo);
    }

    public int filesize() {
        try {
            return  (int)arquivo.length() / Registro.length();
        } catch (IOException e) {
            return 0;
        }
    }

    public void exibirArq()
    {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while (!this.eof())
        {
            //System.out.println("Posicao " + i);
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
    }

    public void exibirUmRegistro(int pos)
    {
        Registro aux = new Registro();
        seekArq(pos);
        //System.out.println("Posicao " + pos);
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }

    public void seekArq(int pos)
    {
        try
        {
            arquivo.seek(pos * Registro.length());
        } catch (IOException e)
        { }
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

    public void bubble_sort() {
        int comp = 0, mov = 0;
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();
        int tam = filesize();
        boolean troca = true;

        while(tam > 1 && troca) {
            troca = false;

            for(int i = 0; i < tam - 1; i++) {
                seekArq(i);
                reg1.leDoArq(arquivo);
                reg2.leDoArq(arquivo);

                comp++;
                if (reg1.getNumero() > reg2.getNumero()) {
                    seekArq(i);
                    mov++;
                    mov++;
                    reg2.gravaNoArq(arquivo);
                    reg1.gravaNoArq(arquivo);
                    troca = true;
                }
            }
            tam--;
        }

        System.out.println("Permutações: " + mov);
        System.out.println("Comparações: " + comp);
    }

    public void insertion_sort() {
        Registro regPos = new Registro();
        Registro regAntPos = new Registro();
        int tam = filesize(), i = 1, pos, comp = 0, mov = 0;

        while (i < tam) {
            pos = i;
            seekArq(pos);
            regPos.leDoArq(arquivo);
            seekArq(pos - 1);
            regAntPos.leDoArq(arquivo);

            comp++;
            while (pos > 0 && regAntPos.getNumero() > regPos.getNumero()) {
                seekArq(pos);
                mov++;
                regAntPos.gravaNoArq(arquivo);
                pos--;
                if (pos > 0) {
                    seekArq(pos - 1);
                    regAntPos.leDoArq(arquivo);
                }
            }

            seekArq(pos);
            if(pos != i) {
                mov++;
                regPos.gravaNoArq(arquivo);
            }
            i++;
        }
        System.out.println("Movimentações: " + mov);
        System.out.println("Comparações: " + comp);
    }

    public void executa()
    {
        exibirArq();
    }

    //m�todo principal
   /* public static void main(String args[])
    {
        Arquivo a = new Arquivo("c:\\arquivo.dat");
        a.executa();
    }*/

}
